import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import beans.*;

/**
 * Servlet implementation class PostMessage
 */
public class PostMessage extends HttpServlet {
	   
	HttpSession session;
	MessageDetails messageItem1;
	
    public PostMessage() {
        super();
    }

	/**
	 * doGet method
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * doPost method
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		session = request.getSession(true);
		messageItem1 = (MessageDetails) session.getAttribute("messageItem1");
		
		//Check if the message bean is being passed from the jsp
		if(messageItem1 == null) {
			messageItem1 = new MessageDetails();

			saveMessageDetailsAndForward(request, response);
		}
		else {
			String confirm = request.getParameter("confirm");
			String edit = request.getParameter("edit");
			String cancel = request.getParameter("cancel");
			
			if(confirm != null && confirm.equals("CONFIRM")) {
				
				//Add message to database
				addMessageToDatabase(request, response);
				
				//Setting MessageItem1 to null
				session.setAttribute("messageItem1", null);
				
				//Show messagelist
				getServletConfig().getServletContext().getRequestDispatcher("/ViewMessageList").forward(request, response);
			}
			else if(edit != null && edit.equals("EDIT")) {

				session.setAttribute("editBool", true);
				
				getServletConfig().getServletContext().getRequestDispatcher("/PostMessage.jsp").forward(request, response);
			}
			else if(cancel != null && cancel.equals("CANCEL")) {
				getServletConfig().getServletContext().getRequestDispatcher("/ViewMessageList.jsp").forward(request, response);
			}
		}
	}
	
	/*
	 * Save user entered details into a MessageDetails object
	 */
	private void saveMessageDetailsAndForward(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String post = request.getParameter("post");
		String cancel = request.getParameter("cancel");
		
		if(post != null && post.equals("POST MESSAGE")) { 
			messageItem1 = new MessageDetails();	//Creating new object
			
			//Setting the values of message bean
			messageItem1.setSubject(request.getParameter("subject").trim());
			messageItem1.setMessage(request.getParameter("messageBody").trim());
			messageItem1.setSenderName(((UserInfo) session.getAttribute("userInfo")).getUserName());
			
			//Setting the bean to the session object
			session.setAttribute("messageItem1", messageItem1);
			
			getServletConfig().getServletContext().getRequestDispatcher("/PostMessage.jsp").forward(request, response);
		}
		else if(cancel != null && cancel.equals("CANCEL")) {

			//Setting MessageItem1 to null
			session.setAttribute("messageItem1", null);
			
			getServletConfig().getServletContext().getRequestDispatcher("/ViewMessageList").forward(request, response);
		}
	}

	/*
	 * Adding the data to database
	 */
	private void addMessageToDatabase(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver").newInstance();
			
			//Creating new statement
			Connection conn = DriverManager.getConnection("jdbc:odbc:accdbJava");
			
			
			String uName = ((UserInfo) session.getAttribute("userInfo")).getUserName().trim();

			String SQLQuery = "INSERT INTO MESSAGE (User_ID, Heading, Body, DatePosted) " +
				    "SELECT ID, ?, ?, ? FROM USER WHERE UserName = ?";
			
			//Creating statement
			PreparedStatement stmt = conn.prepareStatement(SQLQuery);
			
			stmt.setString(1, messageItem1.getSubject());
			stmt.setString(2, messageItem1.getMessage());
			stmt.setDate(3, messageItem1.getDatePosted());
			stmt.setString(4, uName);
			
			//Executing the update
			stmt.executeUpdate();
			
			//Closing connection, statement
			stmt.close();
			conn.close();
		}
		catch(Exception e) {
			//do nothing
		}
		
		
	}

}

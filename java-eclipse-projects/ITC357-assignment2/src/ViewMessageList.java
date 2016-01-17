import java.io.*;
import java.sql.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import beans.*;

/**
 * Servlet implementation class ViewMessageList
 */
public class ViewMessageList extends HttpServlet {
    
	private HttpSession session;
	private String senderName;
	private MessageList list;
	private String searchTxt;
	private MessageList searchList;
	
    public ViewMessageList() {
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
		session = request.getSession();
		list = (MessageList) session.getAttribute("list");
		boolean sorted = false;
		String sortBy = request.getParameter("sortBy");
		
		//No need to sort if the list is empty
		if(sortBy != null && list != null) {
			//Check if user clicked for sorting and sort the data
			sorted = sortTableData(sortBy, request);
		}
		
		//Read data from database only if the list hasn't been sorted
		if(!sorted) {
			readDataAndSaveToList();
		}
				
		//Getting the values of the buttons
		String search = request.getParameter("search");
		String view = request.getParameter("view");
		String post = request.getParameter("post");
		String logout = request.getParameter("logout");
		
		//Check which button is pressed and forward accordingly
		if(search != null && search.equalsIgnoreCase("SEARCH")) {
			searchList = new MessageList();
			searchTxt = request.getParameter("searchTxt").trim();
			
			//Check the search string
			for(MessageDetails message: list.getMessageList()) {
				if(message.getMessage().contains(searchTxt) || message.getSubject().contains(searchTxt)) {
					//Adding item to the list
					searchList.addMessageDetails(message);
				}
			}
			
			//Setting the session object to session
			session.setAttribute("searchList", searchList);
			
			getServletConfig().getServletContext().getRequestDispatcher("/SearchList.jsp").forward(request, response);
			
		}
		else if(view != null && view.equalsIgnoreCase("VIEW MESSAGE")) {
			senderName = request.getParameter("senderName");
			
			//Check the senderName
			for(MessageDetails message: list.getMessageList()) {
				if(message.getSenderName().equals(senderName)) {
					
					//Setting the session object to session
					session.setAttribute("message", message);
				}		
			}
			
			getServletConfig().getServletContext().getRequestDispatcher("/ViewMessage.jsp").forward(request, response);
		}
		else if(post != null && post.equalsIgnoreCase("POST MESSAGE")) {
			getServletConfig().getServletContext().getRequestDispatcher("/PostMessage.jsp").forward(request, response);
		}
		else if(logout != null && logout.equalsIgnoreCase("LOGOUT")) {
			session.invalidate();	//Invalidating the session object
			getServletConfig().getServletContext().getRequestDispatcher("/Login.jsp").forward(request, response);
		}
		else {
			getServletConfig().getServletContext().getRequestDispatcher("/ViewMessageList.jsp").forward(request, response);
		}
	}

	/*
	 * Populate the message table with message details
	 */
	private void readDataAndSaveToList() {
		
		list = new MessageList();
		
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver").newInstance();
			
			//Creating connection
			Connection conn = DriverManager.getConnection("jdbc:odbc:accdbJava");
			
			//Creating statement
			Statement stmt = conn.createStatement();
			
			//Create resultset
			ResultSet rSet = stmt.executeQuery("SELECT Heading, DatePosted, Body, UserName FROM User, Message WHERE Message.User_ID = User.ID");
			
			MessageDetails mItem = null;

			while(rSet.next()) {
				mItem = new MessageDetails();
				
				mItem.setSubject(rSet.getString("Heading"));
				mItem.setDatePosted(rSet.getDate("DatePosted"));
				mItem.setSenderName(rSet.getString("UserName"));
				mItem.setMessage(rSet.getString("Body"));
				
				//Adding the message item to the list
				list.addMessageDetails(mItem);
				
			}

			//Adding the list bean to the session
			session.setAttribute("list", list);
			
			//Closing the connection, resultset and statement
			rSet.close();
			stmt.close();
			conn.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/*
	 * Check the clicked link and sort accordingly
	 */
	private boolean sortTableData(String sortBy, HttpServletRequest request) {
		List<MessageDetails> messageList = list.getMessageList();
		
		if(sortBy != null && sortBy.equals("senderName")) {
			for(int i=0; i<messageList.size(); i++) {
				for(int j=i; j<messageList.size(); j++) {
					if(messageList.get(i).getSenderName().compareTo(messageList.get(j).getSenderName()) > 0) {
						//Swapping the objects
						Collections.swap(messageList, i, j);
					}
				}
			}
				
			//Setting the new sorted list to the session object
			session.setAttribute("list", list);
			return true;	
			
		}
		else if(sortBy != null && sortBy.equals("subject")) {
			for(int i=0; i<messageList.size(); i++) {
				for(int j=i; j<messageList.size(); j++) {
					if(messageList.get(i).getSubject().compareTo(messageList.get(j).getSubject()) > 0) {
						//Swapping the objects
						Collections.swap(messageList, i, j);
					}
				}
			}
				
			//Setting the new sorted list to the session object
			session.setAttribute("list", list);
			return true;
		}
		else if(sortBy != null && sortBy.equals("datePosted")) {
			for(int i=0; i<messageList.size(); i++) {
				for(int j=i; j<messageList.size(); j++) {
					if(messageList.get(i).getDatePosted().compareTo(messageList.get(j).getDatePosted()) > 0) {
						//Swapping the objects
						Collections.swap(messageList, i, j);
					}
				}
			}
			
			//Setting the new sorted list to the session object
			session.setAttribute("list", list);
			return true;
		}
		
		return false;
	}
}

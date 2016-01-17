import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import beans.*;

/**
 * Servlet implementation class Registration
 */
public class Registration extends HttpServlet {
	HttpSession session;
	NewUser nUser;
	
    public Registration() {
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
		nUser = new NewUser();
		
		String submit = request.getParameter("submit");
		String clear = request.getParameter("clear");
		String cancel = request.getParameter("cancel");
		
		if(submit != null && submit.equals("SUBMIT")) {
			String userName = request.getParameter("uName");
			
			nUser.setFName(request.getParameter("fName"));
			nUser.setLName(request.getParameter("lName"));
			nUser.setPWord(request.getParameter("pWord"));
			nUser.setUName(userName);
			
			//Setting an attribute as a userName
			session.setAttribute("newUser", userName);
			
			//Store the new user's data in database
			storeDataInDatabase();
			
			getServletConfig().getServletContext().getRequestDispatcher("/UploadImage.jsp").forward(request, response);
		}
		else if(clear != null && clear.equals("CLEAR")) {
			getServletConfig().getServletContext().getRequestDispatcher("/Registration.jsp").forward(request, response);
		}
		else if(cancel != null && cancel.equals("CANCEL")) {
			getServletConfig().getServletContext().getRequestDispatcher("/Login.jsp").forward(request, response);
		}
	}
	
	private void storeDataInDatabase() {
		
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver").newInstance();
			
			//Creating new Connection
			Connection conn = DriverManager.getConnection("Jdbc:Odbc:accdbJava");
			
			//Create new PreparedStatement
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO User (FirstName, LastName, UserName, Password) VALUES (?,?,?,?)");
			
			stmt.setString(1, nUser.getFName());
			stmt.setString(2, nUser.getLName());
			stmt.setString(3, nUser.getUName());
			stmt.setString(4, nUser.getPWord());
			
			//Executing the update
			stmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}

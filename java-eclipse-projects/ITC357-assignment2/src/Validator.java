import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import beans.*;

/**
 * Servlet implementation class Validator
 */
public class Validator extends HttpServlet {
    
	private String userName;
	private String password;
	private HttpSession session;
	private UserInfo userInfo;
	
    public Validator() {
        super();
    }

	/**
	 * goGet method
	 *  */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * doPost method
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		session = request.getSession(true);

		//Check if the variables are valid
		checkRequestParametersAndForward(request, response);		
	}

	/*
	 * Check the button clicked by the user
	 */
	public void checkRequestParametersAndForward(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//Creating new bean object
		userInfo = new UserInfo();
		
		userName = request.getParameter("userName").trim();
		password = request.getParameter("password").trim();
		
		String submit = request.getParameter("submit");
		String create = request.getParameter("create");
		
		//Check whether "SUBMIT" button is clicked
		if(submit != null && submit.equalsIgnoreCase("SUBMIT")) {
			//Setting the values of userName and password
			userInfo.setUserName(userName);
			userInfo.setPassword(password);

			//Setting the bean into the session
			session.setAttribute("userInfo", userInfo);
						
			//Validate user name and password
			if(validateUserNameAndPassword())
				getServletConfig().getServletContext().getRequestDispatcher("/ViewMessageList").forward(request, response);
			else
				getServletConfig().getServletContext().getRequestDispatcher("/Login.jsp").forward(request, response);
			
		}
		else if(create != null && create.equals("CREATE AN ACCOUNT")) {
			getServletConfig().getServletContext().getRequestDispatcher("/Registration.jsp").forward(request, response);
		}
		else {
			//Setting the values to empty strings for when the 
			//program starts or when "RESET" btn is clicked
			userInfo = new UserInfo();
				
			//Setting the bean into the session
			session.setAttribute("userInfo", userInfo);
			
			getServletConfig().getServletContext().getRequestDispatcher("/Login.jsp").forward(request, response);
		}
	}
	
	/*
	 * Check if user name and password is correct
	 */
	public boolean validateUserNameAndPassword() {

		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver").newInstance();
			
			//Creating new connection
			Connection conn = DriverManager.getConnection("jdbc:odbc:accdbJava");
			
			//Create statement
			Statement stmt = conn.createStatement();
			
			//Create result set
			ResultSet rSet = stmt.executeQuery("SELECT Password FROM User ");

			while(rSet.next()) {	//Move to new row of the database table
				String password = rSet.getString("Password");
				
				if(password.equals(this.password)) 
					return true;				
			}
			
			//Closing the connection, resultset and statement
			rSet.close();
			stmt.close();
			conn.close();
		}
		catch(Exception e) {
			//do nothing
		} 
		
		return false;
	}

}

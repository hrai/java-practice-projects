import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Validator extends HttpServlet {
	    
    public Validator() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		//call storeFormVariables method
		storeFormVariables(session, request);
		
		//check the form variables and redirect accordingly
		if(checkFormVariables(session, request)) {
			findCost(session);
			response.sendRedirect("/ITC357-assignment1/Confirm.jsp");
		}
		else {
			response.sendRedirect("/ITC357-assignment1/Registration.jsp");
		}
	}
	
	//Storing the variables from the form
	protected void storeFormVariables(HttpSession session, HttpServletRequest request) {
		//set session variables
		session.setAttribute("name", request.getParameter("name"));
		session.setAttribute("err_name", "");
		session.setAttribute("email", request.getParameter("email"));
		session.setAttribute("err_email", "");
		session.setAttribute("address", request.getParameter("address"));
		session.setAttribute("err_add", "");
		session.setAttribute("attendance", getAtten(request.getParameter("attendance")));		
		session.setAttribute("err_atten", "");
		session.setAttribute("discount", request.getParameter("discount"));
		session.setAttribute("dinner_atten", request.getParameter("dinner_atten"));
		session.setAttribute("err_dinner_atten", "");
		session.setAttribute("tickets", request.getParameter("tickets"));
		session.setAttribute("err_tickets", "");
		
	}
	
	//Setting attendance's value
	public String getAtten(String param) {
		String atten;
		
		if(param == null || param.equalsIgnoreCase("select"))
			atten = "select";
		else if(param.equalsIgnoreCase("bothDays"))
			atten = "Wednesday June 29 and Thursday June 30";
		else if(param.equalsIgnoreCase("29June"))
			atten = "Wednesday June 29 only";
		else
			atten = "Thursday June 30 only";
		
		return atten;
	}
	
	/*Validate the form variables */
	protected boolean checkFormVariables(HttpSession session, HttpServletRequest request) throws NumberFormatException {
		
		boolean result = true;
		String submit = (String)request.getParameter("submit");
		if(submit == null) submit = "";
		String clear = (String)request.getParameter("clear");
		if(clear == null) clear = "";
		
		//confirm button clicked
		if(submit.equalsIgnoreCase("SUBMIT")) {
			
			//get session variables 
			String name = (String)session.getAttribute("name");
			String email = (String)session.getAttribute("email");
			String address = (String)session.getAttribute("address");
			String attendance = (String)session.getAttribute("attendance");
			String dinner_atten = (String)session.getAttribute("dinner_atten");
			String tickets = (String)session.getAttribute("tickets");
			
			//process name
			if(name == null || name.trim().length() == 0 || name.equals("")) {
				session.setAttribute("err_name", "No name entered.");
				result = false;
			}
			
			//process email
			if(email == null || email.trim().length() == 0 || email.equals("")) {
				session.setAttribute("err_email", "No email entered.");
				result = false;
			}
			
			//check if email format is valid
			if(!checkEmail(email)) {
				session.setAttribute("err_email", "Incorrect email format.");
				result = false;
			}
			
			//process address
			if(address == null || address.trim().length() == 0 || address.equals("")) {
				session.setAttribute("err_add", "No address entered.");
				result = false;
			}
			
			//process attendance
			if(attendance.equalsIgnoreCase("select")) {
				session.setAttribute("err_atten", "No attendance selected.");
				result = false;
			}
			else System.out.println(attendance);
			
			//process dinner attendance
			if(dinner_atten == null ) {
				session.setAttribute("err_dinner_atten", "If you request extra dinner tickets you must attend the dinner yourself.");
				result = false;
			}
			
			//process additional dinner tickets			
			try {
				Integer.parseInt(tickets);
				session.setAttribute("tickets", tickets);
			}
			catch(NumberFormatException e) {
				session.setAttribute("err_tickets", "Please enter a number.");
				result = false;
			}
		}
		
		else if(clear.equalsIgnoreCase("CLEAR CHANGES")) {
			//setting attribute values to blank
			session.setAttribute("name", null);
			session.setAttribute("err_name", null);
			session.setAttribute("email", null);
			session.setAttribute("err_email", null);
			session.setAttribute("address", null);
			session.setAttribute("err_add", null);
			session.setAttribute("attendance", null);
			session.setAttribute("err_atten", null);
			session.setAttribute("discount", null);
			session.setAttribute("dinner_atten", null);
			session.setAttribute("err_dinner_atten", null);
			session.setAttribute("tickets", null);
			
			result = false;
		}
		
		//return result
		return result;
	}
	
	//Check if email's format is correct
	public boolean checkEmail(String email) {
		if(email.trim().matches("^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"))
			return true;
		return false;
	}
	
	//Find the cost of the booking
	public void findCost(HttpSession session) {
		double cost = 0;
		String discount = (String)session.getAttribute("discount");
		String atten = (String)session.getAttribute("attendance");
		int tickets = 0;
		
		//Check the attendance choice
		if(atten.equalsIgnoreCase("Wednesday June 29 and Thursday June 30")) {
			cost = 400; 
		}
		else if(atten.equalsIgnoreCase("Wednesday June 29 only") || atten.equalsIgnoreCase("Thursday June 30 only")) {
			cost = 250;
		}
		
		//Check the discount
		if(discount.equalsIgnoreCase("member")) {
			cost = 0.8 * cost;
		}
		else if(discount.equalsIgnoreCase("student")) {
			cost = 0.6 * cost;
		}
		else if(discount.equalsIgnoreCase("studentMember")) {
			cost = 0.5 * cost;
		}
		
		try {
			tickets = Integer.parseInt((String)session.getAttribute("tickets"));
			
			//Calculate cost for additional tickets
			if(tickets != 0) {
				cost += tickets * 50;
			}
		}
		catch(NullPointerException e) {
			session.setAttribute("cost", "$" + Double.toString(cost));
		}
		
		session.setAttribute("cost", "$" + Double.toString(cost));
 	}

}

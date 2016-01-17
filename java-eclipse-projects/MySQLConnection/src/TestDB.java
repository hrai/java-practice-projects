import java.sql.*;

public class TestDB {

	public static void main(String[] args) {
		try {
			//accessing the driver from the jar file
			Class.forName("com.mysql.jdbc.Driver");
		} 
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {

			//Creating a variable for the connection called 'con'
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "");
			//jdbc:mysql://localhost:3306/employee_record --> This is the database
			//root is the database user
			//root is the password
			
			//Here we create our query
			PreparedStatement statement = con.prepareStatement("select * from names");
			
			//Creating a variable to execute query
			ResultSet result = statement.executeQuery();
			
			while(result.next()) {
				System.out.println(result.getString(1)+ " " + result.getString(2));
				//getString() returns the data in string format
				//1 is the first field in the table
				//2 is the second field in the table
			}
			
			//Closing the resources
			result.close();
			statement.close();
			con.close();
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
}

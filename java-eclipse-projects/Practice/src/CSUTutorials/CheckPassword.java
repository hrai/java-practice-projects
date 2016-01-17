package CSUTutorials;

import java.util.Scanner;

public class CheckPassword {

	public static void main(String[] args) {
			
			//create an instance of the class
			CheckPassword ins = new CheckPassword();
			
			Scanner scanner = new Scanner(System.in);	//initialising the Scanner
			
			//prompt the user to enter a password
			System.out.print("Please enter password: ");
			String password = scanner.next();
			
			//check if the password is valid and printing the result
			System.out.println(ins.checkPassword(password));
			
		}
	
	public String checkPassword(String password) {
			
			if(hasLettersAndNumbers(password)==true && hasTwoDigits(password)==true
					&& hasEightChars(password)==true) {
				return "Valid Password";
			}
			else 
				return "Invalid Password";
	}
	
	/* Check if password has both letter and number */
	public boolean hasLettersAndNumbers(String password) {
		boolean letter = false;
		boolean number = false;
		
		for(int i=0; i<password.length(); i++) {
			if(Character.isLetter(password.charAt(i))) {	//check for letter
				letter = true;
			}
			else if(Character.isDigit(password.charAt(i))) {	//check for number
				number = true;
			}
			
			if(letter == true && number == true) {
				break;
			}
		}
		
		if(letter == true && number == true) 	//check if bother letter and number are present
			return true;
		else 
			return false;
	}
	
	/* Check if the password contains at least 2 digits */
	public boolean hasTwoDigits(String password) {
		boolean result = false;
		int count = 0;
		
		for(int i=0; i<password.length(); i++) {
			if(Character.isDigit(password.charAt(i))) {	//check if the character is a digit
				count++;
			}
			
			//check if there are 2 digits
			if(count == 2) {
				result = true;
				break;
			}
		}
		
		return result;
	}
	
	/* Check if the password has 8 characters */
	public boolean hasEightChars(String password) {
		
		if(password.length() >= 8) 	//check if the password is greater than 8 characters in length
			return true;
		else 
			return false;
	}
	
}

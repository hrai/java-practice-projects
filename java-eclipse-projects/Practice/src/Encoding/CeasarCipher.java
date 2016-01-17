package Encoding;

import java.util.InputMismatchException;
import java.util.Scanner;

/* Calculates and outputs the cipher value of the entered text */
public class CeasarCipher {

	private static int key = 0;
	private static String str = "";
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input = "";
		
		System.out.println("Please enter a string: ");		
		str = scanner.nextLine();	//getting input from the user
		
		System.out.println("Enter the key: (1-5) ");
		
		try {
			key = scanner.nextInt();	//getting input from the user

			//print cipher text encoded with the help of user entered key
			System.out.println("The cipher text is: " + getEncodedText(str, key));
			
			System.out.println("Do you want to get decode the cipher text? (Y/N)");
			
			//check if the usre wants to decode the text
			if((input = scanner.next()).equalsIgnoreCase("y")) {
				System.out.println("The decoded string is: " + getDecodedText(getEncodedText(str, key), key));	//print decoded text
			}
			
		} catch(InputMismatchException e) {	//catch wrong input exception
			System.out.println("aw crap");
		}
	}
	
	/* Return the encoded text */
	public static String getEncodedText(String str, int key) {
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<str.length(); i++) {
			sb.append(getEncodedChar(str.charAt(i), key));	//adding the encoded character to the stringbuilder
		}
		
		return sb.toString();
	}
	
	/* Return the encoded character */
	public static char getEncodedChar(char ch, int key) {
		
		if(!Character.isWhitespace(ch)) {
			if(Character.isLowerCase(ch))
				return (char) ('a' - ('a' - ch - key) % 26);	//returning the encoded character
			else
				return (char) ('A' - ('A' - ch - key) % 26);
		}
		else 
			return ch;
	}
	
	/* Return decoded text */
	public static String getDecodedText(String str, int key) {
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<str.length(); i++) {
			sb.append(getDecodedChar(str.charAt(i), key));
		}
		
		return sb.toString();
	}
	
	/* Return decoded character */
	public static char getDecodedChar(char ch, int key) {
		
		if(key < 0) {
			key = 26 - (-key % 26);
		}
		
		return getEncodedChar(ch, -key);
	}
	
}

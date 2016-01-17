package assignment2;

import java.util.Scanner;

public class Tester {
	
	public static void main(String[] args) {
		String[] argus = new String[10];
		
		Scanner scanner = new Scanner(System.in);
		int counter = 0;
		
		do {
			System.out.print("Please enter the coefficient and power: ");
			String s = scanner.nextLine();
			if(s.equalsIgnoreCase("EXIT"))
				break;
			
			argus[counter++] = s;
		}
		while(true);
		
		Polynomial poly = new Polynomial(argus);
		poly.toString();
	}
}

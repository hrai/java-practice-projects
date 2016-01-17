package CSUTutorials;

import java.util.*;

public class TestForKids {
	
	public static void main(String[] args) {
		int N = 0;
		
		for(int i=0; i<10; i++) {
			int num1 = randomNum();
			int num2 = randomNum();
			
			while(num1 == 0) {
				num1 = randomNum();
			}
			while(num2 == 0) {
				num2 = randomNum();
			}
			
			System.out.printf("What is %d * %d?\n", num1, num2);	//ask for user input
			
			//initialising Scanner
			Scanner scanner = new Scanner(System.in);
			int num = scanner.nextInt();
			
			if(num == (num1 * num2)) {
				System.out.println("Correct");
				N++;
			}
			else {
				System.out.println("Incorrect");
				System.out.printf("%d * %d is %d\n", num1, num2, num1*num2);
			}
		}
		
		System.out.printf("Score is %d/10", N);
	}
	
	/* Return a random number */
	private static int randomNum() {
		
		Random rand = new Random();
		return rand.nextInt(12);
	}
}

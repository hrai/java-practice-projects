
/*
 * The maximum value for one digit is 9^5 = 59049. We can find 
 * out the maximum possible sum for a given number of digits by 
 * multiplying 59049 with the number of digits.
 * Let's say we're gonna check the number 123456789. 
 * That's 9 digits, so the maximum sum would be 9*59049 = 531441, 
 * which doesn't even come close to 123456789. So we know we can 
 * forget about any number 9-digit number because we'll never be 
 * able to reach a big enough sum. And it'll only get worse with larger numbers :)
 */

public class Prob30 {

	public static void main(String[] args) {
		int temp, sum = 0;
		
		//looping 6*(9^5) times as it is the largest possible sum of any number's
		//digit's power raised to 5
		for(int i=2; i<354294; i++) {
			int result = 0;
			temp = i;
			
			//calculating the sum of 5th powers of each digit of the number
			while(temp != 0) {
				result+= Math.pow(temp%10,5);
				temp = temp/10;
			}
			//check if the sum is the number itself
			if(result == i) {
				sum+= result;
			}
		}
		System.out.println(sum);
	}
	
	//Calculate the factorial of a number
	public static double factorial(int n) {
		double fact = 1;
		
		if(n == 1) {
			return 1;
		}
		else {
			fact = n* factorial(n-1);
		}
		return fact;
	}
}

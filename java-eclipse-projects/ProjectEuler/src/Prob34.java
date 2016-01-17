
public class Prob34 {

	/**
	 * We can establish an upper bound of the problem by figuring 
	 * out that 9!*7 = 2540160 which is the upper limit. There is 
	 * no possible higher value since 9!*8 also results in a 7 
	 * digit number.
	 */
	public static void main(String[] args) {
		double upperLimit = Factorial.factorial(9) * 7;
		
		int sum = 0;

		//Looping through the numbers to find their digit's factorials' sum
		for(int i=10; i<upperLimit; i++) {
			int factSum = 0;
			int rem = i;
			
			//Sum of all factorials of the digits in number 'i'
			while(rem>0) {
				int digit = rem % 10;
				factSum += Factorial.factorial(digit);
				rem /= 10;
			}
			
			//Check if the number is equal to the sum of factorials of its digits
			if(factSum == i)
				sum+= factSum;
		}
		
		System.out.println(sum);
	}
	
}

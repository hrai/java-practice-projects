import java.math.BigInteger;


public class Prob25 {
	
	public static void main(String[] args) {
		double count = 0;
		double index = 2;	//indexing is 2 because the first two fib numbers are already known which are 1 and 1.
		BigInteger first = new BigInteger("1");
		BigInteger second = new BigInteger("1");
		BigInteger fib = new BigInteger("0");
		
		while(count<1000) {
			fib = first.add(second);	//adding the previous two numbers
			count = fib.toString().length();	//counting size of fib num
			index++;	//increasing index
			
			//changing the values of previous two numbers to calculate next fib number
			first = second;
			second = fib;
		}
		System.out.println(index);
		
	}
	
}

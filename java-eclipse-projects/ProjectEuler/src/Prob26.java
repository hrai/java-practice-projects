import java.util.*;

/* Calculate the largest d<1000 number for which 1/d creates the longest
 * recurring cycle
 */
public class Prob26 {

	public static void main(String[] args) {
		long number = 0;
		int lengthOfQuotient = 0;
		
		// As we know that the cyclic remainder is produced only when a number is divided by 
		// a prime number, we are only considering the prime number. Also, the loop starts from 
		// 999 and loops down as for number n, it's cyclic remainder can be only less than n-1 
		// long and we are after the largest cyclic remainder
		for(int i=999; i>900; i--) {//Assuming the largest cyclic remainder is yielded by a number between 1000 and 900
			ArrayList<Double> remainders = new ArrayList<Double>(); //stores the remainders
			int quotientSize = 0;
			
			if(isPrime(i)) {
				double remainder = 1;
				
				index:while(true) {
					if(remainder < i) {
						remainder = (remainder * 1000) % i;//calculating the remainder
					}

					//Check if the new remainder already exists in the list before adding it to the list and 
					//Break out of while loop if the remainder already exists in the list as the cycle will repeat
					if(remainders.contains(remainder)) 
						break index;
				
					remainders.add(remainder);//adding remainder to the list
					quotientSize++;//increasing the length of quotient
				}	
			}
			
			
			//Checking if the new quotient size is bigger than the previous one
			if(quotientSize > lengthOfQuotient) {
				lengthOfQuotient = quotientSize;//setting new quotient size
				number = i;//setting new answer
			}
		}
		System.out.println("The required number is " + number);
		
	}
	
	//check if value is a prime number
	 static boolean isPrime(int n) {
		
		for(int i=2; i<=Math.sqrt(n); i++) {
			if(n%i == 0) {
				return false;
			}
		}
		return true;
	}
}

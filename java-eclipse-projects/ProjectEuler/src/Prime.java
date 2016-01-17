
public class Prime {

	public static boolean isPrime(int n) {
		//Return true if the number is less than 2
		if(n < 2) {
			return false;
		}
		
		//Find the numbers
		for(int i=2; i<=Math.sqrt(n); i++) {
			if(n%i == 0) {
				return false;
			}
		}
		return true;
	}
}


public class PrimeNumber {

	/*
	 * Algorithm 
To find all the prime numbers less than or equal to a given integer n by Eratosthenes' method:

1. Create a list of consecutive integers from two to n: (2, 3, 4, ..., n).
2. Initially, let p equal 2, the first prime number.
3. Strike from the list all multiples of p greater than p.
4. Find the first number remaining on the list greater than p (this number is the next prime); let p equal this number.
5. Repeat steps 3 and 4 until p^2 is greater than n.
6. All the remaining numbers on the list are prime.
	 */
	public static int sieveOfEratosthenes(int n) {
		int sum = 0;
		boolean[] sieve = new boolean[n];
		
		for(int i=0; i<n; i++) {
			if(isPrime(i)) {
				for(int j=i; j<n; j+= i) {
					sieve[j] = true;
				}
			}
		}
		
		for(int i=0; i<n; i++) {
			if(sieve[i] == false){
				sum+= i;
			}
		}
		return sum;
		
	}
	
	public static boolean isPrime(int n) {
		
		if(n == 2 || n == 3) {
			return true;
		}
		
		for(int i=2; i<Math.sqrt(n); i++) {	//i=2 and not 1 is because num%1 is always 0;
			if(n%i == 0) {
				return false;
			}
		}
		
		return true;
	}
}


public class Prob27 {
	
	public static void main(String[] args) {
		int product = 0;
		int n = 0, max = 0;	//where 'n' is the sequence of prime numbers and 
		//'max' is the largest value of 'n' over the range -1000 to 1000
		
		// Dual for-loop makes the 
		for(int i=-1000; i<=1000; i++) {
			for(int j=-1000; j<=1000; j++) {
				//set the value of n to 0 everytime the loop repeats
				n = 0;
				
				// Run the loop while the quadratic equation yields a prime number
				while(isPrime(((n*n)+(n*i)+j))) {
					n++;//increase 'n'
				}
				
				// Check if the product of the values is more than the previous product
				if(max < n) {
					max = n;	//setting the maximum value of 'n'
					product = i*j;	//creating the product of the coefficients
				}
			}
		}
		System.out.println(product);
	}
	
	private static boolean isPrime(int n) {
		if(n == 0 || n == 1 || n < 0) {
			return false;
		}
		
		for(int i=2; i<=Math.sqrt(n); i++) {
			if(n%i == 0) {
				return false;
			}
		}
		return true;
	}
}

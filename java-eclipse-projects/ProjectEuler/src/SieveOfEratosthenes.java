import java.util.ArrayList;


public class SieveOfEratosthenes {
	public static ArrayList<Boolean> primes;
	
	public static void main(String[] args) {
		double numOfPrimes = 0;
		double sumOfPrimes = 0;
		ArrayList<Boolean> primes = listOfPrimes(1000000000);	//List of primes numbers 
		
		//Looping through all the values in the array
		for(int i=0; i<primes.size(); i++) {
			//Check if the value is true (or the value represents a prime number)
			if(primes.get(i) == true) {
				numOfPrimes++;
				sumOfPrimes+= i;
			}
		}
		
		//Printing the values of the number of primes and the sum of the primes
		System.out.println(numOfPrimes);
		System.out.println(sumOfPrimes);
	}
	
	/*
	 * Returns an array of boolean values representing their position value as 
	 * prime numbers or not
	 */
	public static ArrayList<Boolean> listOfPrimes(int upperLimit) {
		
		//Increasing the value of upperLimit so as to include the number itself
		upperLimit++;
		
		int sizeOfList = upperLimit/2;	//Only odd numbers need to be included eliminating even nos.
		double loopLimit = (double) (Math.sqrt(upperLimit) + 1);	//Limit of the for-loop
		
		primes = new ArrayList<Boolean>();
		
		
		//Set the values in the array above position '1' as true 
		for(int i = 0; i < sizeOfList; i++) {
			primes.add(true);
		}
		
		//Set 0 and 1 as non-primes
		primes.set(0, false);
		primes.set(1, false);
		
		//Looping in order
		for(int i=2; i<loopLimit; i++) {
			//Check if the position's value is true (which means it is prime)
			if(primes.get(i) == true) { 
				//Set the value of exactly divisible index of i as false as they are not prime
				for(int j = 2; j*i < primes.size(); j++) {
					primes.set(i*j, false);
				}
			}
		}
		
		return primes;		
	}
	
	/* Check if a number is a prime number by checking if it is in the list */
	public static boolean isPrime(int num) {
		//Creating a list of all the primes below 'num'
		primes = listOfPrimes(num);
		
		//Check if the number is a prime number
		if(primes.get(num) == true)
			return true;
		else 
			return false;
		
	}
}

import java.util.ArrayList;


public class Prob50 {
	
	public static void main(String[] args) {
		int upperLimit = 1000;
		ArrayList<Boolean> sieveOfE = SieveOfEratosthenes.listOfPrimes(upperLimit);
		ArrayList<Integer> cumulativePrimes = new ArrayList<Integer>();
		int numberOfPrimes = 0;
		int sum = 0;
		int count = 0;
		
		//Filling up the ArrayList
		cumulativePrimes.set(0, 0);
		for(int i=0; i<cumulativePrimes.size(); i++) {
			if(sieveOfE.get(i) == true) {
				sum+= i;
				cumulativePrimes.add(sum);
			}
		}
		
		//Looping through the list
		for(int i=numberOfPrimes; i<upperLimit; i++) {
			for(int j=i-(numberOfPrimes-1); j>0; j--) {
				
			}			
		}
		
		while(sum < upperLimit) {
			if(sieveOfE.get(index) == true) {
				sum+= index;
				count++;
				cumulativePrimes.add(index);
				cumulativePrimes.add(sum);	//Add the sum to list only if it's prime
			}
			
			//Increasing index
			index++;
		}
		
		for(int i=0; i<cumulativePrimes.size(); i++) {
			if(cumulativePrimes.get(i) < upperLimit && Prime.isPrime(cumulativePrimes.get(i))) {
				System.out.println("The largest prime sum of consecutive primes below 1 million is " + cumulativePrimes.get(cumulativePrimes.size()-1));
				System.out.println(cumulativePrimes.get(i));
				System.out.println();
				break;
			}
			System.out.println(cumulativePrimes.get(i));
		}
			System.out.println(count);
		
	}

}

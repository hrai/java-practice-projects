
public class Prob37 {
	
	private static boolean[] primes;
	
	public static void main(String[] args) {
		int sum = 0;
		int count = 0;
		primes = SieveOfEratosthenes.listOfPrimes(100000000); 
		int[] digits;
		
		//Looping from 11 to 1000000000
		for(int i=11; i<100000000; i++) {
			if(primes[i] == true) {
				int num = i;
				digits = new int[String.valueOf(i).length()];	//Creating an array
				
				//Filling up the array with digits of the number
				for(int j=digits.length-1; j>=0; j--) {
					digits[j] = num%10;
					num/= 10;	//New value of 'num'
				}
				
				//Check if the combination of digits are also prime
				if(checkDigitsIfPrime(digits)) {
					sum+= i;
					count++; //increasing the number of primes added to the sum
					
					//Break the loop if the number of primes is 11
					if(count == 11)
						break;
				}
			}
		}
		
		System.out.println(sum);
		
	}
	
	public static boolean checkDigitsIfPrime(int[] digits) {
		boolean result = true;
		int[] digitsCombinations = new int[digits.length*2]; //Combination will be 2 times the original number of digits
		String num = "";
		
		for(int i=0; i<digits.length; i++) {
			//Creating a number from the combination of the digits
			num+= digits[i];
			digitsCombinations[i] = Integer.valueOf(num);	//Storing the new number into the string
		}
		
		//Setting the value of 'num' to empty string
		num = "";
		
		//Filling up the array with remaining combinations
		for(int i=digitsCombinations.length-1; i>=digits.length; i--) {
			num = digits[i-digits.length]+num;
			digitsCombinations[i] = Integer.valueOf(num);
		}
		
		//Check if the combination numbers are also prime
		for(int i: digitsCombinations) {
			if(!primes[i]) {
				
				result = false;
				break;
			}
		}
		
		return result;
		 
	}
	
}

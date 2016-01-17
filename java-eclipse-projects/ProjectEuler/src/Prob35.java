import java.util.*;


public class Prob35 {

	public static void main(String[] args) {
		
		int count = 0;
		
		for(int i=2; i<1000000; i++) {
			//Check if the number is prime
			if(Prime.isPrime(i)) {
				System.out.println(i);
				boolean allPrime = true;
				
				//Check if all the circular numbers are prime
				for(int num: circularNumbers(i)) {
					if(!Prime.isPrime(num)) {
						allPrime = false;
						break;
					}
				}
				
				//Increase count if all the circular numbers are prime 
				if(allPrime)
					count++;
			}
		}
		
		System.out.println(count);
	}
	
	public static TreeSet<Integer> circularNumbers(int num) {
		//Finding the length of the number
		int len = String.valueOf(num).length();
		int tens = tensPlace(num);
		
		//Creating an array which holds all the circular numbers of the given number
		TreeSet<Integer> nums = new TreeSet<Integer>();
		
		//Setting the first number in the array as the passed number itself
		nums.add(num);
		
		int temp = num;
		
		for(int i=1; i<len; i++) {
			int lstDigit = temp%10;
			
			//Rotating the first and last digits
			temp/= 10;
			temp+= lstDigit * tens;
			
			//Saving the number in the array
			nums.add(temp);
			
		}
		return nums;		
	}
	
	public static int tensPlace(int num) {
		int result = 1;
		while(num>0) {
			num/= 10;
			result*= 10;
		}
		
		return result/10;
	}
}

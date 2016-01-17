import java.util.LinkedList;

/* 
 * Calculates the millionth permutation of the number 0123456789
 * help from 'http://blog.singhanuvrat.com/problems/project-euler-the-millionth-lexicographic-permutation-of-the-digits'
 * and 'http://www.mathblog.dk/project-euler-24-millionth-lexicographic-permutation/'
 */
public class Prob24 {

	public static void main(String[] args) {
		int[] numbers = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		
		millionthPermutation(numbers);
		
	}
	
	public static void millionthPermutation(int[] numbers) {
		LinkedList<Integer>nums = new LinkedList<Integer>();
		double remainingPerm = 1000000 - 1; //because the number 0123456789 which is by default the first permutation
		String millionthPerm = "";
		
		//Populating the list
		for(int i=0; i<numbers.length; i++) {
			nums.add(i);
		}
			
		//calculating the millionth permutation
		for(int i = numbers.length-1; i > 0; i--) {
			double j = remainingPerm/Factorial.factorial(i);
			millionthPerm += nums.remove((int) j);//adding the number to string and removing it from list
			remainingPerm = remainingPerm % Factorial.factorial(i);//setting new value of remainingPerm
			
			//break the loop if there are no remaining permutations left
			if(remainingPerm == 0)
				break;
		}
		
		//Since all the numbers are to be used in the permutation, the list has to be
		//checked for any remaining numbers 
		if(!nums.isEmpty()) {
			for(Integer i: nums) 
				millionthPerm += i;//adding remaining numbers to the permutation
		}
		
		System.out.println(millionthPerm);//printing the permutation
	}
	
}

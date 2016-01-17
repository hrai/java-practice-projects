import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pandigital {

	/**
	 * Returns true if the passed parameter is pandigital.
	 * @param number
	 * @return 
	 */
	public static boolean isPandigital(int number) {
		
		int num = number;
		List<Integer> digits = new ArrayList<Integer>();
		
		//Adding the digits to the list
		for(int i=0; i<Integer.toString(number).length(); i++) {
			digits.add(num%10);
			num/= 10;
			
		}
		
		//Checking if the contents are palindromic
		for(int i=1; i<=digits.size(); i++) {
			if(Collections.frequency(digits, i) != 1) //Check if each digit has only one item
				return false;
		}
		
		return true;
	}

}

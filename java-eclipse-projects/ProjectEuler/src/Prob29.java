import java.math.BigDecimal;
import java.util.*;

public class Prob29 {
	
	//use of TreeSet ensures no duplicates are added to the list and 
	// no the list is in natural order itself
	public static TreeSet<BigDecimal> nums = new TreeSet<BigDecimal>();
	
	public static void main(String[] args) {
		//dual for-loop for calculating the powers of the numbers
		for(int i=2; i<=100; i++) {
			for(int j=2; j<=100; j++) {
				nums.add(new BigDecimal(Double.toString(Math.pow(i, j))));
			}
		}
		
		//printing the size of the 'TreeSet'
		System.out.println(nums.size());
	}

}

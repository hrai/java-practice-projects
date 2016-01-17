import java.util.ArrayList;
import java.util.Collections;


public class Prob23 {

	public static void main(String[] args) {
		int sum = 0;
		ArrayList<Integer> arr = new ArrayList<Integer>();
		
		//adding the abundant numbers to the arraylist
		for(int i=2; i<28123; i++) {
			if(!perfectOrDeficient(i)) {	//check if the number is not perfect
				arr.add(i);
				System.out.println(i);
			}
		}
		
		Collections.sort(arr);
		boolean[] b = new boolean[28123];
		
		@SuppressWarnings("unused")
		int index = 0;
		
		//create a list of sum of two abundant numbers
		for(int i=0; i<arr.size(); i++) {
			index++;
			for(int j=0; j<arr.size(); j++) {
				if((arr.get(i) + arr.get(j))<28123) {
					b[arr.get(i) + arr.get(j)] = true;
				}
			}
		}
		
		//summing up all the numbers which can't be expressed as a sum of two abundant numbers
		for(int i=0; i<b.length; i++) {
			if(!b[i]) {
				sum+= i;
				System.out.println(i);
			}
		}
		System.out.println(sum);
		
	}
	
	//check if the number is a perfect or a deficient number
	private static boolean perfectOrDeficient(int n) {
		int sum = 0;
		
		for(int i=1; i<n; i++) {
			if(n%i == 0) {
				sum+= i;
			}
		}
		
		if(sum <= n)
			return true;
		
		return false;
	}
	
}

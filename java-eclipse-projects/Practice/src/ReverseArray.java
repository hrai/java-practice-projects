import java.util.*;

public class ReverseArray {

	public static void main(String[] args) {
		
		//creating new array
		int[] arr = {12, 56, 34, 79, 26, 2};
		
		//reversing the array
		reverseArray(arr);
		
		//printing the values in array
		System.out.println(Arrays.toString(arr));
	}
	
	
	/*
	 * Reversing the order of the passed array
	 */	
	public static void reverseArray(int[] intArray) {
		
		int temp;
		int indexFirst = 0;
		int indexLast = intArray.length-1;
		
		while(indexFirst<=intArray.length/2) {
			
			//exchanging the values
			temp = intArray[indexFirst];
			intArray[indexFirst] = intArray[indexLast];
			intArray[indexLast] = temp;
			
			//increasing the indexes
			indexFirst++;
			indexLast--;
			
		}
	}
}

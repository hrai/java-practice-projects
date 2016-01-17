

/* (Counting single digits) Write a program that generates 100 random 
 * integers between 0 and 9 and displays the count for each number
 */

import java.util.Arrays;

public class RandomNumbers {
	
	private static int[] arr = new int[10];	//array to hold the count
	
	public static void main(String[] args) {
		
		for(int i=0; i<100; i++) {
			int num = randomNum();	//generate random number
			increaseCount(num);	//increase the count of that number
		}
		
		System.out.println(Arrays.toString(arr));
		
	}
	
	/* Return a random number between 0 to 9 */
	public static int randomNum() {
		return (int)(Math.random() * 10);
	}
	
	/* Store the number in the array */
	public static void increaseCount(int n) {
		
		switch(n) {
		case 0: arr[0]++;
			break;
		case 1: arr[1]++;
			break;
		case 2: arr[2]++;
			break;
		case 3: arr[3]++;
			break;
		case 4: arr[4]++;
			break;
		case 5: arr[5]++;
			break;
		case 6: arr[6]++;
			break;
		case 7: arr[7]++;
			break;
		case 8: arr[8]++;
			break;
		case 9: arr[9]++;
			break;
		}
	}
}

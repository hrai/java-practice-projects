
/********************************************************************************************
 * 
 * The approach used in solving this problem lies in the fact that the interval between two
 * diagonal number is 2 at first and then after every 4 numbers, the interval increases by 2.
 * This logic helps to find the sum of all the diagonal numbers and the upper limit of the 
 * skipping number is the size of the row/column which in this case is 1001. 
 *
 ********************************************************************************************/
public class Prob28 {

	public static void main(String[] args) {
		int sum = 1;	//sum of diagonals
		int num = 1;	//the actual number
		int skip = 2;	
		
		// Run loop while skip is less than 1001
		while(skip < 1001) {
			// Run the loop four times
			for(int count=0; count<4; count++) {
				num+= skip;	//increase 'num'
				sum+= num;	//add diagonal number 'num' to 'sum'
			}
			//increase 'skip' after every 4 diagonal numbers
			skip+= 2;
		}
		
		System.out.println(sum);
	}
}

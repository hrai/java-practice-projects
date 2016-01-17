
public class Prob44 {

	public static void main(String[] args) {
		
		int i = 0;
		
		//Outer loop to increase value of i
		index:while(true) {
			
			i++;
			int n = i * (3 * i - 1) / 2;
			
			//Inner loop to decrease the value
			for(int j = i-1; j > 0; j--) {
				int m = j * (3 * j - 1) / 2;
				
				if(isPentagonal(n-m) && isPentagonal(m+n)) {
					System.out.println(n - m);
					break index;
				}
			}
		}
	}
	
	public static boolean isPentagonal(int n) {
		double x = (Math.sqrt(24 * n + 1) + 1)/6;
		
		return x == (int)x;
	}
}

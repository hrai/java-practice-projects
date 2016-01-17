
public class Prob14 {
	
	private static int length;
	
	public static void main(String[] args) {
		
		double n = 2;
		double j = 0, result = 0;
		
		for(double i=2; i<1000000; i++) {
			length = 0;
			n = i;
			while(n != 1) {
				if(n % 2 == 0) {
					n/= 2;
					length++;
				}
				else {
					n = (3*n) + 1;
					length++;
				}
			}
			if(length > j) {
				j = length;
				result = i;
			}
			System.out.println(result);
		}
	}
	
	public static double ret(double n) {
		
			
			
			return n;
			
		
	}
}


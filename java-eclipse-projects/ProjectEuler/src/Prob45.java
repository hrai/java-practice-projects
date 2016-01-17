
public class Prob45 {
	
	public static void main(String[] args) {
		
		//Start the loop after 40755 because it is the first number
		for(long i = 40756; i < Long.MAX_VALUE; i++) {
			if(isHexagonal(i)) 
				if(isPentagonal(i))
					if(isTriangular(i)) {
						System.out.println("The required number is " + i);
						break;
					}
		}
		
	}
	
	public static boolean isTriangular(long n) {
		double x = (Math.sqrt(8 * n + 1) - 1)/2;
		
		return x == (int)x;
	}
	
	public static boolean isPentagonal(long n) {
		double x = (Math.sqrt(24 * n + 1) + 1)/6;
		
		return x == (int)x;
	}
	
	public static boolean isHexagonal(long n) {
		double x = (Math.sqrt(8 * n + 1) + 1)/4;
		
		return x == (int)x;
	}
}

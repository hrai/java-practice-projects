import java.math.BigDecimal;


public class Prob20 {

	public static void main(String[] args) {
		String s = fact(100).toString();
		int result = 0;
		
		for(int i=0; i<s.length(); i++) {
			result+= Character.getNumericValue(s.charAt(i));
		}
		System.out.println(result);
		
	}
	
	//factorial of a number
	private static BigDecimal fact(int n) {
		BigDecimal b = new BigDecimal(n);
		
		if(n == 0) {
			return new BigDecimal(0);
		}
		else if(n == 1) {
			return new BigDecimal(1);
		}
		else {
			 b = b.multiply(fact(n-1));
		}
		return b;
	}
}

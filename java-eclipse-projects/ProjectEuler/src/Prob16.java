import java.math.BigDecimal;


public class Prob16 {

	public static void main(String[] args) {
		BigDecimal b = null;
		String s;
		int result = 0;
		
		for(int i=1; i<=1000; i++) {
			b = new BigDecimal(Math.pow(2, 1000));
		}
		
		s = b.toString();
		for(int i=0; i<s.length(); i++) {
			result+= Character.getNumericValue(s.charAt(i));
		}
		System.out.println(result);
	}
}

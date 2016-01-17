import java.math.BigDecimal;

public class Prob48 {
	
	public static void main(String[] args) {
		BigDecimal num, sum = new BigDecimal(0);
		
		for(int i=1; i<=1000; i++) {
			num = new BigDecimal(i);
			
			//Because BigDecimal is immutable, a new temporary variable is used
			BigDecimal temp = sum.add(num.pow(i));	//Adding the product to the sum
			
			sum = temp;
						
			String numStr = sum.toString();
			
			//Only print the last 10 digits of a string longer than 10 characters
			if(numStr.length() > 11) 
				System.out.println(numStr.substring(numStr.length()-10));
		}
		
		
//		
		
	}
}

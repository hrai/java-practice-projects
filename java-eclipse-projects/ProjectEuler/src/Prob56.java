import java.math.BigDecimal;


public class Prob56 {
	
	public static void main(String[] args) {
		long sum = 0;
		
		for(int i=0; i<100; i++) {
			BigDecimal num = new BigDecimal(i);
			for(int j=0; j<100; j++) {
				BigDecimal newNum = num.pow(j);	//Creating the power value of an int 'i'
				
				//Calculating the sum
				if(calculateSum(newNum) > sum) {
					sum = calculateSum(newNum);
				}
			}
		}
		
		System.out.println(sum);
		
	}

	private static long calculateSum(BigDecimal newNum) {
		char[] numArray = newNum.toPlainString().toCharArray();
		long sum = 0;
		
		for(char c: numArray) {
			long l = Long.parseLong(c+"");	//Convert the character to string and then to long
			sum+= l;	//Add long variable to the sum
		}
		
		return sum;
	}
	
	

}

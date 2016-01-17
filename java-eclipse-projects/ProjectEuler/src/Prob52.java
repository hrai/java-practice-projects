import java.util.*;

public class Prob52 {
	
	public static void main(String[] args) {
		
		in:for(long i=100; i<1000000000; i++) {
			List<Character> digitsNum1 = digitList(i); 
			List<Character> digitsNum2 = digitList(i*2);
			
			if(hasCommonDigits(digitsNum1, digitsNum2)) {
				List<Character> digitsNum3 = digitList(i*3);
				if(hasCommonDigits(digitsNum1, digitsNum3)) {
					List<Character> digitsNum4 = digitList(i*4);
					if(hasCommonDigits(digitsNum1, digitsNum4)) {
						List<Character> digitsNum5 = digitList(i*5);
						if(hasCommonDigits(digitsNum1, digitsNum5)) {
							List<Character> digitsNum6 = digitList(i*6);
							if(hasCommonDigits(digitsNum1, digitsNum6)) {
								System.out.println("The required number is " + i);
								break in;
							}
						}
					}
				}
			}
		}
	}
	
	public static List<Character> digitList(long num) {
		String s = Long.toString(num);
		char[] digitsArr = s.toCharArray();
		
		List<Character> digits = new ArrayList<Character>();
		
		//Adding digits from array to list
		for(char digit: digitsArr) {
			digits.add(digit);
		}
		
		return digits;
	}
	
	public static boolean hasCommonDigits(List<Character> num1, List<Character> num2) {
		if(num1.size() == num2.size()) {
			for(char c: num1) {
				if(num2.contains(c)) {
					Object ch = c;
					num2.remove(ch);	//Removing the element in 
				}
				else
					return false;
			}
			
			return true;
		}
		else
			return false;		
	}
}

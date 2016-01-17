
public class Prob36 {

	public static void main(String[] args) {
		double sum = 0;
		
		for(int i = 0; i<1000000; i++) {
			if(isPalindromic(String.valueOf(i))) {
				//Converting binary string to integer
				String binary = Integer.toBinaryString(i);
				
				if(isPalindromic(binary)) {
					sum+= i;
				}
			}
		}
		System.out.println(sum);
	}

	/**
	 * Check if the number is palindromic 
	 */
	private static boolean isPalindromic(String num) {
		
		for(int i=0; i<num.length(); i++) {
			//Check if the numbers from the front and the back are same
			if(num.charAt(i) != num.charAt(num.length() - 1 - i)) {
				return false;
			}
		}
		
		return true;
	}
}


public class Palindrome {

	public static void main(String[] args) {
		System.out.println(isPalindrome(81018));
	}
		
	public static boolean isPalindrome(int n) {
		// convert to string
		String s = Integer.toString(n);
		boolean pal = false;
		
		for(int i=0; i<=s.length()/2; i++) {	//loop to check the first half of the number
			for(int j=s.length()-1; j>=s.length()/2; j--) {	//loop to check the second half 
				if(s.charAt(i) == s.charAt(j)) {
					pal = true;
					i++;	//increase 'i'
				}
				else {
					pal = false;
					break;
				}
			}break;
		}
		return pal;
	}
}

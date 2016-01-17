
/**
 * A palindrome is a number that is read the same forwards as it is backwards.  For instance, 12321 and 1991 are
 * palindromes, but 1910 is not.
 *
 * We can create palindromes from any number by continually reversing the number and adding it to itself.  For
 * instance 1910 can be turned into a palindrome in the following manner:
 *
 * 1910 + 0191 = 2101
 * 2101 + 1012 = 3113
 *
 * Write a program in Java which will take an int in as input and return a palindrome formed from that int
 * in the above manner.  If the resulting palindrome is too large to fit into an int value then -1 will be returned
 * Negative numbers will also be returned as -1.
 *
 * Method Signature:
 *
 * int generate(int number)
 * Input: number - The number to generate the palindrome from
 * Output: A palindrome generated from the number or -1 if there is overflow or the number is negative
 *
 * Test Cases:
 * Input: 1910
 * Output: 3113
 *
 * Input: 111
 * Output 111
 *
 * Input: 83293
 * Output: 257752
 *
 * Input: 999999998
 * Output: -1
 *
 *
 */
public class PalindromeGenerator
{
	public int generate(int number)
	{
		int iNewNumber = number;
		
		while(!isPalindrome(iNewNumber))
		{
			iNewNumber = getPossiblePalindrome(iNewNumber);
			
			if(iNewNumber < 0 || iNewNumber * 1.0 > Integer.MAX_VALUE)
				return -1;
		}
		
		return iNewNumber;
	}
	
	
	private int getPossiblePalindrome(int number)
	{
		String sNumber = String.valueOf(number);
		StringBuffer sb = new StringBuffer();

		for(int i=sNumber.length()-1; i>=0; i--)
		{
			sb.append(sNumber.charAt(i));
		}
		
		double dReversedNumber = Double.parseDouble(sb.toString());
		if(dReversedNumber > Integer.MAX_VALUE)
			return -1;
		
		return number + (int) dReversedNumber;
	}


	private boolean isPalindrome(int number)
	{
		String sNumber = String.valueOf(number);
		int iReverseCounter = sNumber.length()-1;
		
		for(int i=0; i<sNumber.length()/2; i++)
		{
			if(sNumber.charAt(i) != sNumber.charAt(iReverseCounter--))
				return false;
		}
		
		return true;
	}

}


/**
 * Write a java program that takes a pair of integers a, b as input and determines whether a*b is evenly divisible by c. 
 * PLEASE NOTE: a and b may be large enough so that a*b overflows.
 *
 * Sample Input and Expected Results
 * =================================
 * 
	Sample:	   a=5 b=2 c=10 : EXPECTED RESULT=true
	Sample:	   a=5 b=3 c=10 : EXPECTED RESULT=false
	Sample:	   a=0 b=10 c=10 : EXPECTED RESULT=false
	Sample:	   a=1000 b=10 c=10 : EXPECTED RESULT=true
	Sample:	   a=1000 b=10 c=100000 : EXPECTED RESULT=false
	Sample:	   a=1000 b=5 c=100000 : EXPECTED RESULT=false
	Sample:	   a=50 b=2 c=10 : EXPECTED RESULT=true
	Sample:	   a=7 b=6 c=7 : EXPECTED RESULT=true
	Sample:	   a=100 b=1 c=10 : EXPECTED RESULT=true
	Sample:	   a=1000 b=30 c=10 : EXPECTED RESULT=true
	Sample:	   a=12 b=12 c=6 : EXPECTED RESULT=true
	Sample:	   a=12 b=12 c=9 : EXPECTED RESULT=true
	Sample:	   a=2147483647 b=4 c=2 : EXPECTED RESULT=true
 */
public class IntegerTest
{
	public boolean isDivisible(int numberA, int numberB, int divisibleBy)
	{
		double dProduct = numberA * numberB * 1.0;
		
		if(dProduct > Integer.MAX_VALUE || dProduct == 0)
			return false;
		
		return dProduct%divisibleBy == 0;
	}
	
}
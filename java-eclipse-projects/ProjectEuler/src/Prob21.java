
public class Prob21 {
	
	public static void main(String[] args) {
		int sum = 0;
		
		//sum up all the amicable pairs below 10000
		for(int i=0; i<10000; i++) {
			if(isAmicable(i)) {
				sum+= i;
			}
		}
		System.out.println(sum);
	}
	
	private static int sumOfProperDivisors(int n) {
		int sum = 0;
		
		for(int i=1; i<n; i++) {
			if(n%i == 0) {
				sum+= i;
			}
		}
		return sum;
	}
	
	private static boolean isAmicable(int n) {
		int newNum = sumOfProperDivisors(n);
		
		//check if 'n' and 'newNum' are amicable
		if(n == sumOfProperDivisors(newNum) && n != newNum) {
			return true;
		}
		
		return false;
	}
	
}


public class Prob12 {

	public static void main(String[] args) {
		
		//get triangle number
		
		int counter = 1;
		int tri = 1;
		
		while(true) {
			tri = getNumberOfDivisors(getTriangleNum(counter));
			
			if(tri > 500) {	//check if the number of divisors is over 500
				break;
			}
			counter++;
			
		}
		
		System.out.println(getTriangleNum(counter));
	}
	
	/* Get the triangle number */
	public static int getTriangleNum(int n) {
		int result = 0;
		
		for(int i=1; i<=n; i++) {
			result+= i;
		}
		return result;
	}
	
	/* Get the number of divisors */
	public static int getNumberOfDivisors(int n) {
		int divisors = 0;
		
		for(int i=1; i<=Math.sqrt(n); i++) {
			
			if(n%i == 0) {
				divisors+= 2;
			}
		}
		
		//correction for perfect square numbers
		if(Math.sqrt(n) * Math.sqrt(n) == n) {
			divisors-= 1;
		}
		return divisors;
	}
}

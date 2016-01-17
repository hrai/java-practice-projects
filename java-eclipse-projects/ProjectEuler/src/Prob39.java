
/**
 * The solution is explained on "http://www.mathblog.dk/project-euler-39-perimeter-right-angle-triangle/"
 * @author Nick-s
 *
 */
public class Prob39 {
	
	public static void main(String[] args) {
		int result = 0;
		int resultSols = 0;
		
		for(int p=0; p <= 1000; p++) {
			int numOfSols = 0;
			
			for(int a=0; a<(p/3); a++) {
				
				if(((p*(2*a-p)) % (2*(a-p))) == 0) {
					numOfSols++;				
				}
			}
			
			if(numOfSols > resultSols) {
				resultSols = numOfSols;
				result = p;
			}
		}
		
		System.out.println(result);
	}
}

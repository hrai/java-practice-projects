
public class Prob9 {
	
	public static void main(String[] args) {
		long result = 0;
		double c = 0;
		
		for(int i=0; i<1000; i++) {
			for(int j=i; j<1000; j++) {
				//check if the square root of sum of squares of the two numbers is an integer
				//if the sum is a perfect square, assign the root's value to 'c'
				if(isInt(c = Math.sqrt((Math.pow(i,2)+Math.pow(j,2))))) {
					if(i+j+c == 1000) {	//check if their sum if 1000
						result = (i*j*(int)c);	//get the product of the triplet
						System.out.println(result);	
						break;
					}
				}
			}
		}
		
	}
	
	//check if a double value is an integer
	public static boolean isInt(double d) {
		if(d == (int)d) {
			return true;
		}
		else
			return false;
	}

}

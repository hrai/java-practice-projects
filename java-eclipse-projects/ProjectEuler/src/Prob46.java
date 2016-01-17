
public class Prob46 {
	
	public static void main(String[] args) {
		
		//Loop through every odd integer
		for(int i=3; i<Integer.MAX_VALUE; i+= 2) {
			boolean found = true;
			int j, num = 0;
			
			if(!Prime.isPrime(i)) {
				//Loop to generate squares
				for(j=1; j<Math.sqrt(i/2); j++) {
					num = (int) (i - 2 * (Math.pow(j, 2)));
					
					//If a prime number is found, set the value of found as false
					if(Prime.isPrime(num)) {
						found = false;
						continue;
					}
				}
				
				if(found) {
					System.out.println("The non prime number is " + num);
					System.out.println("The base number is " + j);
					System.out.println("The required number is " + i);
					break;
				}
			}
		}
	}
}

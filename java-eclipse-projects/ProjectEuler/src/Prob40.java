
public class Prob40 {
	
	public static void main(String[] args) {
		String num = "";
		
		for(long i = 9387; i >= 0; i--) {
			num = String.valueOf(i) + String.valueOf(i*2);
			
			//Check if the number is pandigital
			//if(Pandigital.isPandigital(Integer.parseInt(num))) {
				break;
			}
			
		}
		
		System.out.println(num);
		double d = 2.3;
		if(d%(int)d != 0)
			System.out.println("prob");
	}
	
	
}

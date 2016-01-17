import java.util.TreeSet;

public class Prob32 {

	public static void main(String[] args) {
		
		double sum = 0;
		TreeSet<Double> set = new TreeSet<Double>();
		
		//To create a two 
		for(int i = 1; i < 9999; i++) {
			for(int j = 1; j < 9999; j++) {
				String s = "";
				double prod = i * j;
				
				//if(String.valueOf(prod).length() < 5) {	//product needn't be more than 4 digits long
					if((s+i+j+prod).length() == 9 && Pandigital.isPandigital(Integer.parseInt(s+i+j+prod))) {
						set.add(prod);
					//}
			}
		}
		
	
		System.out.println(sum);
		
	}
	
}

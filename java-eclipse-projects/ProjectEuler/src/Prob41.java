import java.util.ArrayList;


public class Prob41 {

	public static void main(String[] args) {
		
		ArrayList<Boolean> listOfPrimes = SieveOfEratosthenes.listOfPrimes(987654321);
		int i = 0;
		
		for(i = listOfPrimes.size()-1; i >= 0; i--) {
			if(listOfPrimes.get(i) == true) {
				if(Pandigital.isPandigital(i))
					System.out.println("The largest palindromic prime number is " + i);
					break;
			}
		}
	}
}

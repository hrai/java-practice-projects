
public class Factorial {

	//Calculating the factorial of a number
	public static double factorial(int d) {
		if(d <= 1) {
			return 1;
		}
		else if(d == 2) {
			return 2;
		}
		else
			return factorial(d-1) * d;
	}
}

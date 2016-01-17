

public class AverageNum
{
	public static void main(String[] args) {
		int[] list1 = { 1, 2, 3, 4, 5, 6 };
		double[] list2 = { 6.0D, 4.4D, 1.9D, 2.9D, 3.4D, 3.5D };
		
		System.out.println(average(list1));
		System.out.println(average(list2));
	}
	
	public static int average(int[] array) {
		int sum = 0;
		
		for(int i: array) {
			sum+= i;
		}
		return sum/array.length;
	}
	
	public static double average(double[] array) {
		double sum = 0;
		
		for(double d: array) {
			sum+= d;
		}
		return sum/array.length;
	}
}
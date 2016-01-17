package CSUTutorials;

import java.util.*;

public class PracticeInClass2 {

	public static void main(String[] args) {
		
		//sumDigits() method
		
		//initialising Scanner
		Scanner scanner = new Scanner(System.in);
		
		//prompt the user to enter number
		System.out.println("Please enter a number: ");
		long n = Long.parseLong(scanner.next());	//converting the input to type 'long'
		
		//printing the output of the execution
		System.out.println(sumDigits(n));
		
		//Octagon Class
		Octagon oct = new Octagon(5);
		Octagon oct2 = (Octagon) oct.clone();
		
		if(oct.compareTo(oct2) == 0) {
			System.out.println("The objects are same.");
		}
		
		//Person class
		Person per = new Person();
		Student1 stu = new Student1();
		Employee1 emp = new Employee1();
		Faculty fac = new Faculty();
		Staff stf = new Staff();
		
		System.out.println(per.toString());
		System.out.println(stu.toString());;
		System.out.println(emp.toString());;
		System.out.println(fac.toString());;
		System.out.println(stf.toString());;
		
		
		
		//sumMajorDiagonal() method
		int[][] arr = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}};
		System.out.println(sumMajorDiagonal(arr));;
		
		
	}
	
	/* Return the sum of all the digits in the passed parameter */
	public static int sumDigits(long n) {
		int result = 0;
		
		//execute loop while the number n is equal to 0
		while(n != 0) {
			result+= n%10;	//add the last digit to result
			n = n/10;	//remove the last digit from n
		}
		
		return result;
	}
	
	/* Sum the major diagonal in a matrix */
	public static int sumMajorDiagonal(int[][] m) {
		int result = 0;
		
		for(int i=0; i<m.length; i++) {	//looping through the rows
			for(int j=i; j<m[i].length; j++) {	//looping through the columns
				//check if the element is diagonal in location
				if(i == j) {
					result+= m[i][j];
				}
			}
		}
		
		return result;
	}
	
}

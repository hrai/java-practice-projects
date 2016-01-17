
package CSUTutorials;

import java.util.*;

public class PracticeInClass1 {

    
    public static void main(String[] args) {
        
        //initialising power() method
        System.out.println(power(5,4));
        
        //initialising getMinimum() method
        System.out.println(getMinimum(2.3, 23.1, 2.3));
        
        //initialising getGrade() method
        System.out.println(getGrade(90));
        
        //initialising isSorted() method
        int[] arr = {23,52,82,93};
        System.out.println(isSorted(arr));
        
        //initialising eCalculate()
        System.out.println(eCalculate(1000));
        
        //initialising factorial() method
        System.out.println(factorial(10));
        
        //initialising convertTime() method
        System.out.println(convertTime(11,20,"am"));
        
        
        
        //initialising area() method
        try {
        	Scanner scan = new Scanner(System.in);	//creating scanner object
            
            System.out.print("Please enter the number of sides: ");
            //it throws NumberFormatException
            int n = Integer.parseInt(scan.next());	//saving the input to int n
            
            System.out.print("Please enter the length of the side: ");
            //it throws NumberFormatException
            double side = Double.parseDouble(scan.next());	//saving the input to double side
            
            System.out.println(area(n, side));	//printing the area of the polygon
        }
        catch(NumberFormatException e) {
        	System.out.println("Input is not a number.");
        }
        
        
        //manipulating the Rectangle class
        Rectangle r1 = new Rectangle();
        Rectangle r2 = new Rectangle();
        
        //creating a new array of type Rectangle to hold the objects of type Rectangle
        Rectangle[] rectArr = {r1, r2};
        
        //loop to print the properties of the rectangle objects
        for(Rectangle r: rectArr) {
        	System.out.println("Height is " + r.getHeight());
        	System.out.println("Width is " + r.getWidth());
        	System.out.println("Colour is " + r.getColour());
        	System.out.println("Area is " + r.getArea());
        	System.out.println("Perimeter is " + r.getPerimeter());
        }
        
        
    }
    
    /*
     * Takes a double base value and an integer power value and returns the value of base raised to power 'power' value
     */
    public static double power(double x, int n) {
        
        double result = 1;
        
        if(n < 0) {
            return 0;
        }
        
        else if(n == 0) {
            return 1;
        }
        
        
        else {
            //multiplying the product with the base number
             for(int i=0; i<n; i++) {
                 result *= x;
             }
            return result;
        }
        
        
    }

    public static double getMinimum(double a, double b, double c) {
        double result = a;
        
        //check if 'c' is the smallest value
        if(a >= b && b >= c) {
            result = c;
        }
        //check if 'b' is the smallest value
        else if(a >= c && c >= b) {
            result = b;
        }
        
        return result;
        
    }

    public static String getGrade(int mark) {
        
        String[] gradeList = Grades.getGradeList();
        int[] gradeMin = Grades.getGradeMin();
        String s = "";
        
        for(int i=0; i<gradeList.length; i++) {
            if(mark >= gradeMin[i]) {
                s = gradeList[i];
                break;
            }
        }
        
        return s;
        
    }

    public static boolean isSorted(int[] input) {
        
        boolean result = false;
        
        for(int i=0; i<input.length-1; i++) {
            if(input[i] < input[i+1]) {
                result = true;
            }
            else {
                result = false;
                break;
            }
        }
        
        return result;
    }

    public static double eCalculate(int n) {
        
        double e = 1;
        
        //calculating 'e'
        for(int i=1; i<=n; i++) {
            e = e + (1/factorial(i));
        }
        
        //return the calculated value of 'e'
        return e;
    }
    
    private static double factorial(int n) {
        
        //use double instead of long as double has larger range of values
        double result = 1;
        
        if(n == 0 || n == 1) {
            return 1;
        }
        else {
            result = n * factorial(n-1);
        }
        
        return result;
        
    }
    
    public static void scoresAbove(Student[] students, double mark) {
    	
    	//loop to access every student object in 'students' array
    	for(int i=0; i<students.length; i++) {
    		//check if the student's mark is greater than the mark parameter
    		if(students[i].getScore() >= mark) {
    			//print the name of the student whose mark is greater than the mark parameter
    			System.out.println(students[i].getName());
    		}
    	}
    }
    
    public static int convertTime(int hour, int min, String s) {
        StringBuilder sb  = new StringBuilder();
        
        //validating the integers
        if(Integer.toString(hour).length() > 2 || Integer.toString(min).length() > 2) {
            return -1;
        }
        //converting the time to 24 hour format
        else if(s.equals("pm") || s.equals("am")) {	//validating the string
            if(s.equals("pm")) {
                sb.append(12 + hour);
                sb.append(min);
            }
            else {
                sb.append(hour);
                sb.append(min);
            }
            //converting stringbuilder to string
            String result = sb.toString();
            //converting string to integer
            return Integer.parseInt(result);
        }
        else return -1;	//return -1 when the string is neither 'am' nor 'pm'
        
    }
    
    public static double area(int n, double side) {
    	
    	double area = 0;
    	
    	//calculating the area
    	area = (n * Math.pow(side, 2))/(4 * Math.tan(Math.PI/n));	
    	
    	return area;
    }
    
}

class Grades {
    
    private static String[] gradeList = {"alpha", "beta", "gamma"};
    private static int[] gradeMin = {75, 50, 0};
    
    //getting the grade list
    public static String[] getGradeList() {
        return gradeList;
    }
    
    //getting the grade bases
    public static int[] getGradeMin() {
        return gradeMin;
    }
}

class Student {
	
	private String name;
	private double score;
	
	/*
	 * Default constructor to create an object
	 */
	public Student() {
		this("null", 0);
	}
	
	/*
	 * Parameterised constructor to create an object
	 */
	public Student(String name, double score) {
		this.name = name;
		this.score = score;
	}
	
	/*
	 * Returns a name string
	 */
	public String getName() {
		return name;
	}
	
	/*
	 * Returns a score of type double
	 */
	public double getScore() {
		return score;
	}
	
}

class Rectangle {
	
	private double height = 1;
	private double width = 1;
	private String colour = "WHITE";
	
	/* No arguments constructor */
	public Rectangle() {
		height = 1;
		width = 1;
		colour = "WHITE";
	}
	
	/* Return the height */
	public double getHeight() {
		return height;
	}
	
	/* Return the width */
	public double getWidth() {
		return width;
	}
	
	/* Return the colour */
	public String getColour() {
		return colour;
	}
	
	/* Set height */
	public void setHeight(double height) {
		this.height = height;
	}
	
	/* Set width */
	public void setWidth(double width) {
		this.width = width;
	}
	
	/* Set colour */
	public void setColour(String colour) {
		this.colour = colour;
	}
	
	/* Return the area */
	public double getArea() {
		
		return height * width;
	}
	
	/* Return the perimeter */
	public double getPerimeter() {
		
		return 2 * (height + width);
	}
	
}

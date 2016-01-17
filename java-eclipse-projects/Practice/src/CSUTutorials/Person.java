package CSUTutorials;

import java.util.*;

/* Person class */
public class Person {

	protected String name;
	protected String address;
	protected String phNum;
	protected String eAdd;
	
	public String toString() {
		return String.format("The name of the person is %s and the class name is %s\n", this.name, this.getClass().getName());
	}
	
}

/* Student class */
class Student1 extends Person {
	
	public static final String STATUS = "freshman";
	
	public String toString() {
		return String.format("The name of the person is %s and the class name is %s\n", this.name, this.getClass().getName());
	}
	
}

/* Employee class */
class Employee1 extends Person {
	
	protected String office;
	protected double salary;
	protected Date dateHired;
	
	public String toString() {
		return String.format("The name of the person is %s and the class name is %s\n", this.name, this.getClass().getName());
	}
	
}

/* Faculty class */
class Faculty extends Employee1 {
	
	private double officeHrs;
	private int rank;
	
	public String toString() {
		return String.format("The name of the person is %s and the class name is %s\n", this.name, this.getClass().getName());
	}
	
}

/* Staff class */
class Staff extends Employee1 {
	
	private String title;
	
	public String toString() {
		return String.format("The name of the person is %s and the class name is %s\n", this.name, this.getClass().getName());
	}
	
}

/* MyDate class */
class MyDate {
	
	private int year;
	private int month;
	private int day;
}
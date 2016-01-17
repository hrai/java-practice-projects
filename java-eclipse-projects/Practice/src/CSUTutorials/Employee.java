package CSUTutorials;

/* Employee class */
public class Employee {
	
	private String name;
	private double salary;
	
	/* Default empty constructor */
	public Employee() {}
	
	/* Constructor for the class with just the name */
	public Employee(String name) {
		this.name = name;
		salary = 0;
	}
	
	/* Constructor for the class with both name and salary */
	public Employee(String name, double salary) {
		this.name = name;
		this.salary = salary;
	}
	
	/* Mutator method for setting the value of salary */
	public void setSalary(double salary) {
		
		//change the salary only if the entered salary is between 0 and 100000
		if(salary >= 0 && salary <= 100000) {
			this.salary = salary;
		}		
	}
	
	/* Accessor method for name */
	public String getName() {
		return name;
	}
	
	/* Accessor method for salary */
	public double getSalary() {
		return salary;
	}
}

/*TestEmployee class*/
class TestEmployee {
	
	public static void main(String[] args) {			
		Employee emp1 = new Employee("Fred");
		emp1.setSalary(45000);
		
		Employee emp2 = new Employee("Sue", 55000);
		
		System.out.printf("Employee's name is %s & salary is %f\n", emp1.getName(), emp1.getSalary());
		System.out.printf("Employee's name is %s & salary is %f\n", emp2.getName(), emp2.getSalary());
	}
	
}

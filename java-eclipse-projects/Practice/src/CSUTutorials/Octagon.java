package CSUTutorials;

public class Octagon implements Cloneable, Comparable<Octagon> {
	
	private double side;
	
	/* Default empty constructor */
	public Octagon() {}
	
	/* Parameterised constructor */
	public Octagon(double side) {
		this.side = side;
	}
	
	/* Accessor method for side */
	public double getSide() {
		return side;
	}
	
	/* Mutator method for side */
	public void setSide(double side) {
		this.side = side;
	}
	
	/* Calculate the area of the polygon */
	public double calculateArea(double side) {
		return ((2 + 4/(Math.sqrt(2))) * Math.pow(side, 2));
	}
	
	/* Implement the compareTo() method */
	public int compareTo(Octagon a) {
		if(this.calculateArea(side) < a.calculateArea(a.getSide())) {
			return -1;
		}
		else if(this.calculateArea(side) == a.calculateArea(a.getSide()))
			return 0;
		else
			return 1;
	}
	
	/* Implement clone() method */
	public Object clone() {
		
		try {
			Octagon oct = (Octagon)super.clone();
			return oct;
		}
		catch(CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
}

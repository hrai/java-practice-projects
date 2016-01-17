package assignment2;

public class Node implements Comparable<Node> {
	
	private double coefficient;
	private double degree;
	private Node pointer;
	
	public Node() {
		
	}
	
	public Node(double coefficient, double degree, Node pointer) {
		this.coefficient = coefficient;
		this.degree = degree;
		this.pointer = pointer;
	}
	
	public double getCoefficient() {
		return coefficient;
	}
	 
	public void setCoefficient(double coefficient) {
		this.coefficient = coefficient;
	}
	
	public double getDegree() {
		return degree;
	}
	
	public void setDegree(double degree) {
		this.degree = degree;
	}
	
	public Node getPointer() {
		return pointer;
	}
	
	public void setPointer(Node pointer) {
		this.pointer = pointer;
	}
	
	public int compareTo(Node node) {
		if(this.degree < node.getDegree()) {
			return -1;
		}
		else if(this.degree == node.getDegree()) {
			return 0;
		}
		else
			return 1;
	}
	
	public boolean hasSameDegree(Node node) {
		if(node.getDegree() == 0)
			return false;
		
		return this.compareTo(node) == 0; 
	}
	
	public Node addEqualPowerNodes(Node node) {
		this.setCoefficient(coefficient + node.getCoefficient());
		
		return this;
	}
}

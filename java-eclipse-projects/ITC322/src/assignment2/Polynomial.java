package assignment2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;

public class Polynomial {
	
	private LinkedList<Node> nodes = new LinkedList<Node>();

	public Polynomial() {
		
	}
	
	public Polynomial(File file) throws IOException {
		Polynomial poly = new Polynomial();
		
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line = "";
		while((line = br.readLine()) != null) {
			String[] nums = line.split(" ");
			poly.getNodes().add(new Node(Double.parseDouble(nums[0]), Double.parseDouble(nums[1]), null));
		}
	}
	
	public Polynomial(String[] args) {
		Polynomial poly = new Polynomial();		
		double coeff = 0, power = 0;
		
		for(String str: args) {
			if(str != null) {
				String[] nums = str.split(" ");
				
				coeff = Double.parseDouble(nums[0]);
				power = Double.parseDouble(nums[1]);
				
				poly.getNodes().add(new Node(coeff, power, null));
			}
		}
	}
	
	public LinkedList<Node> getNodes() {
		return nodes;
	}

	public void setMonomials(LinkedList<Node> nodes) {
		this.nodes = nodes;
	}

	public Polynomial add(Polynomial poly) {
		Polynomial result = new Polynomial();
		Collections.sort(this.nodes);
		Collections.sort(poly.getNodes());
		
		index:for(int i = 0; i < this.getNodes().size(); i++) {
			Node monomial1 = this.getNodes().get(i);
			for(int j = 0; j < poly.getNodes().size(); j++) {
				Node monomial2 = poly.getNodes().get(j);
				
				if(monomial1.hasSameDegree(monomial2)) {
					monomial1.setCoefficient(monomial1.getCoefficient() + monomial2.getCoefficient());
					result.insertTerm(monomial1);
					continue index;
				}
				else if(monomial1.compareTo(monomial2) > 0) {
					result.insertTerm(monomial2);
					continue index;
				}
			}
			result.insertTerm(monomial1);
		}
		
		Collections.sort(result.getNodes());
		
		return result;
	}
	
	public double getValue(double value) {
		double sum = 0;
		
		for(Node node: nodes) {
			sum += (node.getCoefficient() * (Math.pow(value, node.getDegree())));
		}
		
		return sum;
	}
	
	public Polynomial multiply(Polynomial poly) {
		Polynomial result = new Polynomial();
		
		for(Node n: poly.getNodes()) {
			result.add(this.multiply(n));
		}
		
		return result;
	}
	
	public Polynomial multiply(Node node) {
		for(Node n: nodes) {
			n.setCoefficient(n.getCoefficient() * node.getCoefficient());
			n.setDegree(n.getDegree() + node.getDegree());
		}
		
		return this;
	}
	
	public Polynomial getDerivative() {
		for(Node n: nodes) {
			if(n.getDegree() == 0) {
				continue;
			}
			n.setCoefficient(n.getDegree() * n.getCoefficient());
			n.setDegree(n.getDegree() - 1);
		}
		
		return this;
	}
	
	public boolean insertTerm(Node node) {
		for(int i=0; i<nodes.size(); i++) {
			if(nodes.get(i).compareTo(node) < 0) {
				nodes.add(i, node);
				return true;
			}
		}
		return false;
	}
	
	public String toString() {
		String result = "";
		
		for(Node n: nodes) {
			result+= n.getCoefficient() + "x^" + n.getDegree();
		}
		
		return result;
	}
}

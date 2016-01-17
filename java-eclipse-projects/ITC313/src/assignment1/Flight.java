package assignment1;
import java.util.*;
import java.io.*;

public abstract class Flight implements Serializable {
	
	protected static int lastFlightNum = 0;
	
	private int flightNum;
	private String origin;
	private String destination;
	private Date date;
	private int etd;
	private int eta;
	protected double basePrice;
	protected double concession;
	private List<Movie> movies = new LinkedList<Movie>();
	
	protected Flight() {
		//No args constructor
	}
	
	//Constructor with arguments
	protected Flight(String origin, String destination, Date date, int etd, int eta, double basePrice, double concession) {
		this.origin = origin;
		this.destination = destination;
		this.date = date;
		this.etd = etd;
		this.eta = eta;
		this.basePrice = basePrice;
		this.concession = concession;
		this.flightNum = ++lastFlightNum;
	}

	//Getters and setters
	public int getFlightNum() {
		return flightNum;
	}
	
	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getEtd() {
		return etd;
	}

	public void setEtd(int etd) {
		this.etd = etd;
	}

	public int getEta() {
		return eta;
	}

	public void setEta(int eta) {
		this.eta = eta;
	}

	public double getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(double basePrice) {
		this.basePrice = basePrice;
	}

	public double getConcession() {
		return concession;
	}

	public void setConcession(double concession) {
		this.concession = concession;
	}
	
	public List<Movie> getMovieList() {
		return movies;
	}
	
	public String addMovie(Movie m) {
		movies.add(m);
		return m.getName();
	}
	
	//abstract method
	public abstract double book(Customer cust);
		
}

package assignment1;
import java.io.*;
import java.util.*;

public class Customer implements Serializable {
	
	private static int lastID = 0;
	
	private int ID;
	private String givenName;
	private String familyName;
	private int childSeats;
	private int adultSeats;
	private int numFlights;
	private double cost;
	private LinkedList<Flight> bookedFlights = new LinkedList<Flight>();
	
	//Constructor
	public Customer(String givenName, String familyName, int childSeats, int adultSeats) {
		this.givenName = givenName;
		this.familyName = familyName;
		this.childSeats = childSeats;
		this.adultSeats = adultSeats;
		this.ID = ++lastID;
	}
	
	//Getters and setters
	public int getID() {
		return ID;
	}
	
	public String getGivenName() {
		return givenName;
	}

	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public int getChildSeats() {
		return childSeats;
	}

	public void setChildSeats(int childSeats) {
		this.childSeats = childSeats;
	}

	public int getAdultSeats() {
		return adultSeats;
	}

	public void setAdultSeats(int adultSeats) {
		this.adultSeats = adultSeats;
	}
	
	public int getNumFlights() {
		return numFlights;
	}

	public void setNumFlights(int numFlights) {
		this.numFlights = numFlights;
	}

	public LinkedList<Flight> getBookedFlights() {
		return bookedFlights;
	}

	public void addBookedFlights(Flight bookedFlight) {
		bookedFlights.add(bookedFlight);//add the flight to the list according to the increasing order of the date
		System.out.println("The booked flight was added to the customer successfully.");
	}

	public double getCost() {
		return cost;
	}

	//Adding the cost 
	public void addCost(double amount) {
		this.cost += amount;
	}

	//Adding the number of flights booked by the customer
	public void addFlight() {
		this.numFlights++;
	}
	
	@Override
	public String toString() {
		return "The customer's name is " + givenName + " " + familyName + " and customer ID is '" + ID + "'.";
	}
	
}

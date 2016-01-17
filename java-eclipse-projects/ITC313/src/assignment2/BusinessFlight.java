package assignment2;

import java.util.*;

public class BusinessFlight extends Flight {
	
	private double rate;
	
	public BusinessFlight(String origin, String destination, Date date,
			int etd, int eta, double baseprice, double concession,
			double rate) {
		super(origin, destination, date, etd, eta, baseprice, concession);
		this.rate = rate;
	}

	//Getters and setters
	public double getRate() {
		return rate;
	}
	
	public void setRate(double rate) {
		this.rate = rate;
	}

	@Override
	public double book (Customer cust) {
		double cost;
		
		//Calculating the value of cost
		cost = basePrice * rate * (cust.getAdultSeats() + (cust.getChildSeats() * concession));
		
		//Updating the number of flights booked by the Customer 'cust'
		cust.addFlight();
		
		//Setting the value of the Customer 'cust's' total cost
		cust.addCost(cost);
		 
		return cost;
	}
	
	public String toString() {
		return "It is a business flight and the flight ID is '" + super.getFlightNum() + "'.";
	}
}

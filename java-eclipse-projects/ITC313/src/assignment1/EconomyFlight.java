package assignment1;
import java.util.Date;

public class EconomyFlight extends Flight {
	
	private double groupDiscount;
	
	//Constructor with arguments
	public EconomyFlight(String origin, String destination, Date date,
			int etd, int eta, double baseprice, double concession,
			double groupDiscount)
			{
			super(origin, destination, date, etd, eta, baseprice, concession);
			this.groupDiscount = groupDiscount;
	}	

	//Getters and setters
	public double getGroupDiscount() {
		return groupDiscount;
	}

	public void setGroupDiscount(double groupDiscount) {
		this.groupDiscount = groupDiscount;
	}
	
	@Override
	public double book(Customer cust) {
		int totalSeats = cust.getAdultSeats() + cust.getChildSeats();
		double cost;

		//Calculating the value of total cost
		cost = 4 * basePrice + (groupDiscount * basePrice * (totalSeats-4));
		
		//Setting the value of Customer cust's number of flights
		cust.addFlight();
		
		//Setting the value of Customer cust's cost
		cust.addCost(cost);
		
		return cost;
	}
		
	//toString() method
	public String toString() {
		return "It is an economy flight and the flight ID is '" + super.getFlightNum() + "'.";
	}
}

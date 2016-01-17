package assignment2;

import java.io.*;
import java.util.*;

public class TravelAgent implements Serializable {
	
	private String name;
	private List<Customer> customers = new LinkedList<Customer>();
	private List<Flight> flights = new LinkedList<Flight>();

	//Constructor with arguments
	public TravelAgent(String name) {
		this.name = name;
	}
	
	//Getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Customer> getCustomerList() {
		return customers;
	}

	public List<Flight> getFlightList() {
		return flights;
	}

	public void setCustomerList(List<Customer> customers) {
		this.customers = customers;
	}

	public void setFlightList(List<Flight> flights) {
		this.flights = flights;
	}

	//Adds a new Customer object to the list
	public int addCustomer(Customer cust) {
		customers.add(cust);//adding the newly created customer to the list
		return cust.getID();
	}
	
	public int addFlight(Flight fly) {
		flights.add(fly);//adding the Flight object to the list
		return fly.getFlightNum();
	}
	
	//Sorting the customers in the order of their first name
	public void sortCustomers(List<Customer> cust) {
		for(int i=0; i<cust.size(); i++) {
			for(int j=i; j<cust.size(); j++) {
				//Check if the object at index i has the name before the object at index j
				if(cust.get(i).getFamilyName().toUpperCase().compareTo(cust.get(j).getFamilyName().toUpperCase()) > 0) {
					//swapping the customer objects
					Collections.swap(cust, i, j);
				}
			}
		}
	}
	
	//Sorting the flights in the order of their flight numbers
	public void sortFlights(List<Flight> flight) {
		for(int i=0; i<flight.size(); i++) {
			for(int j=i; j<flight.size(); j++) {
				//Check if the object at index i has the name before the object at index j
				if(flight.get(i).getFlightNum() > flight.get(j).getFlightNum()) {
					//swapping the Flight objects
					Collections.swap(flight, i, j);
				}
			}
		}
	}
		
	//toString() method
	public String toString() {
		return "The name of the travel agent is " + name + ".";
	}
	
}

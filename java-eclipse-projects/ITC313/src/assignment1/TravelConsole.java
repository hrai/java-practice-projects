package assignment1;
import java.util.*;
import java.io.*;
import java.text.*;

/********************************************************
 * TravelConsole defines a console based user interface,
 * which when combined with the problem domain classes 
 * forms an executable application.
 ********************************************************
 */
public class TravelConsole {

	//declaring class variables
	private static Scanner scanner = new Scanner(System.in);
	private static TravelAgent agent;
	private static String dashes = "-------------------------------------------------";
	private static File file = new File("E:\\assignment1.dat");
	
	/* Get user input */
	public static int getMenuOption() {
		while(true) {
			try {
				int input = scanner.nextInt();
				scanner.nextLine(); //reading the carriage return
				return input;
			}
			catch(Exception e) {
				System.out.println("Invalid input. Please enter a number.");
				scanner.nextLine();//skipping the wrong input
				continue;
			}
		}
	}
	
	/* Printing the prompt for user */
	public static void printPrompt(String s) {
		System.out.println("Please enter the " + s + ": ");
	}

	/* Main method whose thread method executes all the methods */
	public static void main(String[] args) {
		agent = new TravelAgent("My Agent");
		
		createObjects();//Creating objects
		
		//Loop continually asks for input until the user enters '0'
		index: while(printMenu()) {
			
			switch (getMenuOption()) {
				case 0: saveToFile(file);
					break index;
					
				case 1: addObject();
					System.out.println();
					break;
					
				case 2: listObjects();
					System.out.println();
					break;
				
				case 3: deleteObject();
					System.out.println();
					break;
					
				case 4: bookFlight();
					System.out.println();
					break;
					
				case 5: searchCustomer();
					System.out.println();
					break;
					
				case 6: searchFlight();
					System.out.println();
					break;
					
				case 7: editObject();
					System.out.println();
					break;
					
				case 8: displayItinerary();
					System.out.println();
					break;
				
				default: System.out.println("Invalid menu option. Try again.");
				
			}
		}
	}
	
	/* Creates the objects when the program starts */
	public static void createObjects() {
		
		//Creating movie objects
		Movie mov1 = new Movie("The Muppets", 0200);		
		Movie mov2 = new Movie("Paranorman", 0145);
		
		//Creating EconomyFlight objects
		agent.addFlight(new EconomyFlight("Sydney", "London", stringToDate("02/01/2012"), 1000, 1500, 200, 0.5, 0.2));
		agent.addFlight(new EconomyFlight("Sydney", "Singapore", stringToDate("03/04/2012"), 1300, 0100, 200, 0.5, 0.2));
		
		//Creating BusinessFlight objects		
		Flight f3 = new BusinessFlight("Sydney", "Tokyo", stringToDate("03/03/2012"), 2000, 1200, 300, 0.5, 3.1);
		f3.addMovie(mov1);
		
		Flight f4 = new BusinessFlight("Sydney", "HongKong", stringToDate("01/02/2012"), 2030, 2400, 300, 0.5, 3.1);
		f4.addMovie(mov2);
		
		//Linking Flight objects to TravelAgent object
		agent.addFlight(f3);
		agent.addFlight(f4);
		
		//Linking Customer objects to TravelAgent object
		agent.addCustomer(new Customer("Harry", "Perry", 2, 4));
		agent.addCustomer(new Customer("Pedro", "Martin", 4, 3));
		agent.addCustomer(new Customer("Nita", "Bern", 4, 3));
	}
	
	/* Adds new objects to the system */
	public static void addObject() {
		//Ask user which object s/he wants to add and loop until the input is valid
		while(true) {
			System.out.println(dashes);

			System.out.println("If you want to add a new flight, type '1':");
			System.out.println("If you want to add a new customer, type '2':");
			System.out.println("If you want to add a new movie, type '3':");
			
			int input = getMenuOption();
			
			if(input == 1) {
				//loop until the user enters the valid input
				while(true) {
					System.out.println("If you want to add a new EconomyFlight, type '1':");
					System.out.println("If you want to add a new BusinessFlight, type '2'");
					
					int input1 = getMenuOption();
					scanner.nextLine();//getting rid of line feed
					
					if(input1 == 1) {
						//Ask user for attribute values and create an object
						createAndAddFlight("economyFlight");
						break;
					}
					else if(input1 == 2) {
						//Ask user for attribute values and create an object
						createAndAddFlight("businessFlight");
						break;
					}
				}
				
				break;
			}
			else if(input == 2) {
				createAndAddCustomer();
				break;
			}
			else if(input == 3) {
				createAndAddMovie();
				break;
			}
		}
	}

	/* Creating a Flight object and adding it to the list */
	public static void createAndAddFlight(String flightType) {
		String origin;
		String destination;
		Date date;
		int etd;
		int eta;
		double basePrice;
		double concession;
		double groupDiscount;
		double rate;
		
		printPrompt("flight's origin");//calling printPrompt method
		origin = scanner.nextLine().trim();//saving the read value from the keyboard to the respective attribute
		printPrompt("flight's destination");
		destination = scanner.nextLine().trim();
		printPrompt("date of flight (dd/mm/yyyy)");
		date = stringToDate(scanner.nextLine().trim());
		printPrompt("flight's etd");
		etd = getMenuOption();
		printPrompt("flight's eta");
		eta = getMenuOption();
		printPrompt("flight's baseprice");
		basePrice = scanner.nextDouble();
		printPrompt("concession offered by flight");
		concession = scanner.nextDouble();
		
		if(flightType.equalsIgnoreCase("economyFlight")) {
			printPrompt("group discount offered by flight");
			groupDiscount = scanner.nextDouble();
			Flight f = new EconomyFlight(origin, destination, date, etd, eta, basePrice, concession, groupDiscount);
			System.out.println("An economy flight with flight ID " + agent.addFlight(f) + " was created.");
		}
		else if(flightType.equalsIgnoreCase("businessFlight")) {
			printPrompt("rate of flight");
			rate = scanner.nextDouble();
			Flight f = new BusinessFlight(origin, destination, date, etd, eta, basePrice, concession, rate);
			System.out.println("A business flight with flight ID " + agent.addFlight(f) + " was created.");
		}
	}

	/* Creating and adding Customer to the list */
	public static void createAndAddCustomer() {
		String givenName;
		String familyName;
		int childSeats;
		int adultSeats;
		
		printPrompt("customer's given name");//calling printPrompt method
		givenName = scanner.nextLine().trim();//saving the read value from the keyboard to the respective attribute
		printPrompt("customer's family name");
		familyName = scanner.nextLine().trim();
		printPrompt("child seats booked by customer");
		childSeats = getMenuOption();
		printPrompt("adult seats booked by customer");
		adultSeats = getMenuOption();
		
		//creating new customer
		Customer c = new Customer(givenName, familyName, childSeats, adultSeats);
		//adding the object to the list
		System.out.println("A customer with ID " + agent.addCustomer(c) + " was created.");
	}	

	/* Creating and adding Movie to the list */
	public static void createAndAddMovie() {
		String name;
		int length;
		boolean added = false;
		
		printPrompt("movie's name");//calling printPrompt method
		name = scanner.nextLine().trim();//saving the read value from the keyboard to the respective attribute
		printPrompt("movie's length");
		length = getMenuOption();
		
		//creating new movie
		Movie movie = new Movie(name, length);
		System.out.println("A movie with name " + movie.getName() + " was created.");
		
		System.out.println(dashes);//printing the dashes
		System.out.println("Type the name of the flight you want to add the movie to:");
		System.out.println("The flight numbers are as follows:");
		
		//printing the flight numbers of flights
		for(Flight f: agent.getFlightList()) {
			System.out.println(f.getFlightNum());
		}
		
		int flightNumber = getMenuOption();//Ask for the flight number
		for(Flight f: agent.getFlightList()) {
			if(f.getFlightNum() == flightNumber) {
				//Add movie to the flight and print confirmation
				System.out.println("The movie " + f.addMovie(movie) + " was successfully added to the flight.");
				added = true;
				break;
			}
		}
		if(!added) {
			System.out.println("The movie wasn't added to the flight.");
		}
	}
	
	/* Lists all the objects in the system according to the query of the user */
	public static void listObjects() {

		while(true) {
			//List the objects and their attributes
			System.out.println("If you want to list customers, type '1': ");
			System.out.println("If you want to list flights, type '2': ");
			System.out.println("If you want to list movies, type '3': ");
			
			int input = getMenuOption(); 
			
			if(input == 1) {
				agent.sortCustomers(agent.getCustomerList());//sorting the list of customers
				
				//Printing the Customer objects
				for(Customer cust: agent.getCustomerList()) {
					listCustomer(cust);
				}
				break;//break out of loop
			}
			else if(input == 2) {
				agent.sortFlights(agent.getFlightList());//sorting the list of flights
				
				//Printing the Flight objects and their attributes
				for(Flight flight: agent.getFlightList()) {
					listFlight(flight);
				}
				break;//break out of loop
			}
			else if(input == 3) {
				for(Flight flight: agent.getFlightList()) {
					if(!flight.getMovieList().isEmpty()) {
						System.out.println();
						System.out.println(dashes);
						System.out.println("The movies in flight '" + flight.getFlightNum() + "' are as follows:");
						for(Movie movie: flight.getMovieList()) {
							listMovie(movie);
						}
					}					
				}
				break;//break out of loop
			}
		}
	}
	
	/* Prints the flight's details */
	public static void listFlight(Flight flight) {
		System.out.println(dashes);
		System.out.println(flight.toString());
		System.out.println("Origin: " + flight.getOrigin());
		System.out.println("Destination: " + flight.getDestination());
		System.out.println("Date: " + flight.getDate());
		System.out.println("Etd: " + flight.getEtd());
		System.out.println("Eta: " + flight.getEta());
		System.out.println("Baseprice: " + flight.getBasePrice());
		System.out.println("Concession: " + flight.getConcession());
		
		//Checking the object's type
		if(flight instanceof BusinessFlight) {
			System.out.println("Rate: " + ((BusinessFlight) flight).getRate());
			System.out.println("Flight Number: " + ((BusinessFlight) flight).getFlightNum());
		}
		else {
			System.out.println("GroupDiscount: " + ((EconomyFlight) flight).getGroupDiscount());
			System.out.println("Flight Number: " + ((EconomyFlight) flight).getFlightNum());
		}
	}
	
	/* Prints the customer's information */
	public static void listCustomer(Customer customer) {
		System.out.println(dashes);
		System.out.println(customer.toString());
		System.out.println("ID: " + customer.getID());
		System.out.println("Given Name: " + customer.getGivenName());
		System.out.println("Last Name: " + customer.getFamilyName());
		System.out.println("ChildSeats: " + customer.getChildSeats());
		System.out.println("AdultSeats: " + customer.getAdultSeats());
		System.out.println("Number of Flights: " + customer.getNumFlights());
		System.out.println("Cost: " + customer.getCost());
	}
	
	/* Prints the movie's information */
	public static void listMovie(Movie movie) {
		System.out.println(dashes);
		System.out.println(movie.toString());
		System.out.println("Movie name: " + movie.getName());
		System.out.println("Movie length: " + movie.getLength());
	}
	
	/* Deletes an object from the system */
	public static void deleteObject() {
		
		index:while(true) {
			System.out.println(dashes);
			System.out.println("If you want to delete a customer, type '1':");
			System.out.println("If you want to delete a flight, type '2':");
			System.out.println("If you want to delete a movie, type '3':");
			boolean noObject = true;
			
			int input = getMenuOption(); 
			
			if(input == 1) { //if it is a customer
				printPrompt("customer's ID");
				int id = getMenuOption();
				
				//Removing the object with matching customer ID
				for(Customer c: agent.getCustomerList()) {
					if(id == c.getID()) {
						if(confirmAndRemove(c, agent.getCustomerList())) {
							noObject = false;
							break index;//break while-loop
						}
					}
				}
				if(noObject) 
					System.out.println("The customer doesn't exist.");
			}
			
			else if(input == 2) { //if it is a flight
				printPrompt("flight number");
				int id = getMenuOption();
				
				//Removing the object with matching flight number
				for(Flight f: agent.getFlightList()) {
					if(id == f.getFlightNum()) {
						if(confirmAndRemove(f, agent.getFlightList())) {
							noObject = false;
							break index;//break while-loop
						}
					}
				}
				if(noObject) 
					System.out.println("The flight doesn't exist.");
			}
			
			else if(input == 3) { //if it is a movie
				printPrompt("movie's name");
				String name = scanner.nextLine().trim();
				
				//Removing the object with matching movie name
				for(Flight f: agent.getFlightList()) {
					for(Movie m: f.getMovieList()) {
						if(name.equalsIgnoreCase(m.getName())) {
							if(confirmAndRemove(m, f.getMovieList())) {
								noObject = false;
								break index;//break while-loop
							}
						}
					}
				}
				if(noObject) 
					System.out.println("The movie doesn't exist.");
			}
		}
	}

	/* Confirming the removal of object */
	@SuppressWarnings("rawtypes")
	public static boolean confirmAndRemove(Object o, List list) {
		if(o instanceof Customer) {
			System.out.println("Do you want to remove " + ((Customer)o).getGivenName() + "? (Y/N) ");
			String input = scanner.nextLine().trim();
			
			//remove the item is the user presses 'y'
			if(input.equalsIgnoreCase("y")) {
				list.remove(o);
				System.out.println("The customer was removed.");
			}
			else {
				System.out.println("Customer wasn't removed.");
			}
			return true;
		}
		else if(o instanceof Flight) {
			if(((Flight) o).getMovieList() != null) {
				System.out.println("This flight has " + ((Flight)o).getMovieList().size() + " movies. Do you wish to delete the flight? (Y/N) ");
				String input = scanner.nextLine().trim(); 
				
				//remove the item if the user enters 'y'
				if(input.equalsIgnoreCase("y")) {
					list.remove(o);
					System.out.println("The flight was removed.");
				}
				else {
					System.out.println("Flight wasn't removed.");
				}
				return true;
			}
			else {
				System.out.println("Do you want to delete " + ((Flight)o).getFlightNum() + " flight? (Y/N) ");
				String input = scanner.nextLine().trim(); 
				
				//remove the item if the user enters 'y'
				if(input.equalsIgnoreCase("y")) {
					list.remove(o);
					System.out.println("The flight was removed.");
				}
				else {
					System.out.println("Flight wasn't removed.");
				}
				return true;
			}
		}
		else if(o instanceof Movie) {
			System.out.println("Do you want to delete " + ((Movie)o).getName() + " movie? (Y/N) ");
			String input = scanner.nextLine().trim();
			
			//remove the item if the user enters 'y'
			if(input.equalsIgnoreCase("y")) {
				list.remove(o);
				System.out.println("The movie was removed.");
			}
			else {
				System.out.println("Movie wasn't removed.");
			}
			return true;
		}
		return false;
	}

	/* Books a flight */
	public static void bookFlight() {
		//while loop asking for correct input
		index: while(true) {
			System.out.println(dashes);
			
			//printing the customer and their details for users
			for(Customer customer: agent.getCustomerList()) {
				System.out.println(customer.toString());
			}
			
			System.out.println();
			printPrompt("the customer ID");
			int cusID = getMenuOption();

			//checking if the user's input is a valid customer ID
			for(Customer c: agent.getCustomerList()) {
				if(c.getID() == cusID) {

					//printing the flights and their details for users
					for(Flight flight: agent.getFlightList()) {
						System.out.println(flight.toString());
					}
					
					System.out.println();
					printPrompt("the flight ID");
					int flightID = getMenuOption();
					
					//checking if the user's input is a valid flight ID
					for(Flight f: agent.getFlightList()) {
						if(f.getFlightNum() == flightID) {
							//book the flight and print the confirmation and cost
							System.out.println("The flight was booked.");
							System.out.println("The total cost of booking the flight is $" + f.book(c) + ".");
							
							//adding the booked flight to the customer's booked flight list
							c.addBookedFlights(f);
							
							break index;//break out of while loop
						}
					}
				}
			}
		}
	}
	
	/* Search for a customer by name or by id */
	public static void searchCustomer() {
		
		index:while(true) {
			//Prompt user for input
			System.out.println(dashes);
			System.out.println("If you want to search by customer name, type '1'");
			System.out.println("If you want to search by customer ID, type '2'");
			int input = getMenuOption(); 
			 
			
			if(input == 1) {
				printPrompt("customer's first name");
				String fName = scanner.nextLine().trim();
				
				//Checking if input corresponds to any customer's first name
				for(Customer c: agent.getCustomerList()) {
					if(c.getGivenName().equalsIgnoreCase(fName)) {
						System.out.println();
						System.out.println("The customer's details is as follows: ");
						listCustomer(c);
						
						break index; //break while-loop
					}
				}
				
				System.out.println("Customer with name '" + fName + "' doesn't exist.");
				break;
			}
			else if(input == 2) {
				printPrompt("customer's ID");
				int id = getMenuOption(); 
				 
				
				//Checking if input corresponds to any customer's ID
				for(Customer c: agent.getCustomerList()) {
					if(c.getID() == id) {
						System.out.println();
						System.out.println("The customer's details is as follows: ");
						listCustomer(c);
						
						break index; //break while-loop
					}
				}
				
				System.out.println("Customer with ID '" + id + "' doesn't exist.");
				break;
			}
		}
	}
	
	/* Search for a flight by a combination of destination and date */
	public static void searchFlight() {
		System.out.println(dashes);
		
		printPrompt("destination");
		String destination = scanner.nextLine().trim();
		printPrompt("date (dd/mm/yyyy)");
		Date date = stringToDate(scanner.nextLine().trim());
		System.out.println();
		
		for(Flight f: agent.getFlightList()) {
			if(f.getDestination().equalsIgnoreCase(destination) ||
					f.getDate().equals(date)) {
				System.out.println("The flight's details is as follows: ");
				listFlight(f);
				break;
			}
		}
		
		System.out.println("The flight with destination '" + destination + "' and date '" + 
				date + "' doesn't exist.");
	}
	
	/* Edit an object */
	public static void editObject() {
		boolean edited = false;
		System.out.println(dashes);
		
		System.out.println("If you want to edit a flight, type '1'");
		System.out.println("If you want to edit a customer, type '2'");
		System.out.println("If you want to edit a movie, type '3'");
		System.out.println("If you want to edit an agent, type '4'");
		int input = getMenuOption();
		
		if(input == 1) { //edit flight
			System.out.println("The flights and their details are as follows:");
			
			for(Flight f: agent.getFlightList()) {
				listFlight(f);	//list all the flights
			}
			
			System.out.println(dashes);
			System.out.println("Type the flight number of the flight you want to edit:");
			int fNumber = getMenuOption();
			 
			
			//Searching for flight with ID entered by the user
			for(Flight f: agent.getFlightList()) {
				if(f.getFlightNum() == fNumber) {
					listFlight(f);
					edited = editFlight(f);//edit flight
					
					break;//break out of for-loop
				}
			}
			if(!edited)
				System.out.println("Sorry the flight with number '" + fNumber + "' doesn't exist.");
			else
				System.out.println("Flight's details successfully edited.");
		}
		
		else if(input == 2) { //edit customer
			System.out.println("The customers and their details are as follows:");
			for(Customer c: agent.getCustomerList()) {
				listCustomer(c);	//list all the customers
			}
			
			System.out.println(dashes);
			System.out.println("Type the ID of the customer you want to edit:");
			int ID = getMenuOption();
			 
						
			//Searching the customer with ID entered by the user
			for(Customer c: agent.getCustomerList()) {
				if(c.getID() == ID) {
					listCustomer(c);
					edited = editCustomer(c);//edit flight
					
					break;//break out of for-loop
				}
			}
			if(!edited)
				System.out.println("Sorry the customer with ID '" + ID + "' doesn't exist.");
			else
				System.out.println("Customer's details successfully edited.");
		}
		
		else if(input == 3) { //edit movie
			System.out.println("The movie and their details are as follows:");
			for(Flight flight: agent.getFlightList()) {
				for(Movie movie: flight.getMovieList()) {
					listMovie(movie);	//list all the movies
				}
			}
			
			System.out.println(dashes);
			System.out.println("Type the name of the movie you want to edit:");
			String name = scanner.nextLine().trim();
			
			//Searching the movie with name entered by the user
			index:for(Flight flight: agent.getFlightList()) {
				for(Movie movie: flight.getMovieList()) {
					if(movie.getName().equalsIgnoreCase(name)) {
						listMovie(movie);
						edited = editMovie(movie); //editing movie
						
						break index; //break outer for-loop
					}
				}
			}
			if(!edited)
				System.out.println("The movie with name '" + name + "' doesn't exist.");
			else 
				System.out.println("Movie's details successfully edited.");
		}
		
		else if(input == 4) { //edit travel agent
			System.out.println("The name of the travel agent is: " + agent.getName());
			System.out.println(dashes);
			printPrompt("new agent name");
			agent.setName(scanner.nextLine().trim());	//setting user's input as new agent name
			
			System.out.println("Agent's details successfully edited.");
			
		}
	}
	
	/* Edit flight */
	public static boolean editFlight(Flight flight) {
		System.out.println(dashes);
		System.out.println("If you want to edit origin, type '1'");
		System.out.println("If you want to edit destination, type '2'");
		System.out.println("If you want to edit date, type '3'");
		System.out.println("If you want to edit etd, type '4'");
		System.out.println("If you want to edit eta, type '5'");
		System.out.println("If you want to edit base price, type '6'");
		System.out.println("If you want to edit concession, type '7'");
		
		if(flight instanceof EconomyFlight) 
			System.out.println("If you want to edit group discount, type '8'");
		else if(flight instanceof BusinessFlight) 
			System.out.println("If you want to edit rate, type '8'");
		
		//switch-case to get input and save it to the object
		switch(getMenuOption()) {
		
			case 1: 
				printPrompt("new flight origin");
				flight.setOrigin(scanner.nextLine().trim()); 
				return true;
				
			case 2: 
				printPrompt("new flight destination");
				flight.setDestination(scanner.nextLine().trim());
				return true;
			
			case 3: 
				printPrompt("new date (dd/mm/yyyy)");
				flight.setDate(stringToDate(scanner.nextLine().trim()));
				return true;
			
			case 4: 
				printPrompt("new etd");
				flight.setEtd(getMenuOption());
				return true;
			
			case 5: 
				printPrompt("new eta");
				flight.setEta(getMenuOption());
				return true;
			
			case 6: 
				printPrompt("new base price");
				flight.setBasePrice(scanner.nextDouble());
				return true;
			
			case 7: 
				printPrompt("new concession");
				flight.setConcession(scanner.nextDouble());
				return true;
			
			case 8: 
				if(flight instanceof EconomyFlight) {
					printPrompt("new group discount");
					((EconomyFlight) flight).setGroupDiscount(scanner.nextDouble());
				}
				else if(flight instanceof BusinessFlight) {
					printPrompt("new rate");
					((BusinessFlight) flight).setRate(scanner.nextDouble());
				}
				return true;	
				
			default:
				System.out.println("Invalid input.");
				return false;
		}
	}

	/* Edit customer */
	public static boolean editCustomer(Customer customer) {
		
		System.out.println(dashes);
		System.out.println("If you want to edit given name, type '1'");
		System.out.println("If you want to edit family name, type '2'");
		System.out.println("If you want to edit child seats, type '3'");
		System.out.println("If you want to edit adult seats, type '4'");
		System.out.println("If you want to edit number of flights, type '5'");
		
		switch(getMenuOption()) {
			case 1:
				printPrompt("new given name");
				customer.setGivenName(scanner.nextLine().trim());
				return true;
			
			case 2: 
				printPrompt("new family name");
				customer.setFamilyName(scanner.nextLine().trim());
				return true;
			
			case 3: 
				printPrompt("new child seats");
				customer.setChildSeats(getMenuOption());
				return true;
			
			case 4: 
				printPrompt("new adult seats");
				customer.setAdultSeats(getMenuOption());
				return true;
			
			case 5: 
				printPrompt("new number of flights");
				customer.setNumFlights(getMenuOption());
				return true;
			
			default:
				System.out.println("Invalid input.");
				return false;
		}
	}

	/* Edit movie */
	public static boolean editMovie(Movie movie) {
		
		System.out.println(dashes);
		System.out.println("If you want to edit name, type '1'");
		System.out.println("If you want to edit length, type '2'");
		
		switch(getMenuOption()) {
			case 1: 
				printPrompt("new name");
				movie.setName(scanner.nextLine().trim());
				return true;
			
			case 2: 
				printPrompt("length");
				movie.setLength(getMenuOption());
				return true;
			
			default:
				System.out.println("Invalid input.");
				return false;
		}
	}

	/* Display itinerary */
	public static void displayItinerary() {
		//Listing the customers' details
		for(Customer c: agent.getCustomerList()) {
			System.out.println(c.toString());
		}
		
		System.out.println();
		System.out.println("To view itinerary of the customer, type customer's ID: ");
		int id = getMenuOption();
		
		//Check for valid customer 
		for(Customer c: agent.getCustomerList()) {
			if(id == c.getID()) {
				if(c.getBookedFlights().isEmpty()) {
					System.out.println("The customer hasn't booked any flights yet.");
				}
				else 
					displayItinerary(c);	//displaying the itinerary of the selected customer
			}
		}
	}
	
	
	/* Produce itinerary for a customer */
	public static void displayItinerary(Customer customer) {
		LinkedList<Flight> bookedFlights = customer.getBookedFlights();
		
		for(Flight f: bookedFlights) {
			System.out.println("The flight with flight number " + f.getFlightNum() + " was booked on " + f.getDate() + " travelling from " + f.getOrigin()
					+ " to " + f.getDestination() + ".");
		}
	}
	
	/* Printing the menu */
	public static boolean printMenu() {
		System.out.println(dashes);

		System.out.println("Add an object? Type '1'");
		System.out.println("List objects? Type '2'");
		System.out.println("Delete an object? Type '3'");
		System.out.println("Book a flight for a customer? Type '4'");
		System.out.println("Search a customer? Type '5'");
		System.out.println("Search a flight? Type '6'");
		System.out.println("Edit an object? Type '7'");
		System.out.println("Display itinerary? Type '8'");
		System.out.println("Exit the program? Type '0'");
		
		return true;
	}

	/* Convert the string to date */
	public static Date stringToDate(String date) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date d = null;
		
		while(true) {
			try {
				d = sdf.parse(date);//parsing the date
				break;
			} catch (ParseException e) {
				System.out.println("Invalid date. Try again!");
				date = scanner.nextLine().trim();
				continue;
			}
		}
		return d;
	}
	
	/* Save lists to a file */
	public static void saveToFile(File file) {
		try {
			ObjectOutputStream br = new ObjectOutputStream(new FileOutputStream(file));
			
			//write the flight list to the file
			br.writeObject(agent.getFlightList());
			
			//write the customers to the file
			br.writeObject(agent.getCustomerList());

			br.close();//closing the output stream
			
			System.out.println("Information saved in the file successfully.");		
		}
		catch(IOException e) {
			System.out.println("Error saving information to file.");
			e.printStackTrace();
		}
	}
	
}

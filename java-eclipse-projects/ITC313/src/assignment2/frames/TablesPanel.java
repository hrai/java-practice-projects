package assignment2.frames;

import java.awt.*;
import java.util.*;
import java.util.List;
import javax.swing.*;
import javax.swing.table.*;
import assignment2.*;

public class TablesPanel extends JPanel {

	private String borderTitle;
	private DefaultTableModel tableMdl;
	private DefaultTableModel tableMdl1;
	private JTable table;
	private JTable table1;
	
	public TablesPanel(String objType) throws EmptyListException {
		final String objectType = new String(objType);
		tableMdl = new DefaultTableModel();
		tableMdl1 = new DefaultTableModel();

		//Layout for the panel
		this.setLayout(new GridLayout());
		
		if(objectType.equals("Flights")) {
			List<Flight> fList = TravelGUI.agent.getFlightList();
			borderTitle = "List of flights";
			
			//Check if list is empty
			if(fList.isEmpty()) 
				throw new EmptyListException("flights");
			else {

				//Creating column names
				tableMdl.addColumn("Flight No.");
				tableMdl.addColumn("Origin");
				tableMdl.addColumn("Destination");
				tableMdl.addColumn("Date");
				tableMdl.addColumn("Etd");
				tableMdl.addColumn("Eta");
				tableMdl.addColumn("Base Price");
				tableMdl.addColumn("Concession");
				tableMdl.addColumn("Group Discount");

				//Creating column names
				tableMdl1.addColumn("Flight No.");
				tableMdl1.addColumn("Origin");
				tableMdl1.addColumn("Destination");
				tableMdl1.addColumn("Date");
				tableMdl1.addColumn("Etd");
				tableMdl1.addColumn("Eta");
				tableMdl1.addColumn("Base Price");
				tableMdl1.addColumn("Concession");
				tableMdl1.addColumn("Rate");
				
				
				for(Flight flight: fList) {					
					if(flight instanceof EconomyFlight) {

						//Generating row items
						String[] rowItems = {Integer.toString(flight.getFlightNum()), flight.getOrigin(), flight.getDestination(), flight.getDate().toString(),
								Integer.toString(flight.getEtd()), Integer.toString(flight.getEta()), Double.toString(flight.getBasePrice()), 
								Double.toString(flight.getConcession()), Double.toString(((EconomyFlight) flight).getGroupDiscount())};
					
						tableMdl.addRow(rowItems);	//add items to table model
					}
					else if(flight instanceof BusinessFlight) {

						//Generating row items
						String[] rowItems = {Integer.toString(flight.getFlightNum()), flight.getOrigin(), flight.getDestination(), flight.getDate().toString(),
								Integer.toString(flight.getEtd()), Integer.toString(flight.getEta()), Double.toString(flight.getBasePrice()), 
								Double.toString(flight.getConcession()), Double.toString(((BusinessFlight) flight).getRate())};
					
						tableMdl1.addRow(rowItems);	//add items to table model
					}
				}
			}
			
			//Create tables from the table models
			table = new JTable(tableMdl);
			table1 = new JTable(tableMdl1);
			
		}
		else if(objectType.equals("Customers")) {
			List<Customer> customerList = TravelGUI.agent.getCustomerList();
			borderTitle = "List of customers";
			
			//Add column names
			tableMdl.addColumn("Customer ID");
			tableMdl.addColumn("Given Name");
			tableMdl.addColumn("Family Name");
			tableMdl.addColumn("Child Seats");
			tableMdl.addColumn("Adult Seats");
			
			//Throws an exception if list is empty
			if(customerList.isEmpty())
				throw new EmptyListException("customers");
			else {
				for(Customer c: customerList) {
					String[] rowItems = {Integer.toString(c.getID()), c.getFamilyName(), c.getGivenName(), Integer.toString(c.getChildSeats()), Integer.toString(c.getAdultSeats())};
					
					tableMdl.addRow(rowItems);	//Add items to table model
				}
			}
			
			//Create a table from the table model
			table = new JTable(tableMdl);
			
		}
		else {
			borderTitle = "List of movies";
			tableMdl.addColumn("Name");
			tableMdl.addColumn("Length");
			
			//Adding movies to the list model
			for(Flight f: TravelGUI.agent.getFlightList()) {
				List<Movie> movieList = f.getMovieList();
				
				//Throws an exception if list is empty
				if(movieList.isEmpty()) 
					throw new EmptyListException("movies");
				else {
					for(Movie movie: movieList) {
						String[] rowItems = {movie.getName(), Integer.toString(movie.getLength())};
						
						tableMdl.addRow(rowItems);	//Adding row items to the table model
					}
				}
			}

			//Create a table from the table model
			table = new JTable(tableMdl);
		}
		
		//For flights
		if(objType.equals("Flights")) {
			
			JPanel ecoTable = new JPanel();
			JPanel busTable= new JPanel();
			
			//Setting the size of above panels
			setTableHeight(table, 5);
			setTableHeight(table1, 5);

			//Setting the layout
			this.setLayout(new GridLayout(2,2));
			
			//Adding the tables to the panels
			ecoTable.add(new JScrollPane(table));
			busTable.add(new JScrollPane(table1));
			
			//Creating titled border
			ecoTable.setBorder(BorderFactory.createTitledBorder("Economy Flights"));
			busTable.setBorder(BorderFactory.createTitledBorder("Business Flights"));
			
			//Adding the panels with tables to the main panel
			this.add(new JScrollPane(ecoTable));
			this.add(new JScrollPane(busTable));
			
			//Creating a new bordered title for the panel
			this.setBorder(BorderFactory.createTitledBorder("List of Flights"));
			
		}
		else {	//For customers and movies			
			
			//Setting the size of table
			setTableHeight(table, 10);
			
			//Adding components to panel
			this.setBorder(BorderFactory.createTitledBorder(borderTitle));
			this.add(new JScrollPane(table), BorderLayout.CENTER);
		}
		
		this.setVisible(true);
		this.setPreferredSize(getPreferredSize());
		
	}

	/* Set a table height */
	public void setTableHeight(JTable table, int rows)
	{
	    int width = table.getPreferredSize().width; 
	    int height = rows * table.getRowHeight(); 
	    table.setPreferredScrollableViewportSize(new Dimension(width, height));
	}
	
	/* Accessor method for table */
	public JTable getTable() {
		
		return table;
	}

	/* Accessor method for table list */
	public ArrayList<JTable> getTableList() {
		ArrayList<JTable> tables = new ArrayList<JTable>();
		 
		tables.add(table);
		tables.add(table1);
		
		return tables;
	}
}


/************************************************
 * Creating a new exception class for empty lists
************************************************/
class EmptyListException extends Exception {
	
	/* Parameterised constructor */
	public EmptyListException(String objectType) {
		JOptionPane.showMessageDialog(null, "There are no " + objectType + ".");
	}
}


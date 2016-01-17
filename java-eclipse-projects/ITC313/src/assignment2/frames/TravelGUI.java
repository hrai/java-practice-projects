package assignment2.frames;

import java.util.List;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;
import assignment2.*;

public class TravelGUI extends JFrame {
	
	public static TravelAgent agent = new TravelAgent("My Agent"); //Creating new travel agent
	private JPanel panel1;
	private JPanel panel2;
	private JComboBox<String> menuBox;
	private JComboBox<String> objectTypeBox;
	private JButton goBtn;
	private JButton exitBtn;
	private JButton bookBtn;
	private JButton writeBtn;
	private JLabel lbl1;
	private JLabel lbl2;
	private static ObjectInputStream objInStream;
	private static ObjectOutputStream objOutStream;
	private static File fileLocation = new File("E:\\assignment2.dat");
	
	//No arguments constructor
	public TravelGUI() {

		super("Flight Booking System");
		
		panel1 = new JPanel();	//creating new JPanel	
		panel2 = new JPanel();
		goBtn = new JButton("GO");	//creating new JButton
		exitBtn = new JButton("EXIT");
		bookBtn = new JButton("BOOK A FLIGHT");
		writeBtn = new JButton("WRITE TO FILE");
		goBtn.setEnabled(false);	//disabling the button
		
		lbl1 = new JLabel("Please select one of the options: ");
		lbl2 = new JLabel("Please select the type of object: ");
		
		goBtn.setToolTipText("Select objects from dropdown list to to enable it");
		exitBtn.setToolTipText("Click to exit");
		bookBtn.setToolTipText("Click to book a flight");
		writeBtn.setToolTipText("Click to write the objects to file");
		
		//Combobox items
		String[] menuBoxobjectTypeBox = {"Select option...", "Add an object", "List objects",
				"Delete an object", "Modify an object"};
		menuBox = new JComboBox<String>(menuBoxobjectTypeBox);	//Creating a JComboBox
		
		//Combobox items
		String[] items = {"Select option...", "Flights", "Customers", "Movies"};
		objectTypeBox = new JComboBox<String>(items);	//Creating a JComboBox
		objectTypeBox.setEnabled(false); //disable the combo box

		
		//Adding item listener to the combo box
		menuBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e){
				objectTypeBox.setEnabled(true);	//enabling the other combo box
				
				//Disable the objectTypeBox 
				if(menuBox.getSelectedIndex() == 0) {
					objectTypeBox.setSelectedIndex(0);
					objectTypeBox.setEnabled(false);
				}
			}
		});
		
		//Adding item listener to the combo box
		objectTypeBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				//Check if any option is selected except the first one
				if(objectTypeBox.getSelectedIndex() == 0)
					goBtn.setEnabled(false);
				else
					goBtn.setEnabled(true);
				
			}
		});
		
		//Adding action listener to the go button
		goBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Getting the selected items from the combo boxes in string form
				String menuBoxOption = (String) menuBox.getSelectedItem();
				String objectType = (String) objectTypeBox.getSelectedItem();
				
				if(menuBox.isEnabled()) {
					switch(menuBoxOption) {
					
						case "Add an object":
							try {
								addObject(objectType);
							} catch (EmptyListException e3) {
								//do nothing
							}
							break;
							
						case "List objects":
							try {
								listObjects(objectType);
							} catch (EmptyListException e2) {
								//do nothing
							}
							break;
							
						case "Delete an object": 
							try {
								deleteObject(objectType);
							} catch (EmptyListException e2) {
								//do nothing
							}
							break;
							
						case "Modify an object":
							try {
								modifyObject(objectType);
							} catch (EmptyListException e1) {
								//do nothing
							}
							break;
							
						default:
							JOptionPane.showMessageDialog(null, "Please try again.");
					}
				}
			}
		});
		
		//Adding action listener to the exit button
		exitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		//Adding action listener to the book button
		bookBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					bookFlight();
				} catch (EmptyListException e2) {
					//do nothing
				}
			}
		});
		
		//Adding action listener to the write to file button
		writeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Try-catch block
				try {
					writeToFile();
				} 
				catch (Exception e1) {
					//do nothing
				}
			}
		});

		panel1.setLayout(new GridLayout(4, 2));
		panel1.setBorder(BorderFactory.createTitledBorder("Add, list, delete or modify objects"));
		panel1.add(lbl1); //adding the label to the panel
		panel1.add(menuBox); //adding the combo boxes to the panel
		panel1.add(lbl2);
		panel1.add(objectTypeBox);
		panel1.add(new JPanel());
		panel1.add(new JPanel());
		panel1.add(goBtn);//adding the buttons to the panel
		panel1.add(exitBtn);		
		
		panel2.setBorder(BorderFactory.createTitledBorder("More Options"));
		panel2.add(bookBtn);
		panel2.add(writeBtn);
		
		this.add(panel1, BorderLayout.CENTER);	//adding JPanels to the frame
		this.add(panel2, BorderLayout.SOUTH);
		
		UIManager.put("Button.defaultButtonFollowsFocus", Boolean.TRUE);
		
	}
	
	@SuppressWarnings("unused")
	/* Add an object */
	public static void addObject(String objectType) throws EmptyListException {
		
		if(objectType.equals("Flights")) {
			AddFlight flight = new AddFlight();
		}
		else if(objectType.equals("Customers")) {
			AddCustomer customer = new AddCustomer();
		}
		else {//when 'Movies' is selected
			AddMovie movie = new AddMovie();
		}
	}
	
	/* Listing the contents */
	@SuppressWarnings("unused")
	public static void listObjects(String objectType) throws EmptyListException {
		
		if(objectType.equals("Flights")) {
			ListObjects lstFlights = new ListObjects("Flights");	//Creating new JFrame
			
		}
		else if(objectType.equals("Customers")) {
			ListObjects lstCustomers = new ListObjects("Customers");	//Creating new JFrame
			
		}
		else {	//When 'Movies' is selected
			ListObjects lstMovies = new ListObjects("Movies");	//Creating new JFrame
		}
		
	}
	
	/* Delete object */
	@SuppressWarnings("unused")
	public static void deleteObject(String objectType) throws EmptyListException {
		
		if(objectType.equals("Flights")) {
			DeleteFlight delFlight = new DeleteFlight();
		}
		else if(objectType.equals("Customers")) {
			DeleteCustomer delCustomer = new DeleteCustomer();
		}
		else {//when 'Movies' is selected
			DeleteMovie delMovie = new DeleteMovie();
		}
	}
	
	/* Modify object */
	@SuppressWarnings("unused")
	public static void modifyObject(String objectType) throws EmptyListException {
		
		if(objectType.equals("Flights")) {
			ListAndModifyFlight modFlight = new ListAndModifyFlight();	//Display flight table
		}
		else if(objectType.equals("Customers")) {
			ListAndModifyCustomer modCust = new ListAndModifyCustomer();	//Display customer table
		}
		else {//when 'Movies' is selected
			ListAndModifyMovie modMov = new ListAndModifyMovie();	//Display movie table
		}
	}
	
	/* Book a flight */
	public static void bookFlight() throws EmptyListException {
		
		//Open a new frame 
		new BookFlight();
	}
	
	/* Read and load contents from a file */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void readFromFile() throws Exception {

		//Check if file exists
		if(!fileLocation.exists()) {
			//create new file
			fileLocation.createNewFile();
			
		}
		else {
			//Create new input stream object
			objInStream = new ObjectInputStream(new FileInputStream(fileLocation));

			Object objList;
			
			try {
				while((objList = objInStream.readObject()) != null) {

					//Check if objList is of type 'List'
					if(objList instanceof List) {
						ListIterator iter = ((List) objList).listIterator();
						
						while(iter.hasNext()) {
							Object obj = iter.next();
							
							if(obj instanceof Customer) 
								//Set new customer list
								agent.setCustomerList((List<Customer>) objList);
							
							else if(obj instanceof Flight)
								//Set new flight list
								agent.setFlightList((List<Flight>) objList);
							
						}
					}
				}
			}
			catch(EOFException e) {
				//do nothing since we expect it
			}
			
			objInStream.close();	//Closing the stream
		}
	}
	
	/* Write to file */
	public static void writeToFile() throws Exception {
		
		//Create new output stream 
		objOutStream = new ObjectOutputStream(new FileOutputStream(fileLocation));
		
		//Writing objects to file
		objOutStream.writeObject(agent.getCustomerList());
		objOutStream.writeObject(agent.getFlightList());
		
		objOutStream.close();	//Closing the stream
		
		JOptionPane.showMessageDialog(null, "Contents written to file.");
	}
	
	/* Correct the index of the new customer and flight IDs */
	public static void correctCustomerAndFlightIDs() {
		int custID = 0;
		int fltNum = 0;
		
		//Fetching the customer and flight lists
		List<Customer> cList = agent.getCustomerList();
		List<Flight> fList = agent.getFlightList();
		
		//Check if the customer list is empty
		if(!cList.isEmpty()) {
			for(Customer c: cList)
				if(c.getID() >= custID)
					custID = c.getID();
		}
		
		//Check if the flight list is empty
		if(!fList.isEmpty()) {
			for(Flight f: fList)
				if(f.getFlightNum() >= fltNum)
					fltNum = f.getFlightNum();
		}
		
		//Setting the new values of the IDs
		Customer.lastID = custID;
		Flight.lastFlightNum = fltNum;
	}
	
	/* Main method */
	public static void main(String[] args) {
		
		try {
			//Read from file when the program starts
			readFromFile();
		}
		catch(Exception e) {
			//do nothing
		}		
		
		//Setting customer and flight IDs to correct value before the objects are created
		correctCustomerAndFlightIDs();
		
		TravelGUI travel = new TravelGUI();
		travel.setVisible(true);
		travel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		travel.pack();
		travel.setLocation(400, 200);
		travel.setResizable(false);
	}
	
}


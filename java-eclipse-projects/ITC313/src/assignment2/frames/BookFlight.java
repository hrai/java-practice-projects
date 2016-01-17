package assignment2.frames;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import assignment2.*;

public class BookFlight extends JFrame {
	
	private JPanel flightPanel;
	private JPanel customerPanel;
	private ArrayList<JTable> flightTables;
	private JTable fTable1;
	private JTable fTable2;
	private JTable customerTable;
	private JButton bookBtn;
	private JButton cancelBtn;
	private JPanel panel;
	private JPanel subPanel;
	
	public BookFlight() throws EmptyListException {

		//Setting the title 
		super("Book Flight");
		
		flightPanel = new TablesPanel("Flights");
		customerPanel = new TablesPanel("Customers");
		flightTables = ((TablesPanel) flightPanel).getTableList();
		fTable1 = flightTables.get(0);
		fTable2 = flightTables.get(1);
		customerTable = ((TablesPanel) customerPanel).getTable();
		bookBtn = new JButton("BOOK");
		cancelBtn = new JButton("CANCEL");
		panel = new JPanel(new BorderLayout());
		subPanel = new JPanel(new FlowLayout());
		
		panel.add(flightPanel, BorderLayout.NORTH);
		panel.add(customerPanel, BorderLayout.CENTER);
		subPanel.add(bookBtn);
		subPanel.add(cancelBtn);
		panel.add(subPanel, BorderLayout.SOUTH);
		
		//Adding listener to the book button
		bookBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((fTable1.getSelectedRow() == -1 && fTable2.getSelectedRow() == -1) || customerTable.getSelectedRow() == -1) {
					//Error message if either customer or flight isn't selected
					JOptionPane.showMessageDialog(null, "Please select only 1 customer and 1 flight from the given table.", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else {
					Customer customer = null;
					Flight flight = null;
					double cost = 0;
					JTable selectedTable;
					
					//Assigning the value of 'selectedTable'
					if(fTable1.getSelectedRow() != -1)
						selectedTable = fTable1;
					else 
						selectedTable = fTable2;
					
					//Getting the selected item's ID
					int custID = Integer.parseInt((String) customerTable.getModel().getValueAt(customerTable.getSelectedRow(), 0));
					int flightID = Integer.parseInt((String) selectedTable.getModel().getValueAt(selectedTable.getSelectedRow(), 0));
					
					//Getting the customer with matching customer ID
					for(Customer cust: TravelGUI.agent.getCustomerList()) {
						if(cust.getID() == custID) {
							customer = cust;
						}		
					}
					
					//Getting the flight with matching flight ID
					for(Flight flt: TravelGUI.agent.getFlightList()) {
						if(flt.getFlightNum() == flightID) {
							flight = flt;
						}
					}
					
					//Booking the flight for the selected customer
					cost = flight.book(customer);
					
					//Showing message dialogue
					JOptionPane.showMessageDialog(null, "Flight with flight number " + flight.getFlightNum() + " was booked by customer with customer ID "
							+ customer.getID() + " and booking cost is " + cost + ".");
				
				}
			
			}
		});

		//Adding listener to cancel button
		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		this.add(panel);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.pack();
		this.setLocation(300,150);
		UIManager.put("Button.defaultButtonFollowsFocus", Boolean.TRUE);
	}
	
}

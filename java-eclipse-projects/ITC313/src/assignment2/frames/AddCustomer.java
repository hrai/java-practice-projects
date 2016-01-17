package assignment2.frames;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import assignment2.*;

public class AddCustomer extends JFrame {
	
	private JLabel givenNameLbl;
	private JLabel familyNameLbl;
	private JLabel childSeatsLbl;
	private JLabel adultSeatsLbl;
	private JTextField givenNameTxt;
	private JTextField familyNameTxt;
	private JTextField childSeatsTxt;
	private JTextField adultSeatsTxt;
	private JButton okBtn;
	private JButton cancelBtn;
	private JPanel panel;
	
	/* Constructor */
	public AddCustomer() {

		//Setting the title 
		super("Add Customer Details");
		
		givenNameLbl = new JLabel("Enter customer's given name: ");
		familyNameLbl = new JLabel("Enter customer's last name: ");
		childSeatsLbl = new JLabel("Enter child seats booked: ");
		adultSeatsLbl = new JLabel("Enter adult seats booked: ");
		givenNameTxt = new JTextField();
		familyNameTxt = new JTextField();
		childSeatsTxt = new JTextField();
		adultSeatsTxt = new JTextField();
		okBtn = new JButton("OK");
		cancelBtn = new JButton("CANCEL");
		panel = new JPanel();
		
		//Adding action listener to ok button
		okBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String givenName = givenNameTxt.getText().trim();
				String familyName = familyNameTxt.getText().trim();
				String childSeats = childSeatsTxt.getText().trim();
				String adultSeats = adultSeatsTxt.getText().trim();
				String errMsg = "";
				boolean createCustomer = true;
				
				
				if(givenName.isEmpty()) {
					errMsg += "givenName, ";
					createCustomer = false;
				}

				if(familyName.isEmpty()) {
					errMsg += "familyName, ";
					createCustomer = false;
				}

				if(childSeats.isEmpty()) {
					errMsg += "childSeats, ";
					createCustomer = false;
				}

				if(adultSeats.isEmpty()) {
					errMsg += "adultSeats, ";
					createCustomer = false;
				}
				
				try {
					if(createCustomer) {
						//Creating new customer object
						Customer customer = new Customer(givenName, familyName, 
								Integer.parseInt(childSeats), Integer.parseInt(adultSeats));
						TravelGUI.agent.addCustomer(customer);//adding customer to the list of customers
						
						dispose();	//close the frame
						
						//Confirm a creation of new message
						JOptionPane.showMessageDialog(null, "A customer was successfully created.");	
						
					}
					else 
						//show error message
						JOptionPane.showMessageDialog(null, "Please enter " + errMsg + " fields.", "Missing customer fields", JOptionPane.ERROR_MESSAGE);
						
				}
				catch(NumberFormatException e1) {
					//Show error message
					JOptionPane.showMessageDialog(null, "Please enter correct input.", "Wrong Input", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		//Adding action listener to cancel button
		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();	//close the frame
			}
		});
		
		//Add contents to the panel
		panel.setLayout(new GridLayout(5,3));
		panel.add(givenNameLbl);
		panel.add(givenNameTxt);
		panel.add(adultSeatsLbl);
		panel.add(adultSeatsTxt);
		panel.add(familyNameLbl);
		panel.add(familyNameTxt);
		panel.add(childSeatsLbl);
		panel.add(childSeatsTxt);
		panel.add(adultSeatsLbl);
		panel.add(adultSeatsTxt);
		panel.add(okBtn);
		panel.add(cancelBtn);
		
		this.add(panel);	//adding panel to the frame
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.pack();
		this.setVisible(true);
		this.setLocation(600, 300);
		UIManager.put("Button.defaultButtonFollowsFocus", Boolean.TRUE);
	}

}

package assignment2.frames;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import assignment2.*;

public class ModifyCustomer extends JFrame implements Serializable {

	private JCheckBox givenNameBox;
	private JCheckBox familyNameBox;
	private JCheckBox childSeatsBox;
	private JCheckBox adultSeatsBox;
	private JTextField givenNameTxt;
	private JTextField familyNameTxt;
	private JTextField childSeatsTxt;
	private JTextField adultSeatsTxt;
	private JButton okBtn;
	private JButton cancelBtn;
	private JPanel panel;
	private JPanel panel1;
	private JPanel panel2;
	private boolean edited;
	
	public ModifyCustomer(final Customer customer) {

		//Setting the title 
		super("Modify Customer");
		
		givenNameBox = new JCheckBox("Edit given name of customer: ");
		givenNameTxt = new JTextField(customer.getGivenName());
		familyNameBox = new JCheckBox("Edit family name of customer: ");
		familyNameTxt = new JTextField(customer.getFamilyName());
		childSeatsBox = new JCheckBox("Edit number of child seats: ");
		childSeatsTxt = new JTextField(Integer.toString(customer.getChildSeats()));
		adultSeatsBox = new JCheckBox("Edit number of adult seats: ");
		adultSeatsTxt = new JTextField(Integer.toString(customer.getAdultSeats()));
		okBtn = new JButton("OK");
		cancelBtn = new JButton("CANCEL");
		panel = new JPanel(new GridLayout(1,2));
		panel1 = new JPanel(new GridLayout(5,1));
		panel2 = new JPanel(new GridLayout(5,1));
		
		//Disabling the check boxes
		givenNameTxt.setEditable(false);
		familyNameTxt.setEditable(false);
		childSeatsTxt.setEditable(false);
		adultSeatsTxt.setEditable(false);
		
		//Adding listeners to the check boxes
		addListenersToBoxes();
		
		//Adding listener to OK button
		okBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					if(!givenNameTxt.getText().trim().isEmpty()) {
						//Set new given name
						customer.setGivenName(givenNameTxt.getText().trim());
						edited = true;
					}
					
					if(!familyNameTxt.getText().trim().isEmpty()) {
						//Set new family name
						customer.setFamilyName(familyNameTxt.getText().trim());
						edited = true;
					}
					
					if(!childSeatsTxt.getText().trim().isEmpty()) {
						//Set new child seats
						customer.setChildSeats(Integer.parseInt(childSeatsTxt.getText().trim()));
						edited = true;
					}
					
					if(!adultSeatsTxt.getText().trim().isEmpty()) {
						//Set new adult seats
						customer.setAdultSeats(Integer.parseInt(adultSeatsTxt.getText().trim()));
						edited = true;
					}
					
					//Check if the customer object has been changed
					if(edited)
						JOptionPane.showMessageDialog(null, "Changes to customer object successful.");
					
					dispose();	//Close the frame
				}
				catch(NumberFormatException e1) {
					//Showing error message
					JOptionPane.showMessageDialog(null, "Please enter correct input.", "Wrong Input", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		//Adding listener to cancel button
		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose(); 	//Close the frame/window
			}
		});
		
		//Adding components to the panel
		panel1.add(givenNameBox);
		panel1.add(familyNameBox);
		panel1.add(childSeatsBox);
		panel1.add(adultSeatsBox);
		
		panel2.add(givenNameTxt);
		panel2.add(familyNameTxt);
		panel2.add(childSeatsTxt);
		panel2.add(adultSeatsTxt);
		
		panel1.add(okBtn);
		panel2.add(cancelBtn);
		
		panel.add(panel1);
		panel.add(panel2);
		
		this.add(panel);	//adding panel to the frame
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.pack();
		this.setVisible(true);
		this.setLocation(600, 300);
		UIManager.put("Button.defaultButtonFollowsFocus", Boolean.TRUE);
	}
	
	/* Add listeners to the check boxes */
	public void addListenersToBoxes() {
		
		givenNameBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(givenNameBox.isSelected())
					givenNameTxt.setEditable(true);
				else
					givenNameTxt.setEditable(false);
			}
		});
		
		familyNameBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(familyNameBox.isSelected())
					familyNameTxt.setEditable(true);
				else 
					familyNameTxt.setEditable(false);
			}
		});
		
		childSeatsBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(childSeatsBox.isSelected())
					childSeatsTxt.setEditable(true);
				else
					childSeatsTxt.setEditable(false);
			}
		});
		
		adultSeatsBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(adultSeatsBox.isSelected())
					adultSeatsTxt.setEditable(true);
				else
					adultSeatsTxt.setEditable(false);
			}
		});
		
	}
	
}

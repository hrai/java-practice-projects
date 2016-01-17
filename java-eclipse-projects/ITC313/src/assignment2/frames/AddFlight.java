package assignment2.frames;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.util.Date;
import assignment2.*;

public class AddFlight extends JFrame {
	
	private JLabel flightTypeLbl;
	private JLabel originLbl;
	private JLabel destinationLbl;
	private JLabel dateLbl;
	private JLabel etdLbl;
	private JLabel etaLbl;
	private JLabel basePriceLbl;
	private JLabel concessionLbl;
	private JLabel groupDiscountLbl;
	private JLabel rateLbl;
	private JTextField originTxt;
	private JTextField destinationTxt;
	private JTextField dateTxt;
	private JTextField etdTxt;
	private JTextField etaTxt;
	private JTextField basePriceTxt;
	private JTextField concessionTxt;
	private JTextField groupDiscountTxt;
	private JTextField rateTxt;
	private JComboBox<String> flightTypeBox;
	private JButton okBtn;
	private JButton cancelBtn;
	private JPanel panel;
	
	/* No argument constructor */
	public AddFlight() {

		//Setting the title 
		super("Add Flight Details");
		
		flightTypeLbl = new JLabel("Choose flight type: ");
		originLbl = new JLabel("Enter origin of flight: ");
		destinationLbl = new JLabel("Enter destination of flight: ");
		dateLbl = new JLabel("Enter date of flight (dd/mm/yyyy): ");
		etdLbl = new JLabel("Enter estimated time of departure: ");
		etaLbl = new JLabel("Enter estimated time of arrival: ");
		basePriceLbl = new JLabel("Enter base price of the flight: ");
		concessionLbl = new JLabel("Enter concession provided on the flight: ");
		groupDiscountLbl = new JLabel("Enter group discount offered by the flight: ");
		rateLbl = new JLabel("Enter rate of the flight: ");
		originTxt = new JTextField();
		destinationTxt = new JTextField();
		dateTxt = new JTextField();
		etdTxt = new JTextField();
		etaTxt = new JTextField();
		basePriceTxt = new JTextField();
		concessionTxt = new JTextField();
		groupDiscountTxt = new JTextField();
		rateTxt = new JTextField();
		okBtn = new JButton("OK");
		cancelBtn = new JButton("CANCEL");
		panel = new JPanel(new GridLayout(11,2));
		
		//Disabling the components
		groupDiscountLbl.setEnabled(false);
		groupDiscountTxt.setEnabled(false);
		rateLbl.setEnabled(false);
		rateTxt.setEnabled(false);
		okBtn.setEnabled(false);	
		
		String[] flightOptions = {"Select...", "Economy Flight", "Business Flight"};
		flightTypeBox = new JComboBox<String>(flightOptions); //Creating a combo box
		
		
		//Adding listener to combo box
		flightTypeBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				int index = flightTypeBox.getSelectedIndex();	//Getting index of the selected item
				
				if(index == 1) {	//If economy flight is selected
					
					//Enabling the swing components
					groupDiscountLbl.setEnabled(true);
					groupDiscountTxt.setEnabled(true);
					okBtn.setEnabled(true);	
					
					//Disabling the components
					rateLbl.setEnabled(false);
					rateTxt.setText(null);
					rateTxt.setEnabled(false);
				}
				
				else if(index == 2) {	//If business flight is selected
					
					//Enabling the swing components
					rateLbl.setEnabled(true);
					rateTxt.setEnabled(true);
					okBtn.setEnabled(true);	
					
					//Disabling the components
					groupDiscountLbl.setEnabled(false);
					groupDiscountTxt.setText(null);
					groupDiscountTxt.setEnabled(false);
				}
				
				else {//If no option is selected
					
					//Disabling the components
					groupDiscountLbl.setEnabled(false);
					groupDiscountTxt.setEnabled(false);
					rateLbl.setEnabled(false);
					rateTxt.setEnabled(false);
					okBtn.setEnabled(false);
				}
			}
		});
		
		//Adding listener to ok button
		okBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Flight flight;
				String selectedOption = (String) flightTypeBox.getSelectedItem();	//Getting user-selected option
				String origin = originTxt.getText().trim();
				String destination = destinationTxt.getText().trim();
				String date = dateTxt.getText().trim();
				String etd = etdTxt.getText().trim();
				String eta = etaTxt.getText().trim();
				String basePrice = basePriceTxt.getText().trim();
				String concession = concessionTxt.getText().trim();
				String groupDiscount = groupDiscountTxt.getText().trim();
				String rate = rateTxt.getText().trim();
				String errMsg = "";
				boolean createFlight = true;

				if(selectedOption.equals("Economy Flight")) {
					
					if(origin.isEmpty()) {
						errMsg += "origin, ";
						createFlight = false;
					}
					
					if(destination.isEmpty()) {
						errMsg += "destination, ";
						createFlight = false;
					}

					if(date.isEmpty()) {
						errMsg += "date, ";
						createFlight = false;
					}

					if(etd.isEmpty()) {
						errMsg += "etd, ";
						createFlight = false;
					}

					if(eta.isEmpty()) {
						errMsg += "eta, ";
						createFlight = false;
					}

					if(basePrice.isEmpty()) {
						errMsg += "basePrice, ";
						createFlight = false;
					}

					if(concession.isEmpty()) {
						errMsg += "concession, ";
						createFlight = false;
					}

					if(groupDiscount.isEmpty()) {
						errMsg += "groupDiscount, ";
						createFlight = false;
					}
					
					try {
						//Create flight only if all the attributes are provided
						if(createFlight) {
							
							//Creating new economy flight 
							flight = new EconomyFlight(origin, destination, stringToDate(date),
									Integer.parseInt(etd), Integer.parseInt(eta), Double.parseDouble(basePrice), 
									Double.parseDouble(concession), Double.parseDouble(groupDiscount));
							
							//Adding economy flight object to the flight list
							TravelGUI.agent.addFlight(flight);	
							dispose();	//Close the frame
							
							//Confirm a creation of new message
							JOptionPane.showMessageDialog(null, "A flight was successfully created.");	
														
						}
						else 
							//show error message
							JOptionPane.showMessageDialog(null, "Please provide " + errMsg + " fields.", "Missing economy flight fields", JOptionPane.ERROR_MESSAGE);
					
					}
					catch(NumberFormatException e1) {
						//Showing error message
						JOptionPane.showMessageDialog(null, "Please enter correct input.", "Wrong Input", JOptionPane.ERROR_MESSAGE);
					}
				}
				
				else if(selectedOption.equals("Business Flight")) {

					if(origin.isEmpty()) {
						errMsg += "origin, ";
						createFlight = false;
					}

					if(destination.isEmpty()) {
						errMsg += "destination, ";
						createFlight = false;
					}

					if(date.isEmpty()) {
						errMsg += "date, ";
						createFlight = false;
					}

					if(etd.isEmpty()) {
						errMsg += "etd, ";
						createFlight = false;
					}

					if(eta.isEmpty()) {
						errMsg += "eta, ";
						createFlight = false;
					}

					if(basePrice.isEmpty()) {
						errMsg += "basePrice, ";
						createFlight = false;
					}

					if(concession.isEmpty()) {
						errMsg += "concession, ";
						createFlight = false;
					}

					if(rate.isEmpty()) {
						errMsg += "rate, ";
						createFlight = false;
					}
					
					try {
						//Create flight only if all the attributes are provided
						if(createFlight) {
							//Creating new business flight 
							flight = new BusinessFlight(origin, destination, stringToDate(date),
									Integer.parseInt(etd), Integer.parseInt(eta), Double.parseDouble(basePrice), 
									Double.parseDouble(concession), Double.parseDouble(rate));
							
							TravelGUI.agent.addFlight(flight);	//Adding business flight object to the flight list
							dispose();	//Close the frame
							
							//Confirm a creation of new message
							JOptionPane.showMessageDialog(null, "A flight was successfully created.");	
							
						}
						else 
							//show error message
							JOptionPane.showMessageDialog(null, "Please provide " + errMsg + " fields.", "Missing business flight fields", JOptionPane.ERROR_MESSAGE);
						
					}
					catch(NumberFormatException e3) {
						JOptionPane.showMessageDialog(null, "Please enter correct input.", "Wrong Input", JOptionPane.ERROR_MESSAGE);
					}
				}
				
			}
		});
		
		//Adding listener to cancel button
		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();	//Close the frame
			}
		});
		
		//Adding the components to panel
		panel.add(flightTypeLbl);
		panel.add(flightTypeBox);
		panel.add(originLbl);
		panel.add(originTxt);
		panel.add(destinationLbl);
		panel.add(destinationTxt);
		panel.add(dateLbl);
		panel.add(dateTxt);
		panel.add(etdLbl);
		panel.add(etdTxt);
		panel.add(etaLbl);
		panel.add(etaTxt);
		panel.add(basePriceLbl);
		panel.add(basePriceTxt);
		panel.add(concessionLbl);
		panel.add(concessionTxt);
		panel.add(groupDiscountLbl);
		panel.add(groupDiscountTxt);
		panel.add(rateLbl);
		panel.add(rateTxt);
		panel.add(okBtn);
		panel.add(cancelBtn);
		
		this.add(panel);	//Adding panel to the frame
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.pack();
		this.setLocation(600, 300);
		UIManager.put("Button.defaultButtonFollowsFocus", Boolean.TRUE);
	}
	
	/* Convert String to Date */
	public static Date stringToDate(String date) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date d = null;
		
		try {
			if(date == null)
				return d;
			else
				d = sdf.parse(date);//parsing the date
		} 
		catch (ParseException e) {
			//Do nothing
		}
		
		return d;
	}
}

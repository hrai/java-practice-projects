package assignment2.frames;

import javax.swing.*;

import assignment2.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.*;

public class ModifyFlight extends JFrame implements Serializable {

	private JCheckBox originBox;
	private JCheckBox destinationBox;
	private JCheckBox dateBox;
	private JCheckBox etdBox;
	private JCheckBox etaBox;
	private JCheckBox basePriceBox;
	private JCheckBox concessionBox;
	private JCheckBox groupDiscountBox;
	private JCheckBox rateBox;
	private JTextField originTxt;
	private JTextField destinationTxt;
	private JTextField dateTxt;
	private JTextField etdTxt;
	private JTextField etaTxt;
	private JTextField basePriceTxt;
	private JTextField concessionTxt;
	private JTextField groupDiscountTxt;
	private JTextField rateTxt;
	private JButton okBtn;
	private JButton cancelBtn;
	private JPanel panel;
	private JPanel panel1;
	private JPanel panel2;
	private boolean edited;
	
	public ModifyFlight(final Flight flight) {

		//Setting the title 
		super("Modify Flight");
		
		//Creating new component objects
		originBox = new JCheckBox("Edit origin of flight: ");
		originTxt = new JTextField(flight.getOrigin());
		destinationBox = new JCheckBox("Edit destination of flight: ");
		destinationTxt = new JTextField(flight.getDestination());
		dateBox = new JCheckBox("Edit date of flight: ");
		dateTxt = new JTextField(flight.getDate().toString());
		etdBox = new JCheckBox("Edit estimated time of arrival: ");
		etdTxt = new JTextField(Integer.toString(flight.getEtd()));
		etaBox = new JCheckBox("Edit estimated time of departure: ");
		etaTxt = new JTextField(Integer.toString(flight.getEta()));
		basePriceBox = new JCheckBox("Edit base price: ");
		basePriceTxt = new JTextField(Double.toString(flight.getBasePrice()));
		concessionBox = new JCheckBox("Edit concession: ");
		concessionTxt = new JTextField(Double.toString(flight.getConcession()));
		groupDiscountBox = new JCheckBox("Edit group discount: ");
		rateBox = new JCheckBox("Edit rate: ");
		
		if(flight instanceof EconomyFlight) {
			groupDiscountTxt = new JTextField(Double.toString(((EconomyFlight) flight).getGroupDiscount()));
			groupDiscountTxt.setEditable(false);
			
		}
		if(flight instanceof BusinessFlight) {
			rateTxt = new JTextField(Double.toString(((BusinessFlight) flight).getRate()));
		rateTxt.setEditable(false);
			
		}
		
		okBtn = new JButton("OK");
		cancelBtn = new JButton("CANCEL");
		panel = new JPanel(new GridLayout(1,2));
		panel1 = new JPanel(new GridLayout(10,1));
		panel2 = new JPanel(new GridLayout(10,1));
		
		//Disabling the check boxes
		originTxt.setEditable(false);
		destinationTxt.setEditable(false);
		dateTxt.setEditable(false);
		etdTxt.setEditable(false);
		etaTxt.setEditable(false);
		basePriceTxt.setEditable(false);
		concessionTxt.setEditable(false);
		
		//Adding listeners to the check boxes
		addListenersToBoxes();
		
		//Adding listener to OK button
		okBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					if(!originTxt.getText().trim().isEmpty()) {
						//Set new origin
						flight.setOrigin(originTxt.getText().trim());
						edited = true;
					}
					
					if(!destinationTxt.getText().trim().isEmpty()) {
						//Set new destination
						flight.setDestination(destinationTxt.getText().trim());
						edited = true;
					}
					if(!dateTxt.getText().trim().isEmpty()) {
						//Set new date
						SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy");
						try {
							flight.setDate(sdf.parse(dateTxt.getText().trim()));
						} catch (ParseException e1) {
							//do nothing
						}
						edited = true;
					}
					
					if(!etdTxt.getText().trim().isEmpty()) {
						//Set new etd
						flight.setEtd(Integer.parseInt(etdTxt.getText().trim()));
						edited = true;
					}
					
					if(!etaTxt.getText().trim().isEmpty()) {
						//Set new eta
						flight.setEta(Integer.parseInt(etaTxt.getText().trim()));
						edited = true;
					}
					
					if(!basePriceTxt.getText().trim().isEmpty()) {
						//Set new base price
						flight.setBasePrice(Double.parseDouble(basePriceTxt.getText().trim()));
						edited = true;
					}
					
					if(flight instanceof EconomyFlight) {
						if(!groupDiscountTxt.getText().trim().isEmpty()) {
							//Set new group discount
							((EconomyFlight) flight).setGroupDiscount(Double.parseDouble(groupDiscountTxt.getText().trim()));
							edited = true;
						}
					}
					
					if(flight instanceof BusinessFlight) {
						if(!rateTxt.getText().trim().isEmpty()) {
							//Set new rate
							((BusinessFlight) flight).setRate(Double.parseDouble(rateTxt.getText().trim()));
							edited = true;
						}					
					}
					
					//Check if the customer object has been changed
					if(edited)
						JOptionPane.showMessageDialog(null, "Changes to flight object successful.");
					
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
		panel1.add(originBox);
		panel1.add(destinationBox);
		panel1.add(dateBox);
		panel1.add(etdBox);
		panel1.add(etaBox);
		panel1.add(basePriceBox);
		panel1.add(concessionBox);
		
		panel2.add(originTxt);
		panel2.add(destinationTxt);
		panel2.add(dateTxt);
		panel2.add(etdTxt);
		panel2.add(etaTxt);
		panel2.add(basePriceTxt);
		panel2.add(concessionTxt);
		
		//Check which items to add to the panel
		if(groupDiscountTxt == null) {
			panel1.add(rateBox);
			panel2.add(rateTxt);
		}
		else if(rateTxt == null) {
			panel1.add(groupDiscountBox);
			panel2.add(groupDiscountTxt);
		}
		
		panel1.add(okBtn);
		panel2.add(cancelBtn);
		
		//Add panels to the main panel
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
		
		originBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(originBox.isSelected())
					originTxt.setEditable(true);
				else
					originTxt.setEditable(false);
			}
		});
		
		destinationBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(destinationBox.isSelected())
					destinationTxt.setEditable(true);
				else 
					destinationTxt.setEditable(false);
			}
		});
		
		dateBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(dateBox.isSelected())
					dateTxt.setEditable(true);
				else
					dateTxt.setEditable(false);
			}
		});
		
		etdBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(etdBox.isSelected())
					etdTxt.setEditable(true);
				else
					etdTxt.setEditable(false);
			}
		});
		
		etaBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(etaBox.isSelected())
					etaTxt.setEditable(true);
				else
					etaTxt.setEditable(false);
			}
		});
		
		basePriceBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(basePriceBox.isSelected())
					basePriceTxt.setEditable(true);
				else
					basePriceTxt.setEditable(false);
			}
		});
		
		concessionBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(concessionBox.isSelected())
					concessionTxt.setEditable(true);
				else
					concessionTxt.setEditable(false);
			}
		});
		
		groupDiscountBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(groupDiscountBox.isSelected())
					groupDiscountTxt.setEditable(true);
				else
					groupDiscountTxt.setEditable(false);
			}
		});
		
		rateBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(rateBox.isSelected())
					rateTxt.setEditable(true);
				else
					rateTxt.setEditable(false);
			}
		});
	}
	
}

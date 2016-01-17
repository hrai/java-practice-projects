package assignment2.frames;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import assignment2.*;

public class AddMovieDetails extends JFrame {

	private JLabel nameLbl;
	private JLabel lenLbl;
	private JTextField nameTxt;
	private JTextField lenTxt;
	private JButton okBtn;
	private JButton cancelBtn;
	private JPanel panel;
	
	public AddMovieDetails(final JTable flightTable) {

		//Setting the title 
		super("Add Movie Details");
		
		//Creating swing elements
		nameLbl = new JLabel("Enter name of movie: ");
		lenLbl = new JLabel("Enter length of movie: ");
		nameTxt = new JTextField();
		lenTxt = new JTextField();
		okBtn = new JButton("OK");
		cancelBtn = new JButton("CANCEL");
		panel = new JPanel();
	
		//Add listener to ok button
		okBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						
				String movieName = nameTxt.getText().trim();
				String movieLength = lenTxt.getText().trim();
				String errMsg = "";
				boolean createMovie = true;
				
				if(flightTable.getSelectedRow() == -1) {
					//Error message if either customer or flight isn't selected
					JOptionPane.showMessageDialog(null, "Please select a flight from the given table.", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else {
					if(movieName.isEmpty()) {
						errMsg += "movie name, ";
						createMovie = false;
					}
					if(movieLength.isEmpty()) {
						errMsg += "movie length, ";
						createMovie = false;
					}
					
					try {

						if(createMovie) {
							
							for(Flight f: TravelGUI.agent.getFlightList()) {
								//Checking if the flight number is valid
								if(f.getFlightNum() == Integer.parseInt((String) flightTable.getModel().getValueAt(flightTable.getSelectedRow(), 0))) {
									//Creating and adding new movie to the flight and checking if the movie was added to the flight
									Movie newMovie = new Movie(movieName, Integer.parseInt(movieLength));
									
									if(!f.addMovie(newMovie).isEmpty()) {
										//Confirm a creation of new message
										JOptionPane.showMessageDialog(null, "A movie was successfully created.");	
										dispose();	//close the frame
										
										//Break out of while-loop
										break;
										
									}					
								}
							}
						}
						else
							//Show error message
							JOptionPane.showMessageDialog(null, "Please enter " + errMsg + " fields.", "Missing movie field", JOptionPane.ERROR_MESSAGE);
					
					}
					catch(NumberFormatException e1) {
						//Showing error message
						JOptionPane.showMessageDialog(null, "Please enter correct input.", "Wrong Input", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		
		//Add listener to cancel button
		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();//closing the frame
			}
		});
		
		//Adding elements to the panel
		panel.setLayout(new GridLayout(3,3));
		panel.add(nameLbl);
		panel.add(nameTxt);
		panel.add(lenLbl);
		panel.add(lenTxt);
		panel.add(okBtn);
		panel.add(cancelBtn);

		this.add(panel, BorderLayout.CENTER);
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.pack();
		this.setLocation(600, 300);
		UIManager.put("Button.defaultButtonFollowsFocus", Boolean.TRUE);
		
	}
}

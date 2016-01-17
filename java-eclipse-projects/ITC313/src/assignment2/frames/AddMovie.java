package assignment2.frames;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddMovie extends JFrame {

	private JPanel panel;
	private JPanel subPanel;
	private JPanel flightPanel;
	private JTable flightTable;
	private JButton selectBtn;
	private JButton cancelBtn;
	
	/* Constructor */
	public AddMovie() throws EmptyListException {

		//Setting the title 
		super("Select Flight");
		
		//Creating components 
		panel = new JPanel(new BorderLayout());
		subPanel = new JPanel(new FlowLayout());
		flightPanel = new TablesPanel("Flights");
		flightTable = ((TablesPanel) flightPanel).getTable();
		selectBtn = new JButton("SELECT");
		cancelBtn = new JButton("CANCEL");
		
		selectBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(flightTable.getSelectedRow() == -1) {
					//Show error message if the table item isn't selected
					JOptionPane.showMessageDialog(null, "Please select a flight from the table", "Flight Not Selected", JOptionPane.ERROR_MESSAGE);
				}
				else {
					//Creating a new JFrame object and passing the object on which the action was performed
					new AddMovieDetails(flightTable);
				}
			}
		});
		
		//Add listener to cancel button
		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();//closing the frame
			}
		});

		//Setting size of the panels
		flightPanel.setPreferredSize(new Dimension(500, 200));
		
		panel.add(flightPanel);
		subPanel.add(selectBtn);
		subPanel.add(cancelBtn);
		
		this.add(panel, BorderLayout.CENTER);
		this.add(subPanel, BorderLayout.SOUTH);
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.pack();
		this.setLocation(600, 300);
		UIManager.put("Button.defaultButtonFollowsFocus", Boolean.TRUE);
		
	}
	
}



package assignment2.frames;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import assignment2.*;

public class DeleteFlight extends ListObjects {
	
	private JButton delBtn;
	private JPanel panel;
	private boolean isSelected;
	
	/* Constructor */
	public DeleteFlight() throws EmptyListException {
		//Calling super class constructor
		super("Flights");

		panel = new JPanel();
		delBtn = new JButton("DELETE");
		tables = ((TablesPanel) tablePanel).getTableList();
		isSelected = false;
		
		//Adding button to the panel
		panel.add(delBtn);
		
		//Adding listener to the select button
		delBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Check if at least one item is selected in either tables
				for(JTable table: tables) {
					if(table.getSelectedColumnCount() != 0 || table.getSelectedRowCount() != 0) {
						isSelected = true;
						break;
					}
				}
				
				if(isSelected) {
					//Loop through each table
					index:for(JTable table: tables) {
						if(table.getColumnCount() == 9) {
							if(table.getSelectedRowCount() != 0) {	//Check any item is selected
								for(Flight f: TravelGUI.agent.getFlightList()) {
									if(f.getFlightNum() == Integer.parseInt((String)table.getModel().getValueAt(table.getSelectedRow(), 0))) {
										
										int optionSelected = JOptionPane.showConfirmDialog(null, "Do you really want to delete the flight?", "Confirmation Message", JOptionPane.YES_NO_OPTION);
										
										if(optionSelected == 0) {
											TravelGUI.agent.getFlightList().remove(f);
											JOptionPane.showMessageDialog(null, "The flight was successfully deleted");
										}
										else if(optionSelected == 1) 
											dispose();
										
										//Close the window
										dispose();
										
										break index;
									}
								}
							}
						}
					}
				}
				else 
					JOptionPane.showMessageDialog(null, "Please select a flight.");
				
			}
		});
		
		//Adding panel to the frame
		super.add(panel, BorderLayout.SOUTH);
		this.setTitle("Delete Flight");
		this.setPreferredSize(getPreferredSize());
	}

}

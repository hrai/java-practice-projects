package assignment2.frames;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import assignment2.*;

public class ListAndModifyFlight extends ListObjects {
	private boolean isSelected;
	
	public ListAndModifyFlight() throws EmptyListException {
		//Calling super class constructor
		super("Flights");

		panel = new JPanel();
		modifyBtn = new JButton("MODIFY");
		tables = ((TablesPanel) tablePanel).getTableList();
		isSelected = false;
		
		//Adding button to the panel
		panel.add(modifyBtn);
		
		//Adding listener to the select button
		modifyBtn.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
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
										
										//Display the window which prompts user to enter new flight attributes
										ModifyFlight modFlight = new ModifyFlight(f);
										
										dispose();	//Closing the frame
										
										break index;	//Break out of outer for loop
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
		this.setPreferredSize(getPreferredSize());
		this.setTitle("Modify Flight");
	}
}

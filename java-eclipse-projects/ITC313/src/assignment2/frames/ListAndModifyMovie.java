package assignment2.frames;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import assignment2.*;

public class ListAndModifyMovie extends ListObjects {
	
	public ListAndModifyMovie() throws EmptyListException {
		//Calling super class constructor
		super("Movies");

		panel = new JPanel();
		table = ((TablesPanel) tablePanel).getTable();
		modifyBtn = new JButton("MODIFY");
		
		//Adding button to the panel
		panel.add(modifyBtn);
		
		//Adding listener to the select button
		modifyBtn.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent e) {
				
				if(table.getColumnCount() == 2) {
					//Check if at least one item is selected
					if(table.getSelectedColumnCount() != 0 || table.getSelectedRowCount() != 0) {
						for(Flight f: TravelGUI.agent.getFlightList()) 
							for(Movie m: f.getMovieList()) {
								if(m.getName().trim().equalsIgnoreCase(((String) table.getModel().getValueAt(table.getSelectedRow(), 0)).trim())) {
									
									//Display the window which prompts user to enter new movie attributes
									ModifyMovie modMov = new ModifyMovie(m);
									
									dispose();	//Closing the frame
								}
							}
					}
					else
						JOptionPane.showMessageDialog(null, "Please select a movie.");
				}
				
			}
		});
		
		//Adding panel to the frame
		super.add(panel, BorderLayout.SOUTH);
		this.setPreferredSize(getPreferredSize());
		this.setTitle("Modify Movie");
	}
}

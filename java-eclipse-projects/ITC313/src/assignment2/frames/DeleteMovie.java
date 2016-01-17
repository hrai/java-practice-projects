package assignment2.frames;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import assignment2.*;

public class DeleteMovie extends ListObjects {
	
	private JButton delBtn;
	private JPanel panel;
	
	/* Constructor */
	public DeleteMovie() throws EmptyListException {

		//Calling super class constructor
		super("Movies");

		panel = new JPanel();
		table = ((TablesPanel) tablePanel).getTable();
		delBtn = new JButton("DELETE");
		
		//Adding button to the panel
		panel.add(delBtn);
		
		//Adding listener to the select button
		delBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(table.getColumnCount() == 2) {
					//Check if at least one item is selected
					if(table.getSelectedColumnCount() != 0 || table.getSelectedRowCount() != 0) {
						for(Flight f: TravelGUI.agent.getFlightList()) 
							for(Movie m: f.getMovieList()) {
								if(m.getName().trim().equalsIgnoreCase(((String) table.getModel().getValueAt(table.getSelectedRow(), 0)).trim())) {
									
									int optionSelected = JOptionPane.showConfirmDialog(null, "Do you really want to delete the movie?", "Confirmation Message", JOptionPane.YES_NO_OPTION);
									
									if(optionSelected == 0) {
										f.getMovieList().remove(m);	//Removing the movie
										JOptionPane.showMessageDialog(null, "The movie was successfully deleted");
									}
									else if(optionSelected == 1) 
										dispose();
									
									//Disposing the window
									dispose();
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
		this.setTitle("Delete Movie");
	}

}

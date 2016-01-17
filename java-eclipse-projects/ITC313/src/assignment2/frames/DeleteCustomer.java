package assignment2.frames;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import assignment2.*;

public class DeleteCustomer extends ListObjects {
	
	private JButton delBtn;
	private JPanel panel;
	
	/* Constructor */
	public DeleteCustomer() throws EmptyListException {

		//Calling super class constructor
		super("Customers");
		
		panel = new JPanel();
		table = ((TablesPanel) tablePanel).getTable();
		delBtn = new JButton("DELETE");
		
		//Adding button to the panel
		panel.add(delBtn);
		
		//Adding listener to the select button
		delBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(table.getModel().getColumnCount() == 5) {
					//Check if at least one item is selected
					if(table.getSelectedColumnCount() != 0 || table.getSelectedRowCount() != 0) {
						for(Customer c: TravelGUI.agent.getCustomerList()) {
							if(c.getID() == Integer.parseInt((String) table.getModel().getValueAt(table.getSelectedRow(), 0))) {
								
								int optionSelected = JOptionPane.showConfirmDialog(null, "Do you really want to delete the customer?", "Confirmation Message", JOptionPane.YES_NO_OPTION);
								
								if(optionSelected == 0) {
									TravelGUI.agent.getCustomerList().remove(c);	//Removing the customer
									JOptionPane.showMessageDialog(null, "The customer was successfully deleted.");
								}
								else if(optionSelected == 1) 
									dispose();
								
								//Disposing the window
								dispose();
								
							}
						}
					}
					else
						JOptionPane.showMessageDialog(null, "Please select a customer.");
				}
			}
		});
		
		//Adding panel to the frame
		super.add(panel, BorderLayout.SOUTH);
		this.setPreferredSize(getPreferredSize());
		this.setTitle("Delete Customer");
	}

}


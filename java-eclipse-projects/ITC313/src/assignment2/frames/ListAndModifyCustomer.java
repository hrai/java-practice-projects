package assignment2.frames;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import assignment2.*;

public class ListAndModifyCustomer extends ListObjects {
	
	public ListAndModifyCustomer() throws EmptyListException {
		//Calling super class constructor
		super("Customers");
		
		panel = new JPanel();
		table = ((TablesPanel) tablePanel).getTable();
		modifyBtn = new JButton("MODIFY");
		
		//Adding button to the panel
		panel.add(modifyBtn);
		
		//Adding listener to the select button
		modifyBtn.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent e) {
				
				if(table.getModel().getColumnCount() == 5) {
					//Check if at least one item is selected
					if(table.getSelectedColumnCount() != 0 || table.getSelectedRowCount() != 0) {
						for(Customer c: TravelGUI.agent.getCustomerList()) {
							if(c.getID() == Integer.parseInt((String) table.getModel().getValueAt(table.getSelectedRow(), 0))) {
								
								//Display the window which prompts user to enter new customer attributes
								ModifyCustomer modFlight = new ModifyCustomer(c);
								
								dispose();	//Closing the frame
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
		this.setTitle("Modify Customer");
	}
}

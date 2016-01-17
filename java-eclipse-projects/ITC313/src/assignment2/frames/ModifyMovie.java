package assignment2.frames;

import javax.swing.*;

import assignment2.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class ModifyMovie extends JFrame implements Serializable {

	private JCheckBox nameBox;
	private JCheckBox lengthBox;
	private JTextField nameTxt;
	private JTextField lengthTxt;
	private JButton okBtn;
	private JButton cancelBtn;
	private JPanel panel;
	private JPanel panel1;
	private JPanel panel2;
	private boolean edited;
	
	public ModifyMovie(final Movie movie) {
		
		//Setting the title 
		super("Modify Movie");
		
		nameBox = new JCheckBox("Edit movie name: ");
		nameTxt = new JTextField(movie.getName());
		lengthBox = new JCheckBox("Edit movie length: ");
		lengthTxt = new JTextField(Integer.toString(movie.getLength()));
		okBtn = new JButton("OK");
		cancelBtn = new JButton("CANCEL");
		panel = new JPanel(new GridLayout(1,2));
		panel1 = new JPanel(new GridLayout(3,1));
		panel2 = new JPanel(new GridLayout(3,1));
		
		//Disabling the check boxes
		nameTxt.setEditable(false);
		lengthTxt.setEditable(false);
		
		//Adding listeners to the check boxes
		addListenersToBoxes();
		
		//Adding listener to OK button
		okBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					if(!nameTxt.getText().trim().isEmpty()) {
						//Set new name
						movie.setName(nameTxt.getText().trim());
						edited = true;
					}
					
					if(!lengthTxt.getText().trim().isEmpty()) {
						//Set new length
						movie.setLength(Integer.parseInt(lengthTxt.getText().trim()));
						edited = true;
					}
					
					//Check if the movie object has been changed
					if(edited)
						JOptionPane.showMessageDialog(null, "Changes to movie object successful.");
					
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
		panel1.add(nameBox);
		panel1.add(lengthBox);
		panel1.add(okBtn);

		panel2.add(nameTxt);
		panel2.add(lengthTxt);		
		panel2.add(cancelBtn);
		
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
		
		nameBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(nameBox.isSelected())
					nameTxt.setEditable(true);
				else
					nameTxt.setEditable(false);
			}
		});
		
		lengthBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(lengthBox.isSelected())
					lengthTxt.setEditable(true);
				else 
					lengthTxt.setEditable(false);
			}
		});
		
	}
	
	public static void main(String[] args) {
		new ModifyMovie(new Movie("Me", 2300));
	}
}

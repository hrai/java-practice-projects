package assignment2.frames;

import java.util.*;
import javax.swing.*;

public class ListObjects extends JFrame {
	protected JPanel tablePanel;
	protected JPanel panel;
	protected JButton modifyBtn;
	protected JTable table;
	protected ArrayList<JTable> tables;
	
	public ListObjects(String objType) throws EmptyListException {

		//Setting the title 
		super("List of " + objType);
		
		tablePanel = new TablesPanel(objType);
		
		//Adding the panel to the frame
		this.add(tablePanel);
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLocation(600, 300);
		this.pack();
		UIManager.put("Button.defaultButtonFollowsFocus", Boolean.TRUE);
	}	
}
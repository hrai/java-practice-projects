import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Tut49 extends JFrame {
	
	private JTextField userText;
	private JTextArea chatWindow;
	private ObjectOutputStream output;
	private ObjectInputStream input;
	private String message = "";
	private String serverIP;
	private Socket connection;
	
	//constructor
	public Tut49(String host) {
		super("Client!");
		serverIP = host;
		userText = new JTextField();
		userText.setEditable(false);
		userText.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						sendMessage(e.getActionCommand());
						userText.setText("");
					}
				}
		);
		add(userText, BorderLayout.SOUTH);
		chatWindow = new JTextArea();
		add(new JScrollPane(chatWindow), BorderLayout.CENTER);
		setSize(300, 150);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	//start chat
	public void startRunning() {
		try {
			connectToServer();
			setupStreams();
			whileChatting();
		}
		catch(EOFException ex) {
			showMessage("\n Client terminated connection");	
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		finally {
			closeIM();
		}
	}
	
	//connect to server
	private void connectToServer() throws IOException {
		showMessage("Attempting connection... \n");
		connection = new Socket(InetAddress.getByName(serverIP), 1234);
		showMessage("Connected to: " + connection.getInetAddress().getHostName());
	}
	
	//sets up the streams
	private void setupStreams() throws IOException {
		output = new ObjectOutputStream(connection.getOutputStream());
		output.flush();
		input = new ObjectInputStream(connection.getInputStream());
	}
	
	//during the chat episode
	private void whileChatting() throws IOException {
		ableToType(true);
		do {
			try {
				message = (String) input.readObject();
				showMessage("\n " + message);
			}
			catch(ClassNotFoundException e) {
				showMessage("\n I don't know that objec type! ");
			}
		}
		while(!message.equalsIgnoreCase("SERVER - END"));
	}
	
	//close the streams and sockets
	private void closeIM() {
		showMessage("\n Closing the IM");
		ableToType(false);
		try {
			output.close();
			input.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	//send message to the server
	private void sendMessage(String message) {
		try {
			output.writeObject("CLIENT - " + message);
			output.flush();
			showMessage("\n CLIENT - " + message);
		}
		catch(IOException e) {
			chatWindow.append("\n Something messed up while sending the message");
		}
	}
	
	//show message on the window
	private void showMessage(final String message) {
		SwingUtilities.invokeLater(
				new Runnable() {
					public void run() {
						chatWindow.append(message);
					}
				}
		);
	}
	
	//able to type
	private void ableToType(final boolean msg) {
		SwingUtilities.invokeLater(
				new Runnable() {
					public void run() {
						userText.setEditable(msg);
					}
				}
		);
	}
}









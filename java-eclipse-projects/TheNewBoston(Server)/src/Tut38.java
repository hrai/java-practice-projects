import java.io.*;
import java.net.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Tut38 extends JFrame {
	
	private JTextField userText;
	private JTextArea chatWindow;
	private ObjectOutputStream output;
	private ObjectInputStream input;
	private ServerSocket server;
	private Socket connection;
	
	//constructor
	public Tut38() {
		super("Nick's Instant Messenger");
		userText = new JTextField();
		userText.setEditable(false);
		userText.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent event) {
						sendMessage(event.getActionCommand());
						userText.setText("");
					}
				}
		);
		//add 'userText' to the window
		add(userText, BorderLayout.SOUTH);
		chatWindow = new JTextArea();
		
		//add 'chatWindow' to the window
		add(new JScrollPane(chatWindow), BorderLayout.CENTER);
		
		//set the size of the 'chatWindow'
		setSize(300,150);
		setVisible(true);
	}
	
	//set up and run the server
	public void startRunning() {
		try {
			server = new ServerSocket(1234, 100);
			while(true) {
				try {
					//connect and have conversation
					waitForConnection();
					setupStreams();
					whileChatting();
				}
				catch(EOFException ex) {
					showMessage("\n Server ended the connection!");
				}
				finally {
					closeIM();
				}
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	//wait for connection, then display connection information
	private void waitForConnection() throws IOException {
		showMessage("\n Waiting for someone to connect... \n");
		connection = server.accept();
		showMessage("\n Now connected to " + connection.getInetAddress().getHostName());
		
	}
	
	//get stream to send and receive data
	private void setupStreams() throws IOException {
		output = new ObjectOutputStream(connection.getOutputStream());
		output.flush();
		input = new ObjectInputStream(connection.getInputStream());
		showMessage("\n Streams are now setup! \n");
	}
	
	//during the chat conversation 
	private void whileChatting() throws IOException {
		String message = "You are now connected!\n";
		sendMessage(message);
		ableToType(true);
		do {
			//have a conversation
			try {
				message = (String) input.readObject();
				showMessage("\n" + message);
			}
			catch(ClassNotFoundException e) {
				showMessage("\n The user sent some crap!");
			}
		} while(!message.equalsIgnoreCase("CLIENT - END"));
		
	}
	
	//close streams and sockets after you are done chatting
	private void closeIM() {
		showMessage("\n Closing connections.... ");
		ableToType(false);
		try {
			output.close();
			input.close();
			connection.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	//send message to client
	private void sendMessage(String message) {
		try {
			output.writeObject("SERVER - " + message);
			output.flush();
			showMessage("\n SERVER - " + message);
		}
		catch(IOException e) {
			chatWindow.append("\n ERROR: MESSAGE NOT SENT");
		}
	}
	
	//show message on the chat window
	private void showMessage(final String message) {
		SwingUtilities.invokeLater(
				new Runnable() {
					public void run() {
						chatWindow.append(message);
					}
				}
		);
	}
	
	//
	private void ableToType(final boolean message) {
		SwingUtilities.invokeLater(
				new Runnable() {
					public void run() {
						userText.setEditable(message);
					}
				}
		);
	}
}



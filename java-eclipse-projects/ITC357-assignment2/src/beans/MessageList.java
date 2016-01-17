package beans;

import java.util.*;

public class MessageList {
	
	ArrayList<MessageDetails> messageList;
	
	//No argument constructor
	public MessageList() {
		messageList = new ArrayList<MessageDetails>();
	}
	
	public ArrayList<MessageDetails> getMessageList() {
		return messageList;
	}

	public void addMessageDetails(MessageDetails message) {
		messageList.add(message);
	}
	
}

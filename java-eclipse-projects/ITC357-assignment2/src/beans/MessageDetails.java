package beans;

import java.sql.*;

public class MessageDetails {

	private String senderName;
	private String subject;
	private Date datePosted;
	private String message;
	
	public MessageDetails() {
		datePosted = new Date(new java.util.Date().getTime());
	}
	
	public String getSenderName() {
		return senderName;
	}
	
	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}
	
	public String getSubject() {
		return subject;
	}
	
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public Date getDatePosted() {
		return datePosted;
	}
	
	public void setDatePosted(Date datePosted) {
		this.datePosted = datePosted;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
}

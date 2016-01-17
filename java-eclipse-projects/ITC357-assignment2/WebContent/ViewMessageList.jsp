<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import = "beans.MessageList, beans.MessageDetails, java.sql.Date" %>
<%
	MessageList list = (MessageList) session.getAttribute("list");	
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Message List</title>
<link rel = "stylesheet" href = "css/mystyle.css" type = "text/css">
</head>
<body>
	
	<div id = "wrapper">
		<div id = "content" align = "center">
			
			<form action = "ViewMessageList" method = "POST" > 
				<div align = right>
					<input type = text name = searchTxt id = searchTxt>
					<input type = submit name = search value = "SEARCH">
				</div>
				<h3>Message List</h3>
			
				<table border = 1 bordercolor = gray>
					<tr class = "heading">
						<td><b>Select </b></td>
						<td><b><a href = "ViewMessageList?sortBy=senderName"> Sender Name </a></b></td>
						<td><b><a href = "ViewMessageList?sortBy=subject"> Message Subject </a></b></td>
						<td><b><a href = "ViewMessageList?sortBy=datePosted"> Date Posted </a></b></td>
					</tr>
					<%if(list != null) { 
						int selectedOption = 1;
						
						//for-loop to list the message details
						for(MessageDetails mDetails: list.getMessageList()) {
							String senderName = mDetails.getSenderName();
							String subject = mDetails.getSubject();
							String datePosted = mDetails.getDatePosted().toString();
							%>
					<tr class = "body">
					<td><input type = radio name = senderName value = <%= senderName %> <%if(selectedOption == 1) %><%="checked" %>/></td>
					<td>
						<%if(senderName != null) { %> <%= senderName %><%} %><br/>
						<img src = "<%= request.getContextPath() %>/images/<%= senderName %>.jpg" alt = "User Photo" width = 50 height = 50/>
					</td>
					<td><%if(subject != null) { %> <%= subject %> <%} %></td>
					<td><%if(datePosted != null) { %> <%= datePosted %><%} %></td>
					</tr>
					<%selectedOption++; } } %>
				</table>
				<br/>
				<input type = submit name = view value = "VIEW MESSAGE">
				<input type = submit name = post value = "POST MESSAGE">
				<input type = submit name = logout value = "LOGOUT">
			</form>
		</div>
			
		<div id = "footer">
		    Prepared By: Hangjit Rai | Student ID: 11480228 | Charles Sturt University
		</div>
		
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import = "beans.*"%>
<%	
	MessageDetails messageItem1 = (MessageDetails) session.getAttribute("messageItem1"); 
	Boolean editBool = (Boolean) session.getAttribute("editBool");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Post a new message</title>
<link rel = "stylesheet" href = "css/mystyle.css" type = "text/css">
</head>
<body>
	<div>
		<h3>Post a message</h3>	
		<div id = "content" align = "center">
			<form action = "PostMessage" method = "POST">
			
				<%if(messageItem1 == null) {%>
				<table border = 1>
					<tr class = "body">
						<td class = "heading">Message Subject </td>
						<td class = "body"><input type = text name = subject id = subject></td>
					</tr>
					<tr class = "body">
						<td class = "heading">Message </td>
						<td class = "body"><textarea rows = 3 cols = 15 name = messageBody id = messageBody></textarea></td>
					</tr>
					</table>
				<br>
				<input type = submit name = post value = "POST MESSAGE">
				<input type = submit name = cancel value = "CANCEL">
					<%} if(messageItem1 != null) { 
						if(editBool != null && editBool == true) {%>
					<table border = 1>
						<tr>
							<td class = "heading">Message Subject </td>
							<td class = "body"><input type = text name = subject id = subject value = <%= messageItem1.getSubject() %>></td>
						</tr>
						<tr>
							<td class = "heading">Message </td>
							<td class = "body"><textarea rows = 3 cols = 10 name = messageBody id = messageBody> <%= messageItem1.getMessage() %></textarea> </td>
						</tr>
						
						</table>
				<br>
				<input type = submit name = confirm value = "CONFIRM">
				<input type = submit name = cancel value = "CANCEL">
						<% session.setAttribute("editBool", null); } else { %>
						<table border = 1>
						<tr>
							<td class = "heading">Message Subject </td>
							<td class = "body"><%= messageItem1.getSubject() %></td>
						</tr>
						<tr>
							<td class = "heading">Message </td>
							<td class = "body"><%= messageItem1.getMessage() %></td>
						</tr>
						</table>
				<br>
				<input type = submit name = confirm value = "CONFIRM">
				<input type = submit name = edit value = "EDIT">
				<input type = submit name = cancel value = "CANCEL">
					<% } } %>
			</form>
		</div>
		<div id = "footer" align = "center">
		    Prepared By: Hangjit Rai | Student ID: 11480228 | Charles Sturt University
		</div>
	</div>
</body>
</html>
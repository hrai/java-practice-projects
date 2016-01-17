<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import = "beans.*" %>
<%
	MessageDetails message = (MessageDetails) session.getAttribute("message");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Message</title>
<link rel = "stylesheet" href = "css/mystyle.css" type = "text/css">
</head>
<body>
	<div>
		<h3>Message Details</h3>
		<div id = "content" align = center>
			<form action = "ViewMessageList" method = "POST">
				<table border = 1>
					<tr>
						<td class = "heading"><b>Sender Name </b></td>
						<td class = "body"><%= message.getSenderName() %></td>
					</tr>
					<tr>
						<td class = "heading"><b>Message Subject </b></td>
						<td class = "body"><%= message.getSubject() %></td>
					</tr>
					<tr>
						<td class = "heading"><b>Date Posted </b></td>
						<td class = "body"><%= message.getDatePosted() %></td>
					</tr>
					<tr>
						<td class = "heading"><b>Message </b></td>
						<td class = "body"><%= message.getMessage() %></td>
					</tr>
				</table>
				
				<br/><input type = submit name = return value = "RETURN">
			</form>
		</div>
	
		<div id = "footer">
		    Prepared By: Hangjit Rai | Student ID: 11480228 | Charles Sturt University
		</div>
	</div>
</body>
</html>
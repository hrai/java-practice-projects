<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String name = (String)session.getAttribute("name");
	String email = (String)session.getAttribute("email");
	String address = (String)session.getAttribute("address");
	String attendance = (String)session.getAttribute("attendance");
	String dinner_atten = (String)session.getAttribute("dinner_atten");
	String tickets = (String)session.getAttribute("tickets");
	String cost = (String)session.getAttribute("cost");
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Confirmation Page</title>
</head>
<body>
	<div align = "center">
		<h3>Australian Pastry Chef's Conference Bathurst NSW, Australia.<br>
		29 and 30 June<br> Confirmation Form</h3>
		
		<form action = "/ITC357-assignment1/Registration.jsp" method = "post">
			<table border = "1" bordercolor = "white" bgcolor = "antiquewhite">
				<tr>
					<td align = "right">Name:</td>
					<td align = "left"><%= name %></td>
				</tr>
				<tr>
					<td align = "right">Email:</td>
					<td align = "left"><%= email %></td>
				</tr>
				<tr>
					<td align = "right">Address:</td>
					<td align = "left"><%=address %></td>
				</tr>
				<tr>
					<td align = "right">Attendance: </td>
					<td align = "left"><%=attendance %></td>
				</tr>
				<tr>
					<td align = "right">Attending dinner: </td>
					<td align = "left"><%=dinner_atten %></td>
				</tr>
				<tr>
					<td align = "right">Additional dinner<br> tickets: </td>
					<td align = "left"><%=tickets %></td>
				</tr>
				<tr>
					<td align = "right">Total cost: </td>
					<td align = "left"><%=cost %></td>
				</tr>
				<tr>
					<td align = "right">Confirm your <br> registration or edit your <br> data: </td>
					<td align = "left">
						<input type = "submit" name = "confirm" id = "confirm" value = "CONFIRM">
						<input type = "submit" name = "edit" id = "edit" value = "EDIT">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
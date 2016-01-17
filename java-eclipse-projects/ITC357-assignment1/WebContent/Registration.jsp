<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String name = (String)session.getAttribute("name");
	String err_name = (String)session.getAttribute("err_name");
	String email = (String)session.getAttribute("email");
	String err_email = (String)session.getAttribute("err_email");
	String address = (String)session.getAttribute("address");
	String err_add = (String)session.getAttribute("err_add");
	String attendance = (String)session.getAttribute("attendance");
	String err_atten = (String)session.getAttribute("err_atten");
	String discount = (String)session.getAttribute("discount");
	String dinner_atten = (String)session.getAttribute("dinner_atten");
	String err_dinner_atten = (String)session.getAttribute("err_dinner_atten");
	String tickets = (String)session.getAttribute("tickets");
	String err_tickets = (String)session.getAttribute("err_tickets");
	String check = "checked";
	String select = "selected";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Form</title>
</head>
<body>
	<div align = "center">
		<h3>Australian Pastry Chef's Conference Bathurst NSW, Australia.<br>
		29 and 30 June<br> Registration Form</h3>
		
		<form action = "servlet/Validator" method = "post">
			<table border = "1" bordercolor = "white" bgcolor = "antiquewhite">
				<tr>
					<td align = "right">Name:</td>
					<td align = "left"><input type = "text" name = "name" <%if(name != null) {%> value = "<%=name %> <%} %>" id = "name" size = 40>
					<br><%if(err_name != null) {%><font color = "red"><%=err_name %></font><%} %></td>
				</tr>
				<tr>
					<td align = "right">Email:</td>
					<td align = "left"><input type = "text" name = "email" <%if(email != null) {%> value = "<%=email%> <%}%>" id = "email" size = 40>
					<br><%if(err_email != null) {%><font color = "red"><%=err_email %></font><%} %>
					</td>
				</tr>
				<tr>
					<td align = "right">Address:</td>
					<td align = "left"><textarea rows = "4" cols = "30" name  = "address" id = "address"></textarea>
					<br><%if(err_add != null) {%><font color = "red"><%=err_add %></font><%} %>
					</td>
				</tr>
				<tr>
					<td align = "right">Attendance days:</td>
					<td align = "left">
						<select name = "attendance" id = "attendance">
							<option value = "select" <%if(attendance != null) {%><%=select %><%} %>>Please select...</option>
							<option value = "bothDays" <%if(attendance != null) {if(attendance.equals("Wednesday June 29 and Thursday June 30")) {%><%=select %><%}} %>>Both days.($400.00)</option>
							<option value = "29June" <%if(attendance != null) {if(attendance.equals("Wednesday June 29 only")) {%><%=select %><%}} %>>29th June only ($250.00)</option>
							<option value = "30June" <%if(attendance != null) {if(attendance.equals("Thursday June 30 only")) {%><%=select %><%}} %>>30th June only ($250.00)</option>
						</select>
						<br><%if(err_atten != null) {%><font color = "red"><%=err_atten %></font> <%} %>
					</td>
				</tr>
				<tr>
					<td align = "right">Discount category:</td>
					<td align = "left">
						<input type = "radio" name = "discount" value = "noDiscount" <%if(discount != null) {%><%=check%> <%} %>>No Discount<br>
						<input type = "radio" name = "discount" value = "member" <%if(discount != null) {if(discount.equals("member")) {%><%=check%><%}} %>>Member (20% discount)<br>
						<input type = "radio" name = "discount" value = "student" <%if(discount != null) {if(discount.equals("student")) {%><%=check%><%}} %>>Student (40% discount)<br>
						<input type = "radio" name = "discount" value = "studentMember" <%if(discount != null) {if(discount.equals("studentMember")) {%><%=check%><%}} %>>Student Member (50% discount)<br>
					</td>
				</tr>
				<tr>
					<td align = "right">Dinner attendance <br> (free with registration): </td>
					<td align = "left"><input type = "checkbox" name = "dinner_atten" value = "Oh yes!" <%if(dinner_atten != null) {%><%=check %><%} %>>Yes, I will attend the dinner<br>
					<br><%if(err_dinner_atten != null) {%><font color = "red"><%=err_dinner_atten %></font><%} %>
					</td>
				</tr>
				<tr>
					<td align = "right">I would like <br> additional dinner tickets: </td>
					<td align = "left"><input type = "text" name = "tickets" id = "tickets" size = "10" <%if(tickets != null) {%> value = <%=tickets %><%} %>>tickets at $50 each.
					<br><%if(err_tickets != null) {%><font color = "red"><%=err_tickets %></font><%} %>
					</td>
				</tr>
				<tr>
					<td align = "right">Please submit your <br>requirements: </td>
					<td align = "left">
						<input type = "submit" name = "submit" id = "submit" value = "SUBMIT">
						<input type = "submit" name = "clear" id = "clear" value = "CLEAR CHANGES">	
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
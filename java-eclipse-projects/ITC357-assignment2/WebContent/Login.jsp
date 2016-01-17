<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import = "beans.*" %>
<%
	UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
	String userName = "";
	if(userInfo != null)
		userName = userInfo.getUserName();
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
<link rel = "stylesheet" href = "css/mystyle.css" type = "text/css">
</head>
<body>
	<div id = "content" align = "center">
		<h3>Login Page</h3>
	
		<form method = "POST" action = "Validator">
			<table border = 1 bordercolor = gray>
				<tr class = "body">
					<td>User Name </td>
					<td><input type = text name = userName id = userName value = <%= userName %> ></td>
				</tr>
				<tr class = "body">
					<td>Password </td>
					<td>
						<input type = password name = password id = password><br>
						<%if(!userName.equals("")) {%>
						<font color = red>Wrong username or password</font>
						<%} %>
					</td>
				</tr>
			</table>
			<br/>
			<input type = submit name = submit value = "SUBMIT">
			<input type = submit name = reset value = "RESET">
			<input type = submit name = create value = "CREATE AN ACCOUNT">
		</form>
	</div>
	<div id = "footer" align = "center">
	    <p>Prepared By: Hangjit Rai | Student ID: 11480228 | Charles Sturt University</p>
	</div>	
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration page</title>
<link rel = "stylesheet" href = "css/mystyle.css" type = "text/css">
</head>
<body>
	<div>
		<h3>Registration Page</h3>
		<div id = "content" align = center>
			<form action = "Registration" method = "POST" >
				<table border = 1>
					<tr class = "body">
						<td> Enter First Name:
						</td>
						<td> <input type = text name = fName id = fName>
						</td>
					</tr>
					<tr class = "body">
						<td> Enter Last Name:
						</td>
						<td> <input type = text name = lName id = lName>
						</td>
					</tr>
					<tr class = "body">
						<td> Enter User Name:
						</td>
						<td> <input type = text name = uName id = uName>
						</td>
					</tr>
					<tr class = "body">
						<td> Enter Password:
						</td>
						<td> <input type = password name = pWord id = pWord>
						</td>
					</tr>
				</table>
				<br/>
				<input type = submit name = submit value = "SUBMIT">
				<input type = submit name = clear value = "CLEAR">
				<input type = submit name = cancel value = "CANCEL">
			</form>
		</div>
		<div id = "footer" align = "center">
		    Prepared By: Hangjit Rai | Student ID: 11480228 | Charles Sturt University
		</div>
	</div>
</body>
</html>
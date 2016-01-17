<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Upload Image</title>
<link rel = "stylesheet" href = "css/mystyle.css" type = "text/css">
</head>
<body>
	<div id = "container">
		<h3>Upload Image</h3>
		<div id = "content" align = center>
			<form method = "POST" action = "ImageUploader" enctype = "multipart/form-data">
				<table border = 1>
					<tr class = "heading">
						<td>
							Image link: 
						</td>
						<td>
							<input type = file name = image id = image>
						</td>
					</tr>
				</table> 
				<br/>
				<input type = submit name = submit value = "SUBMIT">
				<input type = submit name = skip value = "SKIP THIS STEP">
			</form>
		</div>
		<div id = "footer">
		    Prepared By: Hangjit Rai | Student ID: 11480228 | Charles Sturt University
		</div>
	</div>		
</body>
</html>
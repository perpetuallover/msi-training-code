
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel = "stylesheet" href="css/bootstrap.min.css" type="text/css"></link>
<title>Page1</title>
</head>
<body>
<div class="container">
	<h2>This is page #1</h2>
	<hr>
	<%
		// session data saved in cookie
		session.setAttribute("mysession", "My Session");
	%>
	<form action = "page2.jsp">
		<input type = "text" name = "message"/>
		<button type = "submit" class = "btn btn-primary">Submit</button>
	</form>
</div>
</body>
</html>
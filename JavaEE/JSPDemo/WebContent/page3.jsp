<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel = "stylesheet" href="css/bootstrap.min.css" type="text/css"></link>
<title>Page3</title>
</head>
<body>
<div class="container">
	<h2>This is page #3</h2>
	<hr>
	<p>Session: <%=session.getAttribute("mysession") %></p>
	<p>Request: <%=request.getParameter("message") %></p>	
</div>
</body>
</html>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel = "stylesheet" href="css/bootstrap.min.css" type="text/css"></link>
<title>Page2</title>
</head>
<body>
<div class="container">
	<h2>This is page #2</h2>
	<hr>
	<p>Session: <%=session.getAttribute("mysession") %></p>
	<p>Request: <%=request.getParameter("message") %></p>
	<a href="page3.jsp">Go to Page 3</a>
</div>
</body>
</html>
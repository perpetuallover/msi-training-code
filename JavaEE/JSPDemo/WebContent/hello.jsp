<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hello Page</title>
<link rel = "stylesheet" href="css/bootstrap.min.css" type="text/css"></link>
</head>
<body>
<div class="container">
	<%@include file = "page1.jsp" %>
	<h1>JSP Demo</h1>
	<form role = "form" class="col-sm-6"  method="post">
		<div class = "form-group">
			<label for="name">Name</label>
			<input id = "name" type="text" name = "name" class = "form-control"/>
		</div>
		<div class = "form-group">
			<label for="age">Age</label>
			<input id = "age" type="number" name = "age" class = "form-control" min = "1" max = "100" value="50"/>
		</div>
		<div>
			<button class="btn btn-primary" type="submit" onclick="form.action='HelloServlet';">Submit1</button>
			<button class="btn btn-primary" onclick = "" action = "">Submit2</button>
			<button class="btn btn-primary" type="submit">Submit3</button>
			<button class="btn btn-primary" type="reset">Reset</button>
		</div>
	</form>
</div>
</body>
</html>
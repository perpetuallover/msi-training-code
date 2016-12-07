
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Main Page</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="js/jquery-3.1.0.min.js"></script>
<script>
	$(document).ready(function(){
		$("#btn").on("click", function(){
			$.when(
				$.get("welcome.html")
			).done(function(value){
				$("#welcome").text(value)
			});
			$.get("welcome.html").then(function(resp){
				$("#welcome").html(resp);
			});
		})
	});
</script>
</head>
<body>
<div class="container">
<!-- expression language is still popular -->
	<h1>This is main page</h1>
	<hr>
	<p>Message: ${message}</p>
	<p>Session: <%=session.getAttribute("msg") %></p>
	<p>Seesion2: ${sessionScope.msg}</p>
	<p>Seesion3: ${msg}</p>
	<hr>
	<button id="btn">Welcome</button>
	<h2>Welcome Message: <span id="welcome"></span></h2>
	
</div>

</body>
</html>
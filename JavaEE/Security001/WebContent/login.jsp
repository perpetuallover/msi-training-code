<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="js/jquery-3.1.0.min.js"></script>
<title>Hello Page</title>
<script>
	$(document).ready(function(){
		var msg = "<c:out value='${param.login_error}'/>";
		if(msg!=""){
			$("#error").show();
		}
	});
</script>
<style>
	h2 {
		color: blue;
	}
	.round{
		border-radius: 10px;
	}
	.alert{
		color: red;
		font-size: 10px;
	}
</style>
</head>
<body>
<h2>Login with username and password</h2>
<div style="display:none" id="error">
	<p class="alert">Incorrect username or password</p>
</div>

<form action="j_spring_security_check" method="POST">
	<table>
		<tr>
			<td>Username: </td>
			<td><input type="text" name="j_username"/></td>
		</tr>
		<tr>
			<td>Password: </td>
			<td><input type="password" name="j_password"/></td>
		</tr>
		<tr>
			<td></td>
			<td>
				Remember Me
				<input type="checkbox" name="_spring_security_remember_me"/>
			</td>
		</tr>
		<tr>
			<td></td>
			<td>
				<button type="reset" class="round">Clear</button>
				<button type="submit" class="round">Login</button>
			</td>
		</tr>
	</table>
</form>

</body>
</html>
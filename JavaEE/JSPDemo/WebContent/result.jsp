<!DOCTYPE html>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Result Page</title>
<link rel = "stylesheet" href="css/bootstrap.min.css" type="text/css"></link>
</head>
<body>
<div class="container">
	<%@page import="com.mercury.beans.User" %>
	<jsp:useBean id="userInfo" scope="request" class="com.mercury.beans.UserInfo"/>
	<h2 style = "color: green"><jsp:getProperty property="msg" name="userInfo"/></h2>
	<div class="col-sm-6">
		<table class = "table table-striped table-bordered">
			<tr>
				<th>Name</th>
				<th>Age</th>
			</tr>
			<c:forEach var = "user" items = "${userInfo.user}">
				<tr>
					<td>${user.name}</td>
					<td>${user.age}</td>
				</tr>
			</c:forEach>

			<%--  
			<%
				for(User user: userInfo.getUser()){
					out.print("<tr>");
					out.print("<td>" + user.getName() + "</td>");
					out.print("<td>" + user.getAge() + "</td>");
					out.print("</tr>");
				}
			--%>
		</table>
	</div>
</div>
</body>
</html>
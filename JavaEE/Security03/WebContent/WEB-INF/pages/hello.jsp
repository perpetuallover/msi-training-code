<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hello Page</title>
<style>
	h2 {
		color: green;
	}
</style>
</head>
<body>
<h2>Hello, welcome to Custom Spring Security!</h2>
<a href="<c:url value='/j_spring_security_logout'/>">Logout</a>
</body>
</html>
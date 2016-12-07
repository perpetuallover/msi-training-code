<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Page</title>
</head>
<body>
<h2>Hello ${sessionScope.username}, welcome to Spring Security Admin!</h2>
<a href="<c:url value='/j_spring_security_logout'/>">Logout</a>
</body>
</html>
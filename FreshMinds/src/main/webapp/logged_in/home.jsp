<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<p>Willkommen <%=session.getAttribute("customerUsername")%>!</p>
	<form action="logout" method="post">
		<input type="submit" name="logout" value="Logout" />
	</form>
</body>
</html>
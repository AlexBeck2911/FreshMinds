<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>FreshMinds</title>
	</head>	
	<body>
		<form action="methods/auth/login.jsp" method="post">
			Benutzername:<input type="text" name="Benutzername" /><br>
			<br /> Password:<input type="password" name="Passwort" /><br>
			<br /> <input type="submit" value="Login" />
			<a href="methods/auth/register.jsp">Noch kein Account? Hier registrieren!</a>
		</form>
	</body>
</html>
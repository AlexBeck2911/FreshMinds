<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>

</head>
<body>
	<div class="container">
		<div class="row text-center" style="color: lightblue;">
			<h2>FreshMinds</h2>
		</div>
		<hr>
		<div class="row col-md-10 col-md-offset-3">

			<div class="card card-body">

				<h2>Login</h2>
				<div class="col-md-8 col-md-offset-3">

					<form action="login" method="post">

						<div class="form-group">
							<label for="uname">Benutzername:</label> <input type="text"
								class="form-control" id="uname" placeholder="Benutzername"
								name="Username" required>
						</div>

						<div class="form-group">
							<label for="uname">Passwort:</label> <input type="password"
								class="form-control" id="uname" placeholder="Passwort"
								name="Password" required>
						</div>

						<button type="submit" class="btn btn-primary">Login</button>
						<a href="methods/auth/register.jsp">Noch kein Account? Hier registrieren!</a>

					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
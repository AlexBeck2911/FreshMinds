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
		<div class="row text-center" style="color: tomato;">
			<h2>FreshMinds</h2>
		</div>
		<hr>
		<div class="row col-md-10 col-md-offset-3">

			<div class="card card-body">

				<h2>Registrierung</h2>
				<div class="col-md-8 col-md-offset-3">

					<form action="<%=request.getContextPath()%>/register" method="post">

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

						<div class="form-group">
							<label for="uname">Vorname:</label> <input type="text"
								class="form-control" id="uname" placeholder="Vorname"
								name="Firstname" required>
						</div>

						<div class="form-group">
							<label for="uname">Nachname:</label> <input type="text"
								class="form-control" id="uname" placeholder="Nachname"
								name="Lastname" required>
						</div>
						
						<div class="form-group">
							<label for="uname">Email:</label> <input type="text"
								class="form-control" id="uname" placeholder="Email"
								name="Email" required>
						</div>
						
						<div class="form-group">
							<label for="uname">Geburtstag:</label> <input type="text"
								class="form-control" id="uname" placeholder="Geburtstag"
								name="Geburtstag" required>
						</div>
						
						<div class="form-group">
							<label for="uname">Telefonnummer:</label> <input type="text"
								class="form-control" id="uname" placeholder="Telefonnummer"
								name="Phonenumber" required>
						</div>
						
						<div class="form-group">
							<label for="uname">Land:</label> <input type="text"
								class="form-control" id="uname" placeholder="Land"
								name="Country" required>
						</div>
						
						<div class="form-group">
							<label for="uname">Stadt:</label> <input type="text"
								class="form-control" id="uname" placeholder="Stadt"
								name="City" required>
						</div>
						
						<div class="form-group">
							<label for="uname">Straße:</label> <input type="text"
								class="form-control" id="uname" placeholder="Straße + Nummer"
								name="Street" required>
						</div>
						
						<div class="form-group">
							<label for="uname">Postleitzahl:</label> <input type="text"
								class="form-control" id="uname" placeholder="Postleitzahl"
								name="PostalCode" required>
						</div>

						<button type="submit" class="btn btn-primary">Registrieren</button>

					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
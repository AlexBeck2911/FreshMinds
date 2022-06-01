<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>FreshMinds - Registieren</title>

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

				<h2>Registrierung</h2>
				<div class="col-md-8 col-md-offset-3">

					<form action="<%=request.getContextPath()%>/register" method="post">

						<div class="form-group">
							<label for="username">Benutzername:</label> <input type="text"
								class="form-control" id="username" 
								
								<% if (session.getAttribute("registerErrorUsername") == null) { %>
								
								placeholder="Benutzername"
								
								<% } else { %>		 
								
								placeholder=<%= session.getAttribute("registerErrorUsername") %>
								
								<%} %>
								
								name="Username" required>
						</div>

						<div class="form-group">
							<label for="password">Passwort:</label> <input type="password"
								class="form-control" id="password" 
								
								<% if (session.getAttribute("registerErrorPassword") == null) { %>
								
								placeholder="Passwort (6-20 Zeichen)"
								
								<% } else { %>		 
								
								placeholder=<%= session.getAttribute("registerErrorPassword") %>
								
								<%} %>
								
								name="Password" required>
						</div>

						<div class="form-group">
							<label for="firstname">Vorname:</label> <input type="text"
								class="form-control" id="firstname" placeholder="Vorname"
								name="Firstname" required>
						</div>

						<div class="form-group">
							<label for="lastname">Nachname:</label> <input type="text"
								class="form-control" id="lastname" placeholder="Nachname"
								name="Lastname" required>
						</div>
						
						<div class="form-group">
							<label for="email">Email:</label> <input type="text"
								class="form-control" id="email" placeholder="Email"
								name="Email" required>
						</div>
						
						<div class="form-group">
							<label for="birthday">Geburtstag:</label> <input type="text"
								class="form-control" id="birthday" placeholder="Geburtstag"
								name="Geburtstag" required>
						</div>
						
						<div class="form-group">
							<label for="phonenumber">Telefonnummer:</label> <input type="text"
								class="form-control" id="phonenumber" placeholder="Telefonnummer"
								name="Phonenumber" required>
						</div>
						
						<div class="form-group">
							<label for="country">Land:</label> <input type="text"
								class="form-control" id="country" placeholder="Land"
								name="Country" required>
						</div>
						
						<div class="form-group">
							<label for="city">Stadt:</label> <input type="text"
								class="form-control" id="city" placeholder="Stadt"
								name="City" required>
						</div>
						
						<div class="form-group">
							<label for="street">Straße:</label> <input type="text"
								class="form-control" id="street" placeholder="Straße + Nummer"
								name="Street" required>
						</div>
						
						<div class="form-group">
							<label for="postalcode">Postleitzahl:</label> <input type="text"
								class="form-control" id="postalcode" placeholder="Postleitzahl"
								name="PostalCode" required>
						</div>

						<button type="submit" class="btn btn-primary" id="register">Registrieren</button>

					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
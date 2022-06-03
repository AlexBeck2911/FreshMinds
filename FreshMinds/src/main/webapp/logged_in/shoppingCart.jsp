<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta contentType="text/html; charset=" UTF-8"/>
<title>FreshMinds - Mein Warenkorb</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<style>
.btn-link {
	border: none;
	outline: none;
	background: none;
	cursor: pointer;
	color: rgba(0, 0, 0, .5);
	margin-top: 7px;
	padding: 0;
	font-family: inherit;
	font-size: inherit;
}

.btn-link:hover {
	text-decoration: none;
	color: rgba(0, 0, 0, .7);
}

#orders {
	border-collapse: collapse;
	width: 80%;
	border: 1px solid #ddd;
	font-size: 18px;
}

#orders th, #orders td {
	text-align: left;
	padding: 12px;
}

#orders tr {
	border-bottom: 1px solid #ddd;
}

#orders tr.header, #orders tr:hover {
	background-color: #f1f1f1;
}
</style>

</head>

<body>

	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="<%=request.getContextPath()%>/home">FreshMinds</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item"><a class="nav-link"
					href="<%=request.getContextPath()%>/home">Artikelübersicht <span
						class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item"><a class="nav-link"
					href="<%=request.getContextPath()%>/orders">Meine Bestellungen</a></li>
				<li class="nav-item active"><a class="nav-link"
					href="<%=request.getContextPath()%>/shoppingcart">Mein
						Warenkorb</a></li>
				<li class="nav-item">
					<form action="<%=request.getContextPath()%>/logout" method="post">
						<input type="submit" name="logout" value="Logout" class="btn-link" />
					</form>
				</li>
				</li>
			</ul>
		</div>
	</nav>

	<div align="center">
		<h2>Mein Warenkorb</h2>
		<%if (Double.parseDouble(session.getAttribute("totalPrice").toString()) > 0.0) {%>
		<table border="1" cellpadding="6" id="orders">
			<tr>
				<th>Artikelname</th>
				<th>Menge</th>
				<th>Gesamtpreis</th>
				<th>Aktion</th>
			</tr>
			<c:forEach var="shoppingCart" items="${shoppingCart}"
				varStatus="status">
				<c:set var="articleNumber">${shoppingCart.articleNumber}</c:set>
				<tr>
					<td><c:out value="${sessionScope[articleNumber]}" /></td>
					<td><c:out value="${shoppingCart.amount}" /></td>
					<td><c:out value="${totalItemPrice[status.index]} €" /></td>
					<td><a
						href="<%=request.getContextPath()%>/removefromshoppingcart?id=<c:out value='${shoppingCart.col}' />">Entfernen</a></td>
				</tr>
			</c:forEach>
		</table>

		<h3>
			Zu bezahlender Gesamtbetrag: ${totalPrice} €
			</h2>

			<form action="<%=request.getContextPath()%>/buy"
				method="post">
				<label for="paymentMethod">Bezahlungsmethode:</label> <select
					name="paymentMethod" id="paymentMethods">
					<option>PayPal</option>
					<option>Kreditkarte</option>
					<option>SEPA-Lastschrift</option>
				</select>

				<h4>Lieferadresse</h4>

				<div class="col-md-8 col-md-offset-3">
					<div class="form-group">
						<label for="country">Land:</label> <input type="text"
							class="form-control" id="country" name="Country"
							value="<%=session.getAttribute("country")%>" required>

					</div>

					<div class="form-group">
						<label for="city">Stadt:</label> <input type="text"
							class="form-control" id="city" name="City"
							value="<%=session.getAttribute("city")%>" required>
					</div>

					<div class="form-group">
						<label for="street">Straße:</label> <input type="text"
							class="form-control" id="street"
							value="<%=session.getAttribute("street")%>" name="Street"
							required>
					</div>

					<div class="form-group">
						<label for="postalcode">Postleitzahl:</label> <input type="text"
							class="form-control" id="postalcode"
							value="<%=session.getAttribute("postalCode")%>" name="PostalCode"
							required>
					</div>

					<label for="delivery_date">Gewünschtes Lieferdatum:</label> <input
						type="datetime-local" id="delivery_date" name="delivery_date">
					<br/>
					<button type="submit" class="btn btn-primary" id="buy"
						align="center">Bestellung abschließen</button>
			</form>
			<%} else { %>
				<h3>Ihr Warenkorb ist leer!</h3>
			<%} %>
	</div>
</body>

<script>
	var deliveryDatePicker = document.getElementById("delivery_date");
	var minDeliveryDate = new Date();
	minDeliveryDate.setDate(minDeliveryDate.getDate() + 5);
	minDeliveryDate.setHours(12, 0, 0, 0);

	deliveryDatePicker.setAttribute("value", minDeliveryDate.toISOString()
			.slice(0, -8));
	deliveryDatePicker.setAttribute("min", minDeliveryDate.toISOString().slice(
			0, -8));

	var maxDeliveryDate = new Date();
	maxDeliveryDate.setDate(maxDeliveryDate.getDate() + 19);
	maxDeliveryDate.setHours(12, 0, 0, 0);
	deliveryDatePicker.setAttribute("max", maxDeliveryDate.toISOString().slice(
			0, -8));
</script>

</html>
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

<link rel="stylesheet" href="../css/standard.css">

</head>

<body>
	<div class="pageContent">
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
				</ul>
				<ul class="navbar-nav">
					<li class="nav-item active"><a class="nav-link"
						href="<%=request.getContextPath()%>/shoppingcart">Mein
							Warenkorb</a></li>
					<li class="nav-item">
						<form action="<%=request.getContextPath()%>/logout" method="post">
							<input type="submit" name="logout" value="Logout"
								class="btn-link" />
						</form>
					</li>
				</ul>
			</div>
		</nav>

		<div align="center" class="content">
			<h2 class="pageTitle">Mein Warenkorb</h2>
			<%
			if (Double.parseDouble(session.getAttribute("totalPrice").toString()) > 0.0) {
			%>
			<table border="1" cellpadding="6" id="table">
				<tr>
					<th>Artikelname</th>
					<th>Menge</th>
					<th>Gesamtpreis</th>
					<th>Aktion</th>
				</tr>
				<c:forEach var="shoppingCart" items="${shoppingCart}"
					varStatus="status">
					<c:set var="articleNumber">${shoppingCart.articleNumber}</c:set>
					<c:set var="totalPrice">
						<fmt:formatNumber type="number" minFractionDigits="2"
							maxFractionDigits="2" value="${totalItemPrice[status.index]}" />
					</c:set>
					<tr>
						<td><c:out value="${sessionScope[articleNumber]}" /></td>
						<td><c:out value="${shoppingCart.amount}" /></td>
						<td><c:out value="${totalPrice} €" /></td>
						<td><a
							href="<%=request.getContextPath()%>/removefromshoppingcart?id=<c:out value='${shoppingCart.id}' />">Entfernen</a></td>
					</tr>
				</c:forEach>
			</table>

			<h3 class="pageTitle">
				Zu bezahlender Gesamtbetrag: ${totalPrice} €
				</h3>

				<form action="<%=request.getContextPath()%>/buy" method="post">
					<label for="paymentMethod">Bezahlungsmethode:</label> <select
						name="paymentMethod" id="paymentMethods">
						<option>PayPal</option>
						<option>Kreditkarte</option>
						<option>SEPA-Lastschrift</option>
					</select>

					<h4 class="pageTitle">Lieferadresse</h4>

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
								value="<%=session.getAttribute("postalCode")%>"
								name="PostalCode" required>
						</div>

						<label for="delivery_date">Gewünschtes Lieferdatum:</label> <input
							type="datetime-local" id="delivery_date" name="delivery_date" class="element-margin">
						<br />
						<button type="submit" class="btn btn-primary element-margin" id="buy" 
							align="center">Bestellung abschließen</button>
				</form>
				<%
				} else {
				%>
				<h3>Ihr Warenkorb ist leer!</h3>
				<%
				}
				%>
			
		</div>
	</div>
	<footer class="footer mt-auto py-3 bg-light">
		<div class="container">
			<span class="text-muted">© 2022 FreshMinds</span>
		</div>
	</footer>
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
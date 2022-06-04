<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta contentType="text/html; charset=" UTF-8"/>
<title>FreshMinds - Artikel kaufen</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<link rel="stylesheet" href="../css/standard.css">
<link rel="stylesheet" href="../css/add.css">

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
					<li class="nav-item active"><a class="nav-link"
						href="<%=request.getContextPath()%>/home">Artikelübersicht <span
							class="sr-only">(current)</span>
					</a></li>
					<li class="nav-item"><a class="nav-link"
						href="<%=request.getContextPath()%>/orders">Meine Bestellungen</a></li>
				</ul>
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link"
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

		<div align="center">
			<h2 class="pageTitle"><%=session.getAttribute("articleName")%>
				kaufen
			</h2>
			<form action="<%=request.getContextPath()%>/addtoshoppingcart"
				method="post">
				<div class="slidecontainer">
					<input type="range" min="1"
						<%if (Integer.parseInt(session.getAttribute("availability").toString()) >= 200) {%>
						max="200" <%} else {%>
						max="<%=Integer.parseInt(session.getAttribute("availability").toString())%>"
						<%}%> value="1" class="slider" id="amountRange" name="amountRange">
				</div>
				<p>
					Menge: <span id="amount">1</span>
				</p>

				<p>
					Preis: <span id="orderAmount">1</span><span> x </span><span
						id="articlePrice"><%=Double.parseDouble(session.getAttribute("articlePrice").toString())%>
					</span><span> €</span><span> = </span><span id="totalPrice"><%=Double.parseDouble(session.getAttribute("articlePrice").toString())%></span><span>
						€</span>
				</p>

				<button type="submit" class="btn btn-primary element-margin" id="add"
					align="center">Zum Warenkorb hinzufügen</button>
			</form>
		</div>

	</div>

	<footer class="footer mt-auto py-3 bg-light">
		<div class="container">
			<span class="text-muted">© 2022 FreshMinds</span>
		</div>
	</footer>

</body>

<script>
	var slider = document.getElementById("amountRange");
	var output = document.getElementById("amount");
	var orderAmount = document.getElementById("orderAmount");
	var articlePrice = document.getElementById("articlePrice").innerHTML
	var totalPrice = document.getElementById("totalPrice")
	output.innerHTML = slider.value;

	slider.oninput = function() {
		var amount = this.value;
		output.innerHTML = amount;
		orderAmount.innerHTML = amount;
		var totalPriceValue = articlePrice * amount;
		totalPrice.innerHTML = totalPriceValue.toFixed(2);

	}
</script>
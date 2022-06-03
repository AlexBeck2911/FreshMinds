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

.slidecontainer {
	width: 100%; /* Width of the outside container */
}

/* The slider itself */
.slider {
	-webkit-appearance: none;
	width: 200px;
	height: 15px;
	border-radius: 5px;
	background: #d3d3d3;
	outline: none;
	opacity: 0.7;
	-webkit-transition: opacity .15s ease-in-out;
	transition: opacity .15s ease-in-out;
}

.slider::-webkit-slider-thumb {
	-webkit-appearance: none; /* Override default look */
	appearance: none;
	width: 25px; /* Set a specific slider handle width */
	height: 25px; /* Slider handle height */
	background: #04AA6D; /* Green background */
	cursor: pointer; /* Cursor on hover */
}

/* Mouse-over effects */
.slider:hover {
	opacity: 1; /* Fully shown on mouse-over */
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
				<li class="nav-item active"><a class="nav-link" href="<%=request.getContextPath()%>/home">Artikelübersicht
						<span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item"><a class="nav-link" href="<%=request.getContextPath()%>/orders">Meine
						Bestellungen</a></li>
				<li class="nav-item"><a class="nav-link" href="<%=request.getContextPath()%>/shoppingcart">Mein Warenkorb</a></li>
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
		<h2><%=session.getAttribute("articleName")%>
			kaufen
		</h2>
		<form action="<%=request.getContextPath()%>/addtoshoppingcart" method="post">
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
			
			<button type="submit" class="btn btn-primary" id="add" align="center">Zum Warenkorb hinzufügen</button>
				
			</div>
			
		</form>

	</div>

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
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta contentType="text/html; charset=" UTF-8"/>
<title>FreshMinds - Details</title>
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
				<li class="nav-item active"><a class="nav-link"
					href="<%=request.getContextPath()%>/orders">Meine Bestellungen</a></li>
				<li class="nav-item"><a class="nav-link"
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
		<h2>
			Details zur Bestellung
			<%=session.getAttribute("transactionNumber")%></h2>
		<table border="1" cellpadding="6" id="orders">
			<tr>
				<th>Artikelname</th>
				<th>Menge</th>
				<th>Gesamtpreis</th>
			</tr>
			<c:forEach var="transaction" items="${transactionDetails}"
				varStatus="status">
				<c:set var="totalPrice"><fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${transaction.price}" /></c:set>
				<tr>
					<td><c:out value="${articleNames[status.index]}" /></td>
					<td><c:out value="${transaction.amount}" /></td>
					<td><c:out value="${totalPrice} €" /></td>
			</c:forEach>
		</table>

		<form action="<%=request.getContextPath()%>/orders">
			<button type="submit" class="btn btn-primary" id="add" align="center">Zurück</button>
		</form>

	</div>

</body>
</html>
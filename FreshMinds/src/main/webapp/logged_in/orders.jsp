<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta contentType="text/html; charset=" UTF-8"/>
<title>FreshMinds - Meine Bestellungen</title>
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
					<li class="nav-item active"><a class="nav-link"
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
			<h2 class="pageTitle">Meine Bestellungen</h2>
			<table border="1" cellpadding="6" id="table">
				<tr>
					<th>Transaktionsnummer</th>
					<th>Gesamtmenge</th>
					<th>Gesamtpreis</th>
					<th>Bestellzeitpunkt</th>
					<th>Lieferdatum</th>
					<th>Land</th>
					<th>Stadt</th>
					<th>Straße</th>
					<th>Postleitzahl</th>
					<th>Aktion</th>
				</tr>
				<c:forEach var="transactions" items="${completeTransactions}"
					varStatus="status">
					<c:set var="transactionNumber">${transactions.transactionNumber}</c:set>
					<c:set var="totalPriceNumber">
						<fmt:formatNumber type="number" minFractionDigits="2"
							maxFractionDigits="2" value="${totalPrice[status.index]}" />
					</c:set>
					<c:set var="transactionTimestamp">
						<fmt:formatDate value="${transactions.timestamp}"
							pattern="dd.MM.yyyy HH:mm:ss" />
					</c:set>
					<c:set var="deliveryDateTimestamp">
						<fmt:formatDate value="${deliveries[status.index].deliveryDate}"
							pattern="dd.MM.yyyy HH:mm:ss" />
					</c:set>
					<tr>
						<td><c:out value="${transactions.transactionNumber}" /></td>
						<td><c:out value="${totalAmount[status.index]} Artikel" /></td>
						<td><c:out value="${totalPriceNumber} €" /></td>
						<td><c:out value="${transactionTimestamp}" /></td>
						<td><c:out value="${deliveryDateTimestamp}" /></td>
						<td><c:out value="${deliveries[status.index].country}" /></td>
						<td><c:out value="${deliveries[status.index].city}" /></td>
						<td><c:out value="${deliveries[status.index].street}" /></td>
						<td><c:out value="${deliveries[status.index].postalCode}" /></td>
						<td><a
							href="<%=request.getContextPath()%>/details?transactionNumber=<c:out value='${transactions.transactionNumber}' />">Details</a></td>

					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	<footer class="footer mt-auto py-3 bg-light">
		<div class="container">
			<span class="text-muted">© 2022 FreshMinds</span>
		</div>
	</footer>

</body>
</html>
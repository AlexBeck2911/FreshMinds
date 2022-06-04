<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta contentType="text/html; charset=" UTF-8"/>
<title>FreshMinds - Start</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<link rel="stylesheet" href="../css/standard.css">
<link rel="stylesheet" href="../css/home.css">

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

		<h1 align="center" class="pageTitle">
			Willkommen
			<%=session.getAttribute("customerUsername")%>!
		</h1>

		<div align="center" class="content">
			<h2 class="pageSubTitle">Unser Sortiment</h2>
			<input type="text" id="searchTable" onkeyup="search()"
				placeholder="Suchen in jeglicher Kategorie...">
			<table border="1" cellpadding="6" id="table">
				<tr>
					<th>Artikelnummer</th>
					<th>Kategorie</th>
					<th>Artikelname</th>
					<th>Artikelherkunft</th>
					<th>Artikelpreis</th>
					<th>Verfügbar</th>
					<th>Aktion</th>
				</tr>
				<c:forEach var="article" items="${listArticles}" varStatus="status">
					<c:set var="articleCategoryNumber">${article.articleCategory}</c:set>
					<c:set var="articleID">${article.articleNumber}</c:set>
					<c:set var="articlePrice">
						<fmt:formatNumber type="number" minFractionDigits="2"
							maxFractionDigits="2" value="${article.articlePrice}" />
					</c:set>
					<tr>
						<td><c:out value="${article.articleNumber}" /></td>
						<td><c:out value="${sessionScope[articleCategoryNumber]}" /></td>
						<td><c:out value="${article.articleName}" /></td>
						<td><c:out value="${article.articleOrigin}" /></td>
						<td><c:out value="${articlePrice} €" /></td>
						<td><c:out value="${listStocks[status.index].articleAmount}" /></td>

						<c:if test="${inShoppingCart[status.index] == true}">
							<td>im Warenkorb!</td>
						</c:if>
						<c:if test="${inShoppingCart[status.index] == false}">
							<c:if test="${listStocks[status.index].articleAmount != 0}">
								<td><a
									href="<%=request.getContextPath()%>/addtoshoppingcart?articleID=<c:out value='${article.articleNumber}' />">Kaufen</a></td>
							</c:if>
							<c:if test="${listStocks[status.index].articleAmount == 0}">
								<td>Ausverkauft!</td>
							</c:if>
						</c:if>

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

<script>
	function search() {
		var input, filter, table, tr, td, i, txtValue;
		input = document.getElementById("searchTable");
		filter = input.value.toUpperCase();
		table = document.getElementById("table");
		tr = table.getElementsByTagName("tr");
		for (i = 1; i < tr.length; i++) {
			td = tr[i];
			if (td) {
				txtValue = td.textContent || td.innerText;
				if (txtValue.toUpperCase().indexOf(filter) > -1) {
					tr[i].style.display = "";
				} else {
					tr[i].style.display = "none";
				}
			}
		}
	}
</script>

</html>
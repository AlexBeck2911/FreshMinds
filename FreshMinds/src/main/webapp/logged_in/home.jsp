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

#searchTable {
  background-image: url('/css/searchicon.png'); 
  background-position: 10px 12px; 
  background-repeat: no-repeat; 
  width: 50%; 
  font-size: 
  padding: 12px 20px 12px 40px; 
  border: 1px solid #ddd; 
  margin-bottom: 12px; 
}

#selection {
  border-collapse: collapse; 
  width: 80%; 
  border: 1px solid #ddd; 
  font-size: 18px; 
}

#selection th, #selection td {
  text-align: left; 
  padding: 12px; 
}

#selection tr {
  border-bottom: 1px solid #ddd;
}

#selection tr.header, #selection tr:hover {
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
				<li class="nav-item active"><a class="nav-link"
					href="<%=request.getContextPath()%>/home">Artikelübersicht <span
						class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item"><a class="nav-link"
					href="<%=request.getContextPath()%>/orders">Meine Bestellungen</a></li>
				<li class="nav-item">
					<form action="<%=request.getContextPath()%>/logout" method="post">
						<input type="submit" name="logout" value="Logout" class="btn-link" />
					</form>
				</li>
				</li>
			</ul>
		</div>
	</nav>

	<h1 align="center">
		Willkommen
		<%=session.getAttribute("customerUsername")%>!
	</h1>

	<div align="center">
		<h2>Unser Sortiment</h2>
		<input type="text" id="searchTable" onkeyup="search()"
			placeholder="Suchen in jeglicher Kategorie">
		<table border="1" cellpadding="6" id="selection">
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

					<c:if test="${listStocks[status.index].articleAmount != 0}">
						<td><a
							href="<%=request.getContextPath()%>/buy?articleID=<c:out value='${article.articleNumber}' />">Kaufen</a></td>
					</c:if>
					<c:if test="${listStocks[status.index].articleAmount == 0}">
						<td>Ausverkauft!</td>
					</c:if>

				</tr>
			</c:forEach>
		</table>
	</div>

</body>

<script>
	function search() {
		var input, filter, table, tr, td, i, txtValue;
		input = document.getElementById("searchTable");
		filter = input.value.toUpperCase();
		table = document.getElementById("selection");
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
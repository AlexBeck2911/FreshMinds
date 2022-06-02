<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
    color: rgba(0,0,0,.5);
    margin-top: 7px;
    padding: 0;
    font-family: inherit;
    font-size: inherit;
}

.btn-link:hover {
	text-decoration: none;
	color: rgba(0,0,0,.7);
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
				<li class="nav-item"><a class="nav-link" href="#">Meine
						Bestellungen</a></li>
				<li class="nav-item">
					<form action="<%=request.getContextPath()%>/logout" method="post">
						<input type="submit" name="logout" value="Logout" class="btn-link" />
					</form>
				</li>
				</li>
			</ul>
		</div>
	</nav>

	<h1 align = "center">
		Willkommen
		<%=session.getAttribute("customerUsername")%>!
	</h1>

	<div align="center">
		<h2>Unser Sortiment</h2>
		<table border="1" cellpadding="6">
			<tr>
				<th>Artikelnummer</th>
				<th>Kategorie</th>
				<th>Artikelname</th>
				<th>Artikelherkunft</th>
				<th>Artikelpreis</th>
				<th>Verfügbar</th>
				<th>Aktion</th>
			</tr>
			<c:forEach var="article" items="${listArticles}">
				<c:set var="articleCategoryNumber">${article.articleCategory}</c:set>
				<c:set var="articleID">${article.articleNumber}</c:set>
				<tr>
					<td><c:out value="${article.articleNumber}" /></td>
					<td><c:out value="${sessionScope[articleCategoryNumber]}" /></td>
					<td><c:out value="${article.articleName}" /></td>
					<td><c:out value="${article.articleOrigin}" /></td>
					<td><c:out value="${article.articlePrice} Euro" /></td>
					<td><c:out value="${sessionScope[articleID]}" /></td>
					
					<c:if test="${sessionScope[articleID] != 0}">
    					<td><a href="<%=request.getContextPath()%>/buy?articleID=<c:out value='${article.articleNumber}' />">Kaufen</a></td>
					</c:if>
					<c:if test="${sessionScope[articleID] == 0}">
    					<td>Ausverkauft!</td>
					</c:if>
					
				</tr>
			</c:forEach>
		</table>
	</div>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<p>Willkommen <%=session.getAttribute("customerUsername")%>!</p>
	
	<div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>Unser Sortiment</h2></caption>
            <tr>
                <th>Artikelnummer</th>
                <th>Kategorie</th>
                <th>Artikelname</th>
                <th>Artikelherkunft</th>
                <th>Artikelpreis</th>
            </tr>
            <c:forEach var="article" items="${listArticles}">
                <tr>
                    <td><c:out value="${article.articleNumber}" /></td>
                    <td><c:out value="${article.articleCategory}" /></td>
                    <td><c:out value="${article.articleName}" /></td>
                    <td><c:out value="${article.articleOrigin}" /></td>
					<td><c:out value="${article.articlePrice}" /></td>
                </tr>
            </c:forEach>
        </table>
    </div> 
	
	<form action="logout" method="post">
		<input type="submit" name="logout" value="Logout" />
	</form>

	
</body>
</html>
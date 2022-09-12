<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix= "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class= "container"> <!-- Beginning of Container -->
		<h1>You added a db successfully!!</h1>
		
		
		<p> <c:out value = "${books}"> </c:out></p>
		
		
		<c:forEach var = "book" items = "${books}">
			<h2> <c:out value = "${book.title}"> </c:out></h2>
			<p> Number of Pages: <c:out value = "${book.numberOfPages}"> </c:out></p>
			<p>Written in: <c:out value = "${book.language}"> </c:out></p>
			<p>Description: <c:out value = "${book.description}"> </c:out></p>
		</c:forEach>
		
	</div> <!-- End of Container -->
</body>
</html>
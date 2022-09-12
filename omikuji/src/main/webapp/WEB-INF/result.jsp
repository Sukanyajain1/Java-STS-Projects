<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix= "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Omikuji REsult</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<h1> Here's Your Omikuji! </h1>
	
	<div class= "container bg-info border border-3 border-dark ">
		<h2>In <c:out value = "${userFortune.randomNumber}"> </c:out> years, you will live in <c:out value = "${userFortune.city}"> </c:out>  with <c:out value = "${userFortune.person}"> </c:out> as your roommate, <c:out value = "${userFortune.hobby}"> </c:out> for a living.</h2>
		<h2>The next time you see a <c:out value = "${userFortune.livingThing}"> </c:out>, you will have good luck.</h2>
		<h2>Also, <c:out value = "${userFortune.personalMessage}"> </c:out> </h2>
	</div>
	
	<a href = "/omikuji"> Go Back </a>
</body>
</html>
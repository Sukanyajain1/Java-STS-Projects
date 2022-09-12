<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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

<!-- <link rel="stylesheet" type="text/css" href="/css/style.css">
	<script type="text/javascript" src="/js/app.js"></script> -->
</head>

<body>
	<h1>Customer Name: <c:out value = "${cust_name}"> </c:out> </h1>
	<h2>Item name:  <c:out value = "${item_name}"> </c:out> </h2>
	<h2>Price: $<c:out value = "${price}"> </c:out> </h2>
	<h2>Description: <c:out value = "${description}"> </c:out> </h2>
	<h2>Vendor: <c:out value = "${vendor}"> </c:out> </h2>
</body>
</html>
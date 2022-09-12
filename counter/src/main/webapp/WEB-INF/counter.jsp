<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix= "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>You have visited <a href = "/your_server"> http://your_server</a> <c:out value = "${counter}"></c:out> times.</h1>
<h1><a href = "/your_server">Test another visit?</a></h1>
</body>
</html>
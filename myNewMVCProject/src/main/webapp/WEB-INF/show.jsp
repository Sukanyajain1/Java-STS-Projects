<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
   <!-- Formatting (like dates) -->
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
   <!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
   <!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" 
      rel="stylesheet" 
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" 
      crossorigin="anonymous">
</head>
<body>

	<h1><c:out value = "${oneBook.title}"> </c:out></h1>
	<h3>Description: <c:out value = "${oneBook.description}"> </c:out></h3>
	<h3>Language: <c:out value = "${oneBook.language}"></c:out></h3>
	<h3>Number of Pages: <c:out value = "${oneBook.numberOfPages}"></c:out></h3>
	<p></p>
	<h4><a href = "/">Go back to the dashboard</a></h4>

</body>
</html>
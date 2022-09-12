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
<title>The first practice MVC project</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" 
      rel="stylesheet" 
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" 
      crossorigin="anonymous">
</head>
<body class="container">
	<h1>Hello there</h1>
<%-- 	<p> <c:out value = "${books}"></c:out></p> --%>
	<table>
	<tr>
		<th> Title</th>
		<th> Description</th>
		<th> Language</th>
		<th> Number of Pages</th>
		<th> Edit</th>

	</tr>
	<c:forEach var= "book" items = "${books}">
		<tr>
			<td><a href = "/books/${book.id}"><c:out value = "${book.title}"> </c:out></a></td>
			<td><c:out value = "${book.description}"> </c:out></td>
			<td><c:out value = "${book.language}"> </c:out></td>
			<td><c:out value = "${book.numberOfPages}"> </c:out></td>
			<td><a href = "/update/${book.id}">Update</a></td>
			<td><a href = "/delete/${book.id}">Delete</a></td>
		</tr>
	</c:forEach>
	</table>
	<br>
	<h3><a href = "/books/new">Create a New Book!</a></h3>
</body>
</html>
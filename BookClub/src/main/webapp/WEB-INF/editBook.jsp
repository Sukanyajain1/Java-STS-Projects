<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   <!-- c:out ; c:forEach ; c:if -->
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
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
<title>Edit a Book</title>
  <!-- Bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" 
      rel="stylesheet" 
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" 
      crossorigin="anonymous">
</head>
<body class = "container">
	<h1>Change Your Entry</h1>
	<h4 class= "text-danger">Author must not be blank</h4>
	<form:form action = "/update/processing/${oneBook.id}" method = "post" modelAttribute = "oneBook">
	<input type="hidden" name="_method" value="put">
	<div>
		<form:label path = "title">Title: </form:label>
		<form:errors class="text-danger" path = "title"/>
		<form:input path = "title"/>
	</div>
	<div>
		<form:label path = "author">Author: </form:label>
		<form:errors class="text-danger" path = "author"/>
		<form:input path = "author"/>
	</div>
	<div>
		<form:label path = "thought">My Thoughts: </form:label>
		<form:errors class="text-danger" path = "thought"/>
		<form:input path = "thought"/>
	</div>
		<input type = "submit" value = "Submit">
	</form:form><br>
	<h4><a href = "/dashboard">back to the shelves</a></h4>
	<h4><a href = "/logout" class="btn btn-danger btn-lg">Log out</a></h4>
</body>
</html>
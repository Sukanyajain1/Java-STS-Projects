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

    <title>Dojo Page</title>
  <!-- Bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" 
      rel="stylesheet" 
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" 
      crossorigin="anonymous">
</head>
<body class = "container">
	<h1><c:out value = "${oneDojo.dojoName}"></c:out> Location Ninjas</h1>
	
	<table class="table">
  <thead>
    <tr>
      <th scope="col">First Name</th>
      <th scope="col">Last Name</th>
      <th scope="col">Age</th>
    </tr>
  </thead>
  <tbody>
	  <c:forEach var = "ninja" items = "${oneDojo.ninjas}">
	    <tr>
	      <td><c:out value = "${ninja.firstName}"></c:out></td>
	      <td><c:out value = "${ninja.lastName}"></c:out></td>
	      <td><c:out value = "${ninja.age}"></c:out></td>

	    </tr>
	  </c:forEach>
  </tbody>
</table>
	<div>
		<a href = "/ninjas/new">Create a Ninja</a> | <a href = "/dojos/new">Create a Dojo</a>
	</div>

</body>
</html>
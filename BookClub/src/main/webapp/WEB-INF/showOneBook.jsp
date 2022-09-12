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
<title></title>
  <!-- Bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" 
      rel="stylesheet" 
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" 
      crossorigin="anonymous">
</head>
<body class = "container">
	<h1><c:out value = "${oneBook.title}"> </c:out></h1>
	<c:set var = "postedBy" scope = "page" value = "${oneBook.user.id}"/>
	<c:set var = "userId" scope = "session" value = "${user_id}"/>
	
	
	
	<c:choose>
		<c:when test = "${postedBy == userId}">
<%-- 		<c:out value = "${postedBy}"></c:out>
		<c:out value = "${userId}"></c:out> --%>
		
		
		
			<h3>You read <c:out value = "${oneBook.title}"></c:out> by <c:out value = "${oneBook.author}"></c:out></h3>
			<h3>Here are your thoughts:</h3>
			<p><c:out value = "${oneBook.thought}"></c:out></p>
			<a href = "/edit/${oneBook.id}" class="btn btn-secondary btn-lg">edit</a>
		</c:when>
		<c:otherwise>
			<h4><c:out value = "${oneBook.user.userName}"></c:out> read <c:out value = "${oneBook.title}"></c:out> by <c:out value = "${oneBook.author}"></c:out></h4>
			<h4>Here are <c:out value = "${oneBook.user.userName}"></c:out>'s thoughts:</h4>
			<p><c:out value = "${oneBook.thought}"></c:out></p>
		</c:otherwise>
	</c:choose>
	



	<h4><a href = "/dashboard">back to the shelves</a></h4>
	<h4><a href = "/logout" class="btn btn-danger btn-lg">Log out</a></h4>


</body>
</html>
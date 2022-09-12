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
		    <title>New Dojo</title>
		  <!-- Bootstrap -->
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" 
		      rel="stylesheet" 
		      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" 
		      crossorigin="anonymous">
		
	</head>
	<body class= "container">
		<div>
			<h1>New Dojo</h1>
		</div>
		<div>
		<form:form action = "/dojos/processing" method = "post" modelAttribute = "dojo">
			<div class= "container">
				<form:label path="dojoName">Name: </form:label>
				<form:errors class="text-danger" path="dojoName"/>
				<form:input path="dojoName"/>
			</div>
			<input type = "submit" value = "Create">
		</form:form>
		</div>
	</body>
</html>
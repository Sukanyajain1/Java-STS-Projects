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
		    <title>New Ninja</title>
		  <!-- Bootstrap -->
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" 
		      rel="stylesheet" 
		      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" 
		      crossorigin="anonymous">
		
	</head>
	<body class= "container">
		<div>
		<h1>New Ninja</h1>
		</div>
		<div>
		<form:form action = "/ninjas/processing" method = "post" modelAttribute = "ninja">
			<div class= "container">
				<div>
					<form:label path="dojo">Name: </form:label>
					<form:errors class="text-danger" path="dojo"/>
					<form:select path="dojo">
				        <c:forEach var="dojo" items="${dojos}">
	
				            <form:option value="${dojo.id}" path="dojo_id">
	
				                <c:out value="${dojo.dojoName}"/>
	
				            </form:option>
				        </c:forEach>
				    </form:select>
				</div>
				<div>
					<form:label path="firstName">First Name: </form:label>
					<form:errors class="text-danger" path="firstName"/>
					<form:input path="firstName"/>
				</div>
				<div>
					<form:label path="lastName">Last Name: </form:label>
					<form:errors class="text-danger" path="lastName"/>
					<form:input path="lastName"/>
				</div>
				<div>
					<form:label path="age">Age: </form:label>
					<form:errors class="text-danger" path="age"/>
					<form:input type = "number" path="age"/>
				</div>
			</div>
			<input type = "submit" value = "Create">
		</form:form>
		</div>

	</body>
</html>
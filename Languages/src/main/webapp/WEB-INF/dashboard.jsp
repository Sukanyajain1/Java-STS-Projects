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
<title>Title Here</title>
  <!-- Bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" 
      rel="stylesheet" 
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" 
      crossorigin="anonymous">
</head>
<body>
	<h1>Hello this is the dashboard</h1>
	<div class="container">
		<table class="table">
			<thead>
				<tr>
					<th scope="col">Name</th>
					<th scope="col">Creator</th>
					<th scope="col">Version</th>
					<th scope="col">action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var = "lang" items = "${languages}">
					<tr>
					<th scope="row"><a href = "languages/show/${lang.id}">${lang.languageName}</a></th>
					<td><c:out value = "${lang.creator}"></c:out></td>
					<td><c:out value = "${lang.version}"></c:out></td>
					<td><a href = "/languages/delete/${lang.id}">Delete</a> | <a href = "/update/{lang.id}">Edit</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div>
			<form:form action = "/languages/create" method = "post" modelAttribute = "newLanguage">
				<div>
					<form:label path = "languageName">Name: </form:label>
					<form:errors class = "text-danger" path = "languageName"/>
					<form:input path = "languageName"/>
				</div>
				<div>
					<form:label path = "creator">Creator: </form:label>
					<form:errors class = "text-danger" path = "creator"/>
					<form:input path = "creator"/>
				</div>
				<div>
					<form:label path = "version">Version: </form:label>
					<form:errors class = "text-danger" path = "version"/>
					<form:input path = "version"/>
				</div>
				<input type = "submit" value = "Submit">
			</form:form>
		</div>
	</div>
</body>
</html>
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
	<div class= "container">
		<div>
			<h3><a href = "/">Go Back To Dashboard</a></h3>
		</div>
		<h2>Edit expense:</h2>
		<h4 class= "text-danger">Description must not be blank</h4>
		<form:form action = "/update/processing/${oneExpense.id}" method = "post" modelAttribute = "oneExpense">
			<input type="hidden" name="_method" value="put">
				<div>
					<form:label path = "expenseName">Expense Name: </form:label>
					<form:errors class="text-danger" path = "expenseName"/>
					<form:input path = "expenseName"/>
				</div>
				<div>
					<form:label path = "vendor">Vendor: </form:label>
					<form:errors class="text-danger" path = "vendor"/>
					<form:input path = "vendor"/>
				</div>
				<div>
					<form:label path = "amount">Amount: </form:label>
					<form:errors class="text-danger" path = "amount"/>
					<form:input path = "amount"/>
				</div>
				<div>
					<form:label path = "description">Description: </form:label>
					<form:errors class="text-danger" path = "description"/>
					<form:input path = "description"/>
				</div>
				<input type = "submit" value = "Submit">
		</form:form>
	</div>
</body>
</html>
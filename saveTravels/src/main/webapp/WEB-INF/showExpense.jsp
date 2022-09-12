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
	<div>
		<h3><a href = "/">Go Back To Dashboard</a></h3>
	</div>
	<h1>Expense Details</h1>
	
	<h3>Expense Name: <c:out value = "${oneExpense.expenseName}"></c:out></h3>
	<h3>Expense Description: <c:out value = "${oneExpense.description}"></c:out></h3>
	<h3>Vendor: <c:out value = "${oneExpense.vendor}"></c:out></h3>
	<h3>Amount Spent: $<c:out value = "${oneExpense.amount}"></c:out></h3>
	
</body>
</html>
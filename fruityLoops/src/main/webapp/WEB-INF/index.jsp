<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Fruity Loops: Fruit Store</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

<!-- <link rel="stylesheet" type="text/css" href="/css/style.css">
	<script type="text/javascript" src="/js/app.js"></script> -->
</head>
<body>
	<h1 class="text-warning">Fruit Store</h1>
	
	<table class="table table-bordered border-warning">
		<tbody>
			<tr>
				<th scope="col">Name</th>
				<th scope="col">Price</th>
			</tr>
			<c:forEach var = "one_fruit" items = "${fruits}">
				<tr>
				<!-- one_fruit Is the Item instance that can pull out its name and price without using indexes! -->
					<td><c:out value = "${one_fruit.name}"></c:out> </td>
					<td>$ <c:out value = "${one_fruit.price}"></c:out></td>
				</tr>
			</c:forEach>
		</tbody>		
	</table>
</body>
</html>

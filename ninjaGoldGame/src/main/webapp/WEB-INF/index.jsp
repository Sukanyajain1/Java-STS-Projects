<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix= "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<h1>Your Gold: <c:out value = "${coins}"> </c:out></h1>
	<div class="row">
		<h3>Farm</h3>
		<h3>(earns 10-20 gold)</h3>
		<form action= "/points" method= "post">
		<input type="submit" class="button" name="farm" value="Find Gold!">
		</form>
	</div>
	<div class="row">
		<h3>Cave</h3>
		<h3>(earns 5-10 gold)</h3>
		<form action= "/points" method= "post">
		<input type="submit" class="button" name="cave" value="Find Gold!">
		</form>
	</div>
	<div class="row">
		<h3>House</h3>
		<h3>(earns 2-5 gold)</h3>
		<form action= "/points" method= "post">
		<input type="submit" class="button" name="house" value="Find Gold!">
		</form>
	</div>
	<div class="row">
		<h3>Quest</h3>
		<h3>(earns/takes 0-50 gold)</h3>
		<form action= "/points" method= "post">
		<input type="submit" class="button" name="quest" value="Find Gold!">
		</form>
	</div><br>
	<div class="row">
		<form action= "/reset" method= "post">
		<input type="submit" class="button" name="reset" value="Reset!">
		</form>
	</div><br>
	<h1>Activities: </h1><br>
	<div class="w-75 overflow-scroll" style = "height: 400px">
	<table>
		<tbody>
			<c:forEach var = "alert" items = "${action}">
				<tr>
				<!-- one_fruit Is the Item instance that can pull out its name and price without using indexes! -->
				<c:choose>
					<c:when test="${alert.contains('failed')}">
						<td class="text-danger"><c:out value = "${alert}"></c:out> </td>
					</c:when>
					<c:otherwise>
						<td class="text-success"><c:out value = "${alert}"></c:out> </td>
					</c:otherwise>
				</c:choose>
					
				</tr>
			</c:forEach>
		</tbody>		
	</table>
	</div>
</body>
</html>
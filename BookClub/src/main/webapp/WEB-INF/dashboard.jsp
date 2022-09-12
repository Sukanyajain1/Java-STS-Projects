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
<title>Book Club Dashboard</title>
  <!-- Bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" 
      rel="stylesheet" 
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" 
      crossorigin="anonymous">
</head>
<body>
	<div class = "container">
		<div class = "row">
			<div class = "col">
				<h1>Welcome, <c:out value = "${currentUser.userName}"></c:out> !</h1>
				<p>Books from everyone's shelves:</p>
			</div>
			<div class = "col">
				<a href = "/logout">logout</a><br>
				<a href = "/create">+ Add to my shelf</a>
				<h4><a href = "/logout" class="btn btn-danger btn-lg">Log out</a></h4>
			</div>
		</div>
		<div class = "row">
			<table class="table">
				<thead>
					<tr>
						<th scope="col">ID</th>
						<th scope="col">Title</th>
						<th scope="col">Author</th>
						<th scope="col">Posted By</th>
						<th scope="col">Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var = "book" items = "${allBooks}">
						<tr>
							<td><c:out value = "${book.id}"></c:out></td>
							<td><a href = "/show/${book.id}"><c:out value = "${book.title}"></c:out></a></td>
							<td><c:out value = "${book.author}"></c:out></td>
							<td><c:out value = "${book.user.userName}"></c:out></td>
							<td><a href = "/delete" class="btn btn-secondary btn-lg">Delete Book</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		
		
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix= "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Omikuji Form</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

</head>
<body>
	<h3>Send an Omikuji Form!</h3>
	    <form action="/omikuji/processing" method="post">
	    <div>
	        <label>Pick any number from 5 to 25:</label>
	        <input type="number" name="random_number" min="5" max="25">
	    </div>
	    <div>
	        <label>Enter the name of any city:</label>
	        <input type="text" name="city">
	    </div>
	    <div>
	        <label>Enter the name of any real person:</label>
	        <input type="text" name="person">
	    </div>
	    <div>
	        <label>Enter professional endeavor or hobby:</label>
	        <input type="text" name="hobby">
	    </div>
	    <div>
	        <label>Enter type of living thing:</label>
	        <input type="text" name="living_thing">
	    </div>
	    <div>
	        <label>Say something nice to someone:</label>
	        <input type="text" name="personal_message">
	    </div><br>
	        <p> Send and show a friend </p>
	        <button type="submit"> Send </button>
	    </form>
</body>
</html>
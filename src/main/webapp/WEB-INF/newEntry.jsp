<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>  

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Create</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<div class="container mt-5">
		<h1>Add a Name!</h1>
	<form:form method="POST" action="/bundles/new" modelAttribute="bundle" class="form-control">
   		<p>
	        <form:label path="name">New Name:</form:label>
	        <form:input path="name" class="form-control"/>
	        <form:errors path="name" class="text-danger"/>
   		</p>
   		<p>
	        <form:label path="gender">Typical Gender:</form:label>
	        <form:select path="gender" class="form-control">
	        	<option value="Male" selected>Male</option>
     		    <option value="Female" >Female</option>
       		    <option value="Neutral" >Neutral</option>
	        </form:select>
	        <form:errors path="gender" class="text-danger"/>
   		</p>
   		<p>
	        <form:label path="origin">Origin:</form:label>
	        <form:input path="origin" class="form-control"/>
	        <form:errors path="origin" class="text-danger"/>
   		</p>
   		<p>
	        <form:label path="meaning">Meaning:</form:label>
	        <form:textarea path="meaning" class="form-control"/>
	        <form:errors path="meaning" class="text-danger"/>
   		</p>
   		<form:hidden path="user" value="${userId}"></form:hidden>
   		<button type="submit">Submit</button>
  		<a href="/dashboard" class="btn btn=primary">Cancel</a>
	</form:form>
	</div>
</body>
</html>
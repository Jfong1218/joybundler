<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>  

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Edit</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<div class="container mt-5">
		<h1>Change ${bundle.name}</h1>
	<form:form method="POST" action="/bundles/${bundle.id}/edit" modelAttribute="bundle" class="form-control">
		<input type="hidden" name="_method" value="put" />
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
   		<form:hidden path="user"></form:hidden>
   		<button type="submit">Edit the name</button>
   		<a href="/dashboard" class="btn btn=primary">Cancel</a>
	</form:form>
	<form action="/bundles/${bundle.id}/delete" method="POST">
  		<input type="hidden" name="_method" value="delete" />
  		<button type="submit" class="btn btn-danger">Delete</button>
 	</form>
	</div>
</body>
</html>
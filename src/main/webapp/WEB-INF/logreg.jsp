<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>  

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Login and Registration Page</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<div class="container mt-5">
		<form:form action="/register" method="post" modelAttribute="newUser">
			<div class="form-group">
				<label >Name:</label>
				<form:input path="name" class="form-control"></form:input>
				<form:errors path="name" class="text-danger"></form:errors>
			</div>
			<div class="form-group">
				<label >Email:</label>
				<form:input path="email" class="form-control"></form:input>
				<form:errors path="email" class="text-danger"></form:errors>
			</div>
			<div class="form-group">
				<label >Password:</label>
				<form:input type="password" path="password" class="form-control"></form:input>
				<form:errors path="password" class="text-danger"></form:errors>
			</div>
			<div class="form-group">
				<label >Confirm Password:</label>
				<form:input type="password" path="confirm" class="form-control"></form:input>
				<form:errors path="confirm" class="text-danger"></form:errors>
			</div>
			<input type="submit" value="Register" class="btn btn-primary" />
		</form:form>
		<form:form action="/login" method="post" modelAttribute="newLogin">
			<div class="form-group">
				<label >Email:</label>
				<form:input path="email" class="form-control"></form:input>
				<form:errors path="email" class="text-danger"></form:errors>
			</div>
			<div class="form-group">
				<label >Password:</label>
				<form:input type="password" path="password" class="form-control"></form:input>
				<form:errors path="password" class="text-danger"></form:errors>
			</div>
			<input type="submit" value="Login" class="btn btn-primary" />
		</form:form>
	
	</div>
</body>
</html>
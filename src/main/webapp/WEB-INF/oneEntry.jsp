<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>  

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Detail Page</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<div class="container mt-5">
	<h1>${bundle.name}</h1>
	<p>(Added by ${bundle.user.name})</p>
	<h2>Gender: ${bundle.gender}</h2>
	<h2>Origin: ${bundle.origin}</h2>
	<p>Meaning: ${bundle.meaning}</p>
	<c:if test="${bundle.user.id.equals(userId)}">
		<a href="/bundles/${bundle.id}/edit">Edit</a>
	</c:if>
	</div>
	
</body>
</html>
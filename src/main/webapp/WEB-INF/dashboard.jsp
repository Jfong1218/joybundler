<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>  

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Dashboard</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<div class="container mt-5">
		<h1>Welcome, ${name} here are some name suggestions</h1>
		<p>
		<a href="/bundles/new">New Name</a>
		<a href="/logout">Logout</a>
		</p>
		<table class="table table-stripe">
			<thead>
				<tr>
					<th>Name</th>
					<th>Gender</th>
					<th>Origin</th>
				</tr>			
			</thead>
			<tbody>
				<c:forEach var="eachBundle" items="${bundleList }">
					<tr>
						<td>
							<a href="/bundles/${eachBundle.id}"><c:out value="${eachBundle.name}"></c:out></a>
						</td>
						<td>
							<c:out value="${eachBundle.gender }"></c:out>
						</td>
						<td>
							<c:out value="${eachBundle.origin }"></c:out>
						</td>
					</tr>
				</c:forEach>
			
			</tbody>
		</table>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Persons and Licenses</title>
</head>
<body>
	<h1>People:</h1>
	<div>
		<c:forEach var="person" items="${persons}">
			<p><a href="/${person.id}"><c:out value="${person.firstName}"/> <c:out value="${person.lastName}"/></a>
		</c:forEach>
	</div>
	<hr>
	<div>
	<p><a href="/persons/new">Create New Person</a></p>
	<p><a href="/licenses/new">Create New License</a></p>
	</div>
</body>
</html>
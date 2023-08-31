<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Person</title>
</head>
<body>
	<h1>New Person</h1>
	<form:form action="/persons/new/process" method="post" modelAttribute="person">
		<div style="color: red;"><form:errors path="firstName"/></div>
		<div style="color: red;"><form:errors path="lastName"/></div>	
		<p>
			<form:label path="firstName">First Name:</form:label>
			<form:input path="firstName"/>
		</p>
		<p>
			<form:label path="lastName">Last Name:</form:label>
			<form:input path="lastName"/>
		</p>
		<button class="button">Submit</button>
	</form:form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>New License</h1>
	<form:form action="/licenses/new/process" method="post" modelAttribute="license">
		<div style="color: red;"><form:errors path="number"/></div>
		<div style="color: red;"><form:errors path="expirationDate"/></div>
		<div style="color: red;"><form:errors path="state"/></div>		
		<form:select path="person">
	        <c:forEach var="onePerson" items="${persons}">
	            <!--- Each option VALUE is the id of the person --->
	            <form:option value="${onePerson.id}" path="person">
	            <!--- This is what shows to the user as the option --->
	                <c:out value="${onePerson.firstName}"/>
	                <c:out value="${onePerson.lastName}"/>
	            </form:option>
	        </c:forEach>
    	</form:select>
    	<p>
			<form:label path="number">Number:</form:label>
			<form:input type="number" path="number"/>
		</p>
		<p>
			<form:label path="expirationDate">Expiration Date:</form:label>
			<form:input type="date" path="expirationDate"/>
		</p>
		<p>
			<form:label path="state">State:</form:label>
			<form:input path="state"/>
		</p>
		<button class="button">Submit</button>
	</form:form>
</body>
</html>
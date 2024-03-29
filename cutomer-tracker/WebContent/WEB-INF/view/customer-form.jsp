<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Customer Form</title>
</head>
<body>
	<form:form action="add/customer" modelAttribute="customer" method="POST">
		<form:hidden path="id"/>
		First name: <form:input path="firstName"/>
		<br>
		Last name: <form:input path="lastName"/>
		<form:errors path="lastName" cssClass="error" />
		<br>
		Email: <form:input path="email"/>
		<form:errors path="email" cssClass="error" />
		<br>
		<input type="submit" value="Submit"/>
	</form:form>
</body>
</html>
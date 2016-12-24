<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="springForm"
	uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Flight Search</title>
<link rel="stylesheet" type="text/css" href="global.css">
<style type="text/css">
.error {
	color: red;
}
</style>
</head>
<body>
	<h1>Flight Search</h1>
	<form:form action="login" method="POST"
		commandName="flightSearchUser">
		Username: <form:input path="username" />
		<springForm:errors path="username" cssClass="error" />
		<br>
		<br> Password: <input type="password" name="password" />
		<springForm:errors path="password" cssClass="error" />
		<br>
		<br>
		<input type="submit" value="Submit">
	</form:form>
	<h3>${errorMsg}</h3>
	<a id='registerBtn' href="./register">Register</a>
</body>
</html>
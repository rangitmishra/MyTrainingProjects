<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="springForm"
	uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
body{
background-color: DarkSeaGreen;
}
h1{
color: blue;

 }
 div {
 position:absolute;
 top:30%;
 left:40%;
 }
 table{
    
    border: 1px solid black;
    border-collapse: collapse;
    background-color:BurlyWood;
    border-radius: 25px;
 }
 th, td {
    padding: 5px;
    text-align: left;
}
header {
    padding: 1em;
    color: white;
    background-color: black;
    clear: left;
    text-align: center;
}

</style>
</head>

<body>
<header>
<h1 align="center">Flight Management system</h1>
</header>
<div>
<form:form action="/Assignment10/Success" method="post" commandName="FlightData">

<table width="50%">
<th colspan="2">Add New Flight</th>
<tr>
<td>
Flight No :<td> <form:input path="flightNo" />
<springForm:errors path="flightNo" />
</tr>
<tr>
<td>
Departure :<td> <form:input path="depLoc" />
<springForm:errors path="depLoc" />
</td>
</tr>
<tr>
<td>
Arrival : <td><form:input path="arrLoc" />
<springForm:errors path="arrLoc" />
</td>
</tr>
<tr>
<td>
Valid Till(dd/mm/yyyy) :<td> <form:input path="validTill" />
<springForm:errors path="validTill" />
</td>
</tr>
<tr>
<td>
Flight Time :<td> <form:input path="flightTime" />
<springForm:errors path="flightTime" />
</td>
</tr>
<tr>
<td>
Flight Duration :<td> <form:input path="flightDuration" />
<springForm:errors path="flightDuration" />
</td>
</tr>
<tr>
<td>
Flight Fare :<td> <form:input path="fare" />
<springForm:errors path="fare" />
</td>
</tr>
<tr>
<td>
Seat Availability : <td><form:input path="seatAvailability" />
<springForm:errors path="seatAvailability" />
</td>
</tr>
<tr>
<td>
Class :<td> <form:input path="clas" />
<springForm:errors path="clas" />
</td>
</tr>
<tr>
<td colspan="2">
<input type="submit" value="ADD" />
</td>
</tr>
</table>
</form:form>
</div>
</body>
</html>
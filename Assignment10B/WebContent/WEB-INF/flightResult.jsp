<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>Spring 3 MVC Multiple Row Submit</title>
	
<style>
body{
background-color: DarkSeaGreen;
}
table {
    border-collapse: collapse;
    width: 100%;
}

table, td, th {
    border: 1px solid black;
}

th {
    text-align: left;
}
</style>
</head>
<body>
<a id='logoutBtn' href="./logout">LogOut</a>
<%-- 
    <div align="center">
        <form:form action="/Assignment10/sorting" method="post" commandName="FlightSort">
        <form:hidden path="secretValue" />
                        
                    Sort By:
                   <form:select path="orderBy">
								<form:option value="fare" label="Fare" />
								<form:option value="flightDuration" label="Duration" />
							 </form:select>
							 <input type="submit" value="Sort" />
                </form:form>
                </div> --%>
<h1>List of Flights</h1>
<h2>${errorMsg}</h2>
<table width="70%">
	<tr>
		<th>Flight No.</th>
		<th>Dep LOC</th>
		<th>Arr LOC</th>
		<th>Duration</th>
		<th>Time</th>
		<th>Fare</th>
	</tr>
	<c:forEach items="${resultList}" var="flight" varStatus="status">
		<tr>
			<td>${flight.flightNo}</td>
			<td>${flight.depLoc}</td>
			<td>${flight.arrLoc}</td>
			<td>${flight.flightDuration}</td>
			<td>${flight.flightTime}</td>
			<td>${flight.fare}</td>
		</tr>
	</c:forEach>
</table>	
<br/>
<input type="button" value="Back" onclick="javascript:history.back()"/>
</body>
</html>
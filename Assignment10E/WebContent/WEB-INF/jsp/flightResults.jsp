<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>Spring 3 MVC Multiple Row Submit</title>
</head>
<body>
<a id='logoutBtn' href="./logout">LogOut</a>
<h1>Flight Search</h1>
<h2>${errorMsg}</h2>
<table width="70%">
	<tr>
		<th>Flight No.</th>
		<th>Airline</th>
		<th>Dep LOC</th>
		<th>Arr LOC</th>
		<th>Duration</th>
		<th>Time</th>
		<th>Fare</th>
	</tr>
	<c:forEach items="${resultList}" var="flight" varStatus="status">
		<tr>
			<td>${flight.flightNo}</td>
			<td>${flight.airlineName}</td>
			<td>${flight.depLOC}</td>
			<td>${flight.arrLOC}</td>
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
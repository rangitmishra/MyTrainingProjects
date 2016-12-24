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
</style>
</head>
<body>
    <div align="center">
        <form:form action="/Assignment10/searching" method="post" commandName="FlightSearch">
            <table border="2">
                <tr>
                    <td colspan="2" align="center"><h2>Flight searching Platform</h2></td>
                </tr>
                <tr>
                    <td>Departure Location:</td>
                    <td><form:input path="depLoc" /></td>
                </tr>
                <tr>
                    <td>Arrival Location</td>
                    <td><form:input path="arrLoc" /></td>
                </tr>
                <tr>
                    <td>Journey date(dd/mm/yyyy)</td>
                    <td><form:input path="journeyDate" /></td>
                </tr>
                <tr>
                    <td>Flight Class:</td>
                    <td><form:select path="flightClass">
								<form:option value="E" label="Economy Class" />
								<form:option value="B" label="Business Class" />
							 </form:select></td>
                </tr>
                 <tr>
                    <td>Sort By:</td>
                    <td>	<form:radiobutton path="orderBy" value="fare"/>Price
							<form:radiobutton path="orderBy" value="duration"/>Duration</td>
                </tr>
                <tr>
                    <td colspan="2" align="center"><input type="submit" value="SEARCH" /></td>
                </tr>
            </table>
        </form:form>
    </div>

</body>
</html>
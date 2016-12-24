<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Insert title here</title>
<style type="text/css">
header, footer {
    padding: 1em;
    color: white;
    background-color: black;
    width:100%;
    text-align: center;
}
footer{
position:fixed ;
bottom:0px ;
}
body{
background-color: DarkGrey;}
table {
    position:fixed;
    left:40%;
    top: 30%;
}
table, th, td {

    border: 1px solid black;
    border-collapse: collapse;
    background-color:BurlyWood;
}
th, td {
    padding: 5px;
    text-align: left;
}

</style>
</head>
<body>
<header>
   <h1>Flight Ticket Booking Center</h1>
</header>

<div class="container">
<table>
<tr>
<th colspan="2">
<h2 style="color:blue;">Flight Management System</h2>
</th>
</tr>

<tr>
<td><a href="./search">SEARCH</a></td>
<td><a href="./flightadd">ADD</a></td>
</tr>
</table>
</div>

<div>
<footer>Copyright © mishraRanjeet.com</footer>
</div>

</body>
</html>
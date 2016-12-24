<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<div id="div2">
				<form action="upload" method="post">

			<table id="tb2">
				<tr>
					<th>Login</th>
				</tr>
				<tr>
					<td>USERNAME:</td>
					<td><input type="text" name="uname" /></td>
				<tr>
					<td>PASWORD:</td>
					<td><input type="text" name="pwd" /></td>
				<tr>
					<td><input type="submit" value="Login" /></td>

				</tr>

			</table>
			<input type="hidden" name="fno" value="1">
		</form>
		
	</div>

</body>
</html>
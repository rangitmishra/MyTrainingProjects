
<%
String uname=request.getParameter("uname");
String pwd=request.getParameter("pwd");

if(uname.equals("admin")&&pwd.equals("admin")) {
response.sendRedirect("./success.jsp");
}
else {
	response.sendRedirect("./fail.jsp");
	
}
%>
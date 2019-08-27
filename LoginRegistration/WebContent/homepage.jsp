<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<%

HttpSession session1=request.getSession();
if(session1.getAttribute("username")==null)
{
	response.sendRedirect("login.jsp");
	
}
	

%>




welcome
<form action="logout-servlet">
<input type="submit" value="logout">
 
</form>
</body>
</html>
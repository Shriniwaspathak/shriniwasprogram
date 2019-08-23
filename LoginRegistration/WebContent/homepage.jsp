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
response.setHeader("cache-control"," no-catch  , no-store , must-revalidate");
response.setHeader("Pragma","no-catch");
response.setHeader("Expire","no-cache");
HttpSession session1=request.getSession();
if(session1.getAttribute("userName")==null){
	System.out.println("inside :"+ session1.getAttribute("name"));
	response.sendRedirect("login.jsp");
}else{
	System.out.println("outside :"+ session1.getAttribute("name"));
}
%>

<h1>Welcome User!</h1>
<form action="logout-servlet">
<input type="submit" value="logout">
 
</form>
</body>
</html>
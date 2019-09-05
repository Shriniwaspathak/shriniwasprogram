

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reset Password</title>
</head>
<body>
	<form:form action="passwordreset" modelAttribute="forgetpassword" method="post">
 Enter OTP:
 <form:input path="otp" />
		<br />
 Enter new Password:
 <form:password path="password" />
		<input type="submit" value="submit">
	</form:form>


</body>
</html>
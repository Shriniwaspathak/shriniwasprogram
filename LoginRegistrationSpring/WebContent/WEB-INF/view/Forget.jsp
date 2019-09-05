<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>forget password  !!!</title>
</head>
<body>
<form:form action="emailSendingProcess"  modelAttribute="forgetpassword " method="post">
EmailID:
<input type="text" name="emailid" placeholder="emailid"/>

<input type="submit" value="enter">
<br />
</form:form>

</body>
</html>
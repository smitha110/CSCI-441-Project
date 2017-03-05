<jsp:useBean id="bean" class="beans.SessionBean" scope="session"/>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="styles/stockHoldings.css" type="text/css"/>
<title>Register</title>
</head>
<body>
	<h1>Registration</h1>
	<p class="alert"><%= bean.getMessage() %></p>	
	<form action="RegistrationHandlerServlet" method="post">
	
		<label>UserName:</label>
		<input type="text" name="username" ><br>
		
		<label>Password:</label>
		<input type="password" name="password" ><br>
		<label>Confirm:</label>
		<input type="password" name="confirmPassword" ><br>
		<input type="submit" value="Register"><br>
		<a href="login.jsp">Back to Login</a>
	      
	</form>
</body>
</html>
<% bean.setMessage(""); %>
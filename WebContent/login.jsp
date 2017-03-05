<jsp:useBean id="bean" class="beans.SessionBean" scope="session"/>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="styles/stockHoldings.css" type="text/css"/>
<title>Login</title>
</head>
<body>
	<h1>441 Stock Investments</h1>
	<p class="alert"><%= bean.getMessage() %></p>
   	<form action="LoginHandlerServlet">
        <label>UserName:</label>
        <input type="text" name="username" ><br>

        <label>Password:</label>
        <input type="password" name="password" ><br>
		
		<input type="submit" value="Login">
		<br>
		<a href="registration.jsp">Registration</a>

    	<br>
    </form>
</body>
</html>
<% bean.setMessage(""); %>
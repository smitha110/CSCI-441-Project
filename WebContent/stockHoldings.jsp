<jsp:useBean id="bean" class="beans.SessionBean" scope="session"/>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="styles/stockHoldings.css" type="text/css"/>
<title>Stock Holdings</title>
</head>
<body>
	<div class="mainStockView">
		<div class="stockHeader">
			<h1>Current Stock Holdings for <%= bean.getUserName() %></h1>
		</div>
		<div class="min-width div-table">
	         <div>
	             <div class="div-table-row">
	                <div class="div-table-col header">Stock Symbol</div>
	                <div class="div-table-col header">Current Share Price</div>
	                <div class="div-table-col header" >Recent Change</div>
	                <div class="div-table-col header">Last Updated</div>
	                <div class="div-table-col header">Owned Shares</div>
	                <div class="div-table-col header">Total Value</div>
	                <div class="div-table-col header">Action</div>
	                <div class="div-table-col header">Quantity</div>
	                <div class="div-table-col header oneTwentyFiveWidth">Transaction</div>
	             </div>
	          </div>
			<%= bean.getForm() %>	
		</div>

		<div class="stockFooter">
			<span class="footerSections alert"><%= bean.getMessage() %></span>
			<form action="LogOutHandlerServlet">
				<input type="submit" value="Logout">
			</form>
		</div>
	</div>
</body>
</html>
<% bean.setMessage(""); %>
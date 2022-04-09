<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="product_control.products"%>
<%@page import="com.view.viewtable"%>
<%@page import="java.util.ArrayList"%>




<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<h3 align = center>Following are the list of all information about products and companies</h3>
<table border="1", align = center>
<tr>
<td>id</td>
<td>companyname</td>
<td>productname</td>
</tr>


<%  ArrayList<products> list = new viewtable().getRecords();
for(products products:list){
%>
<tr>
<td><%= products.getId() %></td>
<td><%= products.getProductname() %></td>
<td><%= products.getCompanyname() %></td>
</tr>
<%  }


%>


</body>
</html>



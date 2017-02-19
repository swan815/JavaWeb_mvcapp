<%@page import="com.lsy.mvcapp.domain.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Object msg=request.getAttribute("message");
		if(msg!=null){
			%>
			<br>
			<font color="red"><%= msg %></font>
			<br>
			<br>
			<%
		}
		Customer customer=(Customer)request.getAttribute("customer");
	%>
	<form action="editCustomer.do" method="post" >
		<table>
			<tr>
				<td>CustomerName:</td>
				<td><input type="text" name="name"
				value="<%= customer.getName()%>"/></td>
			</tr>
			<tr>
				<td>Address:</td>
				<td><input type="text" name="address"
				value="<%= customer.getAddress()%>"/></td>
			</tr>
			<tr> 
				<td>Phone:</td>
				<td><input type="text" name="phone"
				value="<%= customer.getPhone()%>"/></td>
			</tr>
			<tr>
				<td><input type="submit" value="Add"/></td>
				<td><a href="queryCustomer.do">Back</a></td>
			</tr>
		</table>
	</form>
</body>
</html>
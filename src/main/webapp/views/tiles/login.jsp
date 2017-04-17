<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<style type="text/css">
body {
    font-size: 16px;
}
</style>
</head>

<div align="center">
<h1><Strong>Login</Strong> </h1>
<form:form modelAttribute="newCredential" action="/HotelReservation/login"  method="post" >
	<table >
	
		<tr>
			<td>User name</td>
			<td><form:input path="username" type="text" /></td>
			<td><form:errors path="username" cssStyle="color:red;"></form:errors>			
			</td>
		</tr>
		<tr>
			<td>Password</td>
			<td><form:input path="password" type="password" /></td>
			<td><form:errors path="password" cssStyle="color:red;"></form:errors>			
			</td>
		</tr>
		<tr>
			<td>
				<button>Login</button>
			</td>
		</tr>
	
	</table>
</form:form>
</div>
</html>

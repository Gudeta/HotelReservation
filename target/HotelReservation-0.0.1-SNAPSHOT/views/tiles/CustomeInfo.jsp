<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<div>
<h3><strong>* * * Maharishi Invincible Hotel * * *</strong></h3>
<form:form modelAttribute="customer" action="/HotelReservation/reservation/roomselection"  method="post" >
	<table >
	
		<tr>
			<td>First Name</td>
			<td><form:input path="fName" type="text" /></td>
			<td><form:errors path="fName" cssStyle="color:red;"></form:errors>			
			</td>
		</tr>
		<tr>
			<td>Last Name</td>
			<td><form:input path="lName" type="text" /></td>
			<td><form:errors path="lName" cssStyle="color:red;"></form:errors>			
			</td>
		</tr>
		<tr>
			<td>Email </td>
			<td><form:input path="email" type="text" /></td>
			<td><form:errors path="email" cssStyle="color:red;"></form:errors>			
			</td>
		</tr>
		<tr>
			<td>Phone number</td>
			<td><form:input path="phoneNumber" type="text" /></td>
			<td><form:errors path="phoneNumber" cssStyle="color:red;"></form:errors>			
			</td>
		</tr>
		<tr>
			<td>
				<button>Save</button>
			</td>
		</tr>
	</table>
</form:form>
</div>
</html>
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
<div align="center">
<h3><b>Check out Page </b></h3>
<table class="table table-hover">
 <thead>
	<tr>
		<td>Customer F.Name</td>
		<td>Customer Last Name</td>
		<td>Check In Date</td>
		<td>Check Out Date</td>	
		<td>Cost</td>
		<td>&nbsp;</td>
	</tr>
	</thead>
	<c:forEach var="reservation" items="${allreservation}">
	   <tbody>
		<tr>
			<td>${reservation.customer.fName}</td>
			<td>${reservation.customer.lName}</td>
			<td>${reservation.checkInDate}</td>
			<td>${reservation.checkOutDate}</td>
			<td>${reservation.totalPrice}</td>					
			<td><a href="<spring:url value="/reservationstaff/checkout/${reservation.reservationId}"/>">Checkout</a>

		</tr>
		</tbody>
	</c:forEach>
</table>
</div>
</html>
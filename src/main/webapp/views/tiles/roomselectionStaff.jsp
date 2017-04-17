<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html lang="en">
<head>
	<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>jQuery UI Datepicker - Default functionality</title>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script>
  $( function() {
    $( "#datepicker" ).datepicker();
  } );
  </script>
<style type="text/css">
.bs-example {
	margin: 20px;
}
</style>
</head>
<div>
<h3><b>* * * Maharishi Invincible Hotel * * *</b></h3>
	<form:form modelAttribute="reservation" action="/HotelReservation/reservationstaff/save"  method="post" >
	<table >
		<tr>
			<td>Queen</td>
			<td>
				<form:select path="numberQueen" >
                <c:forEach var="qty" items="${queenlist}">
                    <form:option value="${qty}"><c:out value="${qty}"/></form:option>
                </c:forEach>
                </form:select>
			</td>
		</tr>
		<tr>
			<td>King</td>
			<td>
				<form:select path="numberKing" >
                <c:forEach var="qty" items="${kinglist}">
                    <form:option value="${qty}"><c:out value="${qty}"/></form:option>
                </c:forEach>
                </form:select>
			</td>
		</tr>
		<tr>
			<td>Double</td>
			<td>
				<form:select path="numberDouble" >
                <c:forEach var="qty" items="${doublelist}">
                    <form:option value="${qty}"><c:out value="${qty}"/></form:option>
                </c:forEach>
                </form:select>
			</td>
		</tr>
		<tr>
			<td>Single</td>
			<td>
				<form:select path="numberSingle" >
                <c:forEach var="qty" items="${singlelist}">
                    <form:option value="${qty}"><c:out value="${qty}"/></form:option>
                </c:forEach>
                </form:select>
			</td>
		</tr>
		<tr>
		<td>Check In Date: </td>
		<td> <form:input type="date" path="checkInDate" name="checkInDate" /></td>
		</tr>
		<tr>
		<td>Check Out Date: </td>
		<td> <form:input type="date" path="checkOutDate" name="checkInDate" /></td>
		</tr>
		<tr>
		<td>Select Discount: </td>
			<td>
			<form:select path="discountType" >
                    <form:option value="Public"><c:out value="Default"/></form:option>
                    <form:option value="Veteran"><c:out value="Veteran"/></form:option>
                    <form:option value="Staff"><c:out value="Staff"/></form:option>
            </form:select>
            </td>
		</tr>
		<tr>
			<td>
				<button>Go</button>
			</td>
		</tr>
	
	</table>
</form:form>
</div>
</html>


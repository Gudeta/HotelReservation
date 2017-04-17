<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<div>
<h3><strong>* * * Maharishi Invincible Hotel * * *</strong></h3>
<h4> * * * Summary of your Reservation * * *</h4>
<form:form  action="/HotelReservation/reservation/finish"  method="post" >
<table class="table table-hover">
	<c:forEach var="info" items="${listinfo}">
		<tr>
			<td>${info}</td>
		</tr>
	</c:forEach>
</table>
	<table >
		<tr>
			<td>
				<button>Finish</button>
			</td>
		</tr>
	</table>
</form:form>
</div>
</html>
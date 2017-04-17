<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>
<style type="text/css">
.bs-example {
	margin: 40px;
}
</style>
</head>
<div>
<h1><b>* * * Maharishi Invincible Hotel * * *</b></h1>
	<form:form modelAttribute="sbranch" action="/HotelReservation/reservation/showCustomerform"  method="post" >
	<table >
		<tr>
			<td>Hotel Branch</td>
			<td>
				<form:select path="branchId" >
                <c:forEach var="branch" items="${branchList}">
                    <form:option value="${branch.branchId}"><c:out value="${branch.branchName}"/></form:option>
                </c:forEach>
                </form:select>
			</td>
		</tr>
		
		<tr>
			<td>
				<input type = "submit" name = "Reserve" value="Reserve"/>
			</td>
		</tr>
		<tr>
			<td>
     			<input type = "submit" name = "Login" value="Login"/> 
			</td>
		</tr>
	
	</table>
</form:form>
</div>
</html>


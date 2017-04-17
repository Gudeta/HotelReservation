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
<h1><strong>Edit Room Form</strong></h1>
<form:form modelAttribute="editRoom" action="/HotelReservation/room/edit"  method="post" >
	<table >
	
		<tr>
			<td>Room Number</td>
			<td><form:input path="roomNumber" type="text" value="${oldRoom.roomNumber}"/></td>
			<td><form:errors path="roomNumber" cssStyle="color:red;"></form:errors>			
			</td>
		</tr>
		<%-- <tr>
			<td>RoomType Name</td>
			<td><form:input path="room.roomtypeName" type="text" value="${editRoom.RoomtypeName}" /></td>
			<td><form:errors path="room.roomtypeName" cssStyle="color:red;"></form:errors>			
			</td>
		</tr>
		 --%>
		<tr>
			<td>RoomType Name</td>
				<td><select name="roomtypeName"> 
				<option value="Single"
							<c:if test="${oldRoom.roomtype.roomtypeName=='Single'}">selected</c:if>> single</option>
						<option value="Double"
							<c:if test="${oldRoom.roomtype.roomtypeName=='Double'}">selected</c:if>>double</option>
						<option value="Queen"
							<c:if test="${oldRoom.roomtype.roomtypeName=='Queen'}">selected</c:if>>queen</option>
						<option value="King"
							<c:if test="${oldRoom.roomtype.roomtypeName=='King'}">selected</c:if>>king</option>
																		
				</select></td>
				<td><form:errors path="roomtypeName" cssStyle="color:red;"></form:errors></td>

		</tr>
		<tr>
			<td>
				<button>Save</button>
			</td>
		</tr>
	
	</table>
</form:form>
</div>
<div align="left">
<h1>Room List </h1>
<table class="table table-hover">
 <thead>
	<tr>
		<td>Room Id</td>
		<td>Room Number</td>
		<td>Room Type</td>
		<td>Room Branch</td>
				<td>&nbsp;</td>

	</tr>
	</thead>
	<c:forEach var="room" items="${roomlist}">
	   <tbody>
		<tr>
			<td>${room.id}</td>
			<td>${room.roomNumber}</td>	
			<td>${room.branch.branchName}</td>	
			<td>${room.roomtype.roomtypeName}</td>							
			<td><a href="<spring:url value="/room/edit/${room.id}"/>">Edit</a> | <a
				href="<spring:url value="/room/delete/${room.id}"/>">Delete</a></td>

		</tr>
		</tbody>
	</c:forEach>
</table>
</div>
</html>

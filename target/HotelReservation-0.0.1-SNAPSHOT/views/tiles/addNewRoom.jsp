<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<style type="text/css">
body {
	font-size: 16px;
}
</style>
</head>
<div align="center">
	<h2>
		<b><i>Add New Room</i></b>
	</h2>
	<form:form modelAttribute="newRoom" action="/HotelReservation/room/add"
		method="post">
		<table>
			<tr>
				<td>Hotel Branch</td>
				<td><form:select path="branchId">
				<form:option value="" label="--- Select Branch ---" />
						<c:forEach var="branch" items="${branchList}">
							<form:option value="${branch.branchId}">
								<c:out value="${branch.branchName}" />
							</form:option>
						</c:forEach>
					</form:select></td>
			</tr>

			<tr>
				<td>Room Number</td>
				<td><form:input path="roomNumber" type="text" /></td>
				<td><form:errors path="roomNumber" cssStyle="color:red;"></form:errors>
				</td>
			</tr>
			<%-- <tr>
			<td>RoomType Name</td>
			<td><form:input path="roomtype.roomtypeName" type="text" /></td>
			<td><form:errors path="roomtype.roomtypeName" cssStyle="color:red;"></form:errors>			
			</td>
		</tr> --%>

			<tr>
				<td>RoomType Name</td>
				<td><form:select path="roomtypeName">
				<form:option value="" label="--- Select Room Type ---" />
						<form:option value="King">
							<c:out value="King" />
						</form:option>
						<form:option value="Queen">
							<c:out value="Queen" />
						</form:option>
						<form:option value="Double">
							<c:out value="Double" />
						</form:option>
						<form:option value="Single">
							<c:out value="Single" />
						</form:option>
					</form:select></td>
			</tr>

			<%-- <tr>
			<td>RoomType Name</td>
				<td><select name="roomtypeName"> 
				<option value="Single"
							<c:if test="${editEntry.room.roomtypeName=='Single'}">selected</c:if>> single</option>
						<option value="Double"
							<c:if test="${editEntry.room.roomtypeName=='Double'}">selected</c:if>>double</option>
						<option value="Queen"
							<c:if test="${editEntry.room.roomtypeName=='Queen'}">selected</c:if>>queen</option>
						<option value="King"
							<c:if test="${editEntry.room.roomtypeName=='King'}">selected</c:if>>king</option>
																		
				</select></td>
				<td><form:errors path="roomtypeName" cssStyle="color:red;"></form:errors></td>

		</tr> --%>
			<%-- 		
		<tr>
			<td>RoomType price</td>
			<td><form:input path="roomtypeprice" type="text" /></td>
			<td><form:errors path="roomtypeprice" cssStyle="color:red;"></form:errors>			
			</td>
		</tr> --%>

			<tr>
				<td>
					<button>Save</button>
				</td>
			</tr>

		</table>
	</form:form>
</div>
<div align="left">
	<h3><b><u>* * * Room Lists * * *</u></b></h3>
	<table class="table table-hover">
		<thead>
			<tr>
				<td><b>Room Id</b></td>
				<td><b>Room Branch</b></td>
				<td><b>Room Number</b></td>
				<td><b>Room Type</b></td>
				<td>&nbsp;</td>

			</tr>
		</thead>
		<c:forEach var="room" items="${roomlist}">
			<tbody>
				<tr>
					<td>${room.id}</td>
					<td>${room.branch.branchName}</td>
					<td>${room.roomNumber}</td>
					<td>${room.roomtype.roomtypeName}</td>
					<td><a href="<spring:url value="/room/edit/${room.id}"/>">Edit</a>
						| <a href="<spring:url value="/room/delete/${room.id}"/>">Delete</a></td>

				</tr>
			</tbody>
		</c:forEach>
	</table>
</div>
</html>

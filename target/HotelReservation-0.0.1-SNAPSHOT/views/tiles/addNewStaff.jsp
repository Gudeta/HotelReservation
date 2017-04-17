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
<h2><b><i>Add New Staff</i></b></h2>
<form:form modelAttribute="newStaff" action="/HotelReservation/staff/add"  method="post" >
	<table >
	
		<tr>
			<td>Staff First Name</td>
			<td><form:input path="staffFirstName" type="text" /></td>
			<td><form:errors path="staffFirstName" cssStyle="color:red;"></form:errors>			
			</td>
		</tr>
		<tr>
			<td>Staff Last Name</td>
			<td><form:input path="staffLastName" type="text" /></td>
			<td><form:errors path="staffLastName" cssStyle="color:red;"></form:errors>			
			</td>
		</tr>
		<tr>
			<td>Ssn </td>
			<td><form:input path="staffSsn" type="text" /></td>
			<td><form:errors path="staffSsn" cssStyle="color:red;"></form:errors>			
			</td>
		</tr>
		<tr>
			<td>Email</td>
			<td><form:input path="staffEmail" type="text" /></td>
			<td><form:errors path="staffEmail" cssStyle="color:red;"></form:errors>			
			</td>
		</tr>
		<tr>
			<td>Phone Number</td>
			<td><form:input path="staffPhoneNumber" type="text" /></td>
			<td><form:errors path="staffPhoneNumber" cssStyle="color:red;"></form:errors>			
			</td>
		</tr>
			
		<tr>
		
				<td>Gender</td>
				<td><select name="staffGender"> 
						<option value="Male"
							<c:if test="${editEntry.staffGender=='Male'}">selected</c:if>>M</option>
						<option value="Female"
							<c:if test="${editEntry.staffGender=='Female'}">selected</c:if>>F</option>
																		
				</select></td>
				<td><form:errors path="staffGender" cssStyle="color:red;"></form:errors></td>

		</tr>
		<tr>
		
				<td>Role</td>
				<td><select name="role"> 
						<option value="Admin">Admin</option>
						<option value="Staff">Staff</option>
																		
				</select></td>
				<td><form:errors path="role" cssStyle="color:red;"></form:errors></td>

		</tr>
		
		<tr>
			<td>UserName</td>
			<td><form:input path="staffUserName" type="text" /></td>
			<td><form:errors path="staffUserName" cssStyle="color:red;"></form:errors>			
			</td>
		</tr>
		<tr>
			<td>Password</td>
			<td><form:input path="staffPassword" type="password" /></td>
			<td><form:errors path="staffPassword" cssStyle="color:red;"></form:errors>			
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
<div align="left">
<h3><b><u>* * * Staff Lists * * *</u></b></h3>
<table class="table table-hover">
 <thead>
	<tr>
		<td><b>Staff Id</b></td>
		<td><b>Staff First Name</b></td>
		<td><b>Staff Last Name</b></td>
		<td><b>Ssn #</b></td>
		<td><b>Email</b></td>	
		<td><b>Phone Number</b></td>
		<td><b>Gender</b></td>	
		<td><b>User Name</b></td>
		<td><b>Password </b></td>
		<td>&nbsp;</td>

	</tr>
	</thead>
	<c:forEach var="staff" items="${stafflist}">
	   <tbody>
		<tr>
			<td>${staff.staffId}</td>
			<td>${staff.staffFirstName}</td>
			<td>${staff.staffLastName}</td>
			<td>${staff.staffSsn}</td>
			<td>${staff.staffEmail}</td>
			<td>${staff.staffPhoneNumber}</td>
			<td>${staff.staffGender}</td>
			<td>${staff.staffUserName}</td>
			<td>${staff.staffPassword}</td>
				
			<td><a href="<spring:url value="/staff/edit/${staff.staffId}"/>">Edit</a> | <a
				href="<spring:url value="/staff/delete/${staff.staffId}"/>">Delete</a></td>

		</tr>
		</tbody>
	</c:forEach>
</table>
</div>
</html>

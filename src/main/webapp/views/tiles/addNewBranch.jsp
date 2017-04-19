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
<h2><b><i>Add New Branch</i></b></h2>
<form:form modelAttribute="newBranch" action="/HotelReservation/branch/add"  method="post" >
	<table >
	
		<tr>
			<td>Branch Name</td>
			<td><form:input path="branchName" type="text" /></td>
			<td><form:errors path="branchName" cssStyle="color:red;"></form:errors>			
			</td>
		</tr>
		<tr>
			<td>House Number</td>
			<td><form:input path="location.houseNumber" type="text" /></td>
			<td><form:errors path="location.houseNumber" cssStyle="color:red;"></form:errors>			
			</td>
		</tr>
		<tr>
			<td>Street</td>
			<td><form:input path="location.street" type="text" /></td>
			<td><form:errors path="location.street" cssStyle="color:red;"></form:errors>			
			</td>
		</tr>
		<tr>
			<td>City</td>
			<td><form:input path="location.city" type="text" /></td>
			<td><form:errors path="location.city" cssStyle="color:red;"></form:errors>			
			</td>
		</tr>
		<tr>
			<td>State</td>
			<td><form:input path="location.state" type="text" /></td>
			<td><form:errors path="location.state" cssStyle="color:red;"></form:errors>			
			</td>
		</tr>
		<tr>
			<td>Zip Code</td>
			<td><form:input path="location.zipcode" type="text" /></td>
			<td><form:errors path="location.zipcode" cssStyle="color:red;"></form:errors>			
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
<h3><b><u>* * * Branch Lists * * *</u></b></h3>
<table class="table table-hover">
 <thead>
	<tr>
		<td><b>Branch Id</b></td>
		<td><b>Branch Name</b></td>
		<td><b>House Number</b></td>
		<td><b>Street</b></td>	
		<td><b>City</b></td>
		<td><b>State</b></td>	
		<td><b>Zip Code</b></td>
		<td>&nbsp;</td>
	</tr>
	</thead>
	<c:forEach var="branch" items="${branchlist}">
	   <tbody>
		<tr>
			<td>${branch.branchId}</td>
			<td>${branch.branchName}</td>
			<td>${branch.location.houseNumber}</td>
			<td>${branch.location.street}</td>
			<td>${branch.location.city}</td>
			<td>${branch.location.state}</td>
			<td>${branch.location.zipcode}</td>
					
			<td><a href="<spring:url value="/branch/edit/${branch.branchId}"/>">Edit</a> | <a
				href="<spring:url value="/branch/delete/${branch.branchId}"/>">Delete</a></td>

		</tr>
		</tbody>
	</c:forEach>
</table>
</div>
</html>

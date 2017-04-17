<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
</head>
<div class="jumbotron">
<h1><b><center><marquee>Welcome to Manager Page !!</marquee></center></b></h1>
	
</div>
<div align="right">
	<security:authorize access="isAnonymous()">
		<a href="<spring:url value="/login"/>"> login</a>
	</security:authorize>
	<security:authorize access="isAuthenticated()">
		<a href="<spring:url value="/logout"/>"><font color="red"> logout(<security:authentication
				property="principal.username" />)</font>
		</a>
	</security:authorize>
</div>
</html>
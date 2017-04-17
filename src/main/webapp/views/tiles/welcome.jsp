<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
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
	margin: 20px;
}

.center
{
	height: 100%;
	width: 60%;
	float:right;
}
</style>
</head>



<body>
	<div class="bs-example">
		<nav id="myNavbar" class="navbar navbar-default" role="navigation">
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">


				<security:authorize access="hasRole('ROLE_ADMIN')">
					<ul class="nav navbar-nav">

						<li>
							<form action="<spring:url value="/branch/add"/>" method="get">
								<input type="submit" value="CRUD Branch" />
							</form>
						</li>
										
						
						<li><a href="#" data-toggle="dropdown"
							class="dropdown-toggle">CRUD UserProfile <b class="caret"></b></a>
							<ul class="dropdown-menu">
								<li><form action="<spring:url value="/faculty/add"/>"
										method="get">
										<input type="submit" value="CRUD Faculty" />
									</form></li>
								<li><form action="<spring:url value="/student/add"/>" method="get">
										<input type="submit" value="CRUD Students" />
									</form></li>
							</ul></li>
					</ul>
				</security:authorize>
			</div>



			<security:authorize access="hasRole('ROLE_STUDENT')">
				<ul class="nav navbar-nav">
					<li>
						<form action="<spring:url value="/schedule/view/1"/>" method="get">
							<input type="submit" value="View Schedule" />
						</form>
					</li>
					<li>
						<form action="<spring:url value=""/>" method="get">
							<input type="submit" value="Register for a Section" />
						</form>
					</li>
				</ul>
			</security:authorize>

			<security:authorize access="hasRole('ROLE_FACULTY')">
				<ul class="nav navbar-nav">
					<li>
						<form action="<spring:url value="/schedule/view/1"/>" method="get">
							<input type="submit" value="View Schedule" />
						</form>
					</li>
		<li>
						<form action="<spring:url value=""/>" method="get">
							<input type="submit" value="View Profile" />
						</form>
					</li>
				</ul>
			</security:authorize>
		</nav>
		

	</div>
	<div class="center"></div>
	<P>PAAAAA</P>
</body>
</html>


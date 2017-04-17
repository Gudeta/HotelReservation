<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.left
{
	height: 100%;
	width: 48%;
	float:left;
}
ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    width: 200px;
    font-color:white;
    background-color: #f1f1f1;
}
a { outline: none; 
	font-family:Construthinvism;}

li a {
    display: block;
    color: #000;
    padding: 8px 16px;
    text-decoration: none;
}

/* Change the link color on hover */
li a:hover, a:active {
    background-color: #555;
    color: white;
}
</style>
</head>
<body>
<div class="left">
<ul>
  <li><a href="/HotelReservation/branch/add"><b>Add Branch</b></a></li>
  <li><a href="/HotelReservation/room/add"><b>Add Room</b></a></li>
  <li><a href="/HotelReservation/staff/add"><b>Add Staff</b></a></li>
</ul>
</div>
</body>
</html>
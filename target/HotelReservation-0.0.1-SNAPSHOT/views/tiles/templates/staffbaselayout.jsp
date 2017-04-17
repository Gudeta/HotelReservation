<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>


<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title><tiles:insertAttribute name="title" /></title>
<tiles:insertAttribute name="css"/>
<tiles:insertAttribute name="js"/>
</head>
<style>
	#maincanvass{
		margin-top:20px;
		margin-left:50px;
		margin-right:50px;
	}
	.header{
		 /* position: absolute; */
	    margin-left: 0px;
	    margin-top: 0px;
	    height: 0px;
	    width:100%;
	}
	.sider{
		float:left;
		margin-top: 92px;
		width:10%;
		height:420px;
		color: black;
	}
	.middler{
		margin-left: 72px;
		height:420px;
		margin-top: 92px;
		width:76%;
		color: green;
	}
	.footer{
		/*  position: absolute; */
	    left: 0px;
	    top: 450px;
	    height: 20px;
	    width:100%;
	    color:black;
	}
	.navigator{
		margin-left: 0px;
	    height: 40px;
	    width:100%;
	    color: powder-blue;
	}
	.tagline{
		margin-left: 0px;
	    height: 10px;
	    width:100%;
	    color: red;
	}
</style>
<body>
<div>

	<div class="navigator"><tiles:insertAttribute name="navigation" /></div>
	<div class="sider"><tiles:insertAttribute name="side" /></div>
	<div class="middler"><tiles:insertAttribute name="body" /></div>
	<div class="tagline"><tiles:insertAttribute name="tagline" /></div>
	<div class="footer"><tiles:insertAttribute name="footer" /></div>
	<div></div>
</div>
	<%-- <div id="maincanvass">
		<tiles:insertAttribute name="navigation" />
		<tiles:insertAttribute name="heading" />
		<tiles:insertAttribute name="tagline" />
		<tiles:insertAttribute name="body" />
		<tiles:insertAttribute name="side" />
	</div>
	<tiles:insertAttribute name="footer" /> --%>
	
</body>
</html>

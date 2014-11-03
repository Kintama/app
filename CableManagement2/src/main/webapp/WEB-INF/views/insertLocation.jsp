<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page session="false"%>
<html>
<head>
	<title>insert Cable</title>
	<link rel="stylesheet" type="text/css" href="${rootURL}resources/css/style.css"> 
	<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
</head>
<body>
	<header>
		<div class="inner">  
				<img src="<c:url value="${rootURL}resources/img/Logo.png" />" alt="YourFault" width="100px">
		</div>
	</header>
	<div algin="center">
		<div>
			<form:form method="post" action="insertLocation" modelAttribute="location">
			<table id="Kabeltabelle" cellspacing="0" cellpadding="0">
				<tbody>
					<tr>
						<td>Name</td>
						<td><form:input path="name" /></td>
					</tr>
				</tbody>
			</table>
		</div>
		<input type="submit" value="Insert Location"/>
		</form:form>
	</div>

	<script type="text/javascript" src="<c:url value="/resources/js/lib/jquery-1.7.1.min.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/lib/jquery-ui-1.8.17.custom.min.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/lib/jquery-datatables-1.9.0.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/lib/log4javascript.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/script.js" />"></script>
	
</body>
</html>

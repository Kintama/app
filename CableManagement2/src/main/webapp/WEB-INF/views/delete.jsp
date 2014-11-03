<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page session="false"%>
<html>
<head>
	<title>Delete</title>
	<link rel="stylesheet" type="text/css" href="${rootURL}resources/css/style.css"> 
	<!-- <meta http-equiv="content-type" content="text/html; charset=UTF-8" />-->
</head>
<body>
	<header>
		<div class="inner">  
			<img src="<c:url value="${rootURL}resources/img/Logo.png" />" alt="YourFault" width="100px">
		</div>
	</header>
	<div>
		<c:out value="${res.id}"></c:out>
			<article>
				<form:form method="post" action="delete" modelAttribute="location">
					<form:input path="name" />
					<input type="submit" value="Delete" />
				</form:form>
			</article>
	</div>

	<script type="text/javascript" src="<c:url value="/resources/js/lib/jquery-1.7.1.min.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/lib/jquery-ui-1.8.17.custom.min.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/lib/jquery-datatables-1.9.0.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/lib/log4javascript.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/script.js" />"></script>
	
</body>
</html>
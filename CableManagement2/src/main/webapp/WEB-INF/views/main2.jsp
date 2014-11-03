<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page session="false"%>
<html>
<head>
	<title>Suchen</title>
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
			<c:choose>
				<c:when test="${fn:length(RESULT)>0}">
					<div>
						<table id="Kabeltabelle" cellspacing="0" cellpadding="0">
						<thead>
							<tr>
								<td>Id</td>
								<td>Name</td>
								<td>Type</td>
								<td>Länge</td>
								<td>Ort</td>
								<td>Switch</td>
								<td>Port</td>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${RESULT}" var="res">
								<tr>
									<td><c:out value="${res.id}"></c:out></td>
									<td><c:out value="${res.name}"></c:out></td>
									<td><c:out value="${res.type}"></c:out></td>
									<td><c:out value="${res.length}"></c:out></td>
									<td><c:out value="${res.location.name}"></c:out></td>
									<td><c:out value="${res.modem}"></c:out></td>
									<td><c:out value="${res.port}"></c:out></td>
								</tr>
							</c:forEach>
						</tbody>
						</table>
					</div>
				</c:when>
			<c:otherwise>
			<article>
				<form:form method="post" action="main2" modelAttribute="cable">
					<form:input path="name" />
					<input type="submit" value="Search" />
				</form:form>
<%-- 				<form:form method="post" action="main" modelAttribute="cable"> --%>
<%-- 					<form:input path="name" /> --%>
<!-- 					<input type="submit" value="Suche nach Name" /> -->
<%-- 				</form:form> --%>
			</article>
			</c:otherwise>
		</c:choose>
	</div>

	<script type="text/javascript" src="<c:url value="/resources/js/lib/jquery-1.7.1.min.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/lib/jquery-ui-1.8.17.custom.min.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/lib/jquery-datatables-1.9.0.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/lib/log4javascript.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/script.js" />"></script>
	
</body>
</html>
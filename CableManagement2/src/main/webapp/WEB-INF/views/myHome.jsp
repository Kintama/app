<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!-- tobe able to use form:form -->
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!-- tobe able to use fn:length -->
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
	<meta http-equiv="content-type" content="text/html; charset=UTF-8" />

</head>
<body>
	<h1>Hello myHome!</h1>

<c:out value="${res.id}"></c:out>
	<c:choose>
		<c:when test="${fn:length(RESULT)>0}">
			<c:forEach items="${RESULT}" var="res">
				<c:out value="${res.id}"></c:out>
				<c:out value="${res.length}"></c:out>
				<c:out value="${res.type}"></c:out>
				<c:out value="${res.location.name}"></c:out>
				<br>
			</c:forEach>
		</c:when>
		<c:otherwise>
			<form:form method="post" action="myHome" modelAttribute="location">
				<form:label path="id">Id</form:label>
				<form:input path="id" />
				<input type="submit" value="Search" />
			</form:form>
		</c:otherwise>
	</c:choose>

</body>
</html>


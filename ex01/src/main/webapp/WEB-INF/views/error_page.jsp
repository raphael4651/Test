<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	<meta charset="utf-8">
</head>
<body>
<h2>${exception.getMessage() }</h2>
<ul>
	<c:forEach var="stack" items="${exception.getStackTrace() }">
		<li>${stack }</li>
	</c:forEach>
</ul>
</body>
</html>

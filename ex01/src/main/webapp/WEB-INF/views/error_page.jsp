<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>error_page</title>
	<meta charset="UTF-8">
</head>
<body>
	<h4>${exception.getMessage() }</h4>
	
	<ul>
		<c:forEach var="stack" items="${exception.getStackTrace() }" >
			<li>${stack }</li>
		</c:forEach>
		<!-- forEach구문
			 items에서 꺼내서 stack에 대입, ${stack}로 출력  -->
	</ul> 
</body>
</html>

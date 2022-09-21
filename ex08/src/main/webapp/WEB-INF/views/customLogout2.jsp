<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>로그아웃 페이지</h1>

<form method="post" action="/customLogout">	
	<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }">
	<button>로그아웃</button>
</form>

</body>
</html>

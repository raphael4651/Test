<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>Custom 로그인 페이지</h1>
<h2>${error}</h2>
<h2>${logout}</h2>

<form method="post" action="/login">
	<div>
		<input type="text" name="username" value="admin90">
	</div>
	<div>
		<input type="password" name="password" value="pw90">
	</div>
	<div>
		<input type="checkbox" name="remember-me"> Remember Me
	</div>
	<div>
		<input type="submit" value="로그인">
	</div>
	<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }">
</form>

</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>	
</head>
<body>
<h1>홈</h1>
<form role='form' action="/board/list" post="post">
	<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }">
	<button>리스트</button>
</form>

<script src="https://code.jquery.com/jquery-3.6.1.js" integrity="sha256-3zlB5s2uwoUzrXK3BT7AX3FyvojsraNFxCc2vC/7pNI=" crossorigin="anonymous"></script>
<script>
$(document).ready(function(){
	var formObj=$("form[role='form']");
	formObj.submit();
});

//self.location="/board/list";
</script>

</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ include file="includes/header.jsp" %>
<html>
<head>
	<title>우리동네</title>
</head>
<body>
<div class="wrap_body_index">
	<div class="body_content_index">
		<sec:authorize access="isAnonymous()">
		<h1>환영합니다.</h1>
		<span>우리동네만의 커뮤니티에 오신걸 환영합니다.<br>
		더욱 많은 기능을 사용하기 위해 로그인, 회원가입을 부탁드립니다.
		</span>
		<button onclick="location.href='/customLogin'" class="btn btn-primary">로그인</button>
		</sec:authorize>
		
		<sec:authorize access="isAuthenticated()">
		<span><sec:authentication property="principal.user.userName"/>님 환영합니다.<br></span>
		<span>우리동네만의 커뮤니티에 오신걸 환영합니다.<br>
		다양한 게시판을 통해서 우리동네 활동을 해보세요!.
		</span>
		</sec:authorize>
	</div>
</div>
</body>
</html>

<%@ include file="includes/footer.jsp" %>
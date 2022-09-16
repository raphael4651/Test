<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../includes/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="/board/insert" method="post">
		<div class="input_wrap">
			<label>제목</label>
			<input name="tradeTitle">
		</div>
		<div class="input_wrap">
			<label>내용</label>
			<input name="tradeContent">
		</div>
		<div class="input_wrap">
			<label>작성자</label>
			<input name="tradeWriter">
		</div>		
		<button class="btn">등록</button>
	</form>
</body>
</html>
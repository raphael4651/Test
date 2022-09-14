<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>ex04</title>
	<meta charset="UTF-8">
</head>
<body>
	<h2>SAMPLEDTO ${sampleDTO}</h2>
	<!-- Model 에서의 이름은 SampleDTO dto 이나 JSP에서는 앞을 소문자로 변경하여 사용
		JSP : sampleDTO
		모델 내부 : dto
	 -->
	<h2>PAGE ${page}</h2>
</body>
</html>

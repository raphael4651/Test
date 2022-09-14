<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>exUpload</title>
	<meta charset="UTF-8">
</head>
<body>
	<form action="/sample/exUploadPost" method="post" enctype="multipart/form-data">
	<!-- fileUpload 처리시에 enctype="multipart/form-data" 필수 -->
		<div>
			<input type="file" name="files">
		</div>
		<div>
			<input type="file" name="files">
		</div>
		<div>
			<input type="file" name="files">
		</div>
		<div>
			<input type="file" name="files">
		</div>
		<div>
			<input type="file" name="files">
		</div>
		<div>
			<input type="submit">
		</div>
	</form>
</body>
</html>

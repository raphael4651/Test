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
<div class="jumbotron">

	<div class="row">
	    <div class="col-lg-12">
	        <h1 class="page-header">게시판</h1>
	    </div>
	    <!-- /.col-lg-12 -->
	</div>
	
	<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">
            <!-- /.panel-heading -->            
            <div class="panel-body">            	
				<form action="/board/insert" method="post">
					<div class="mb-3">
						<label class="form-label">제목</label>
						<input name="tradeTitle" class="form-control">
					</div>
					<div class="mb-3">
						<label class="form-label">내용</label>
						<textarea class="form-control" rows="3" name="tradeContent"></textarea>
					</div>
					<div class="mb-3">
						<label class="form-label">작성자</label>
						<input name="tradeWriter" class="form-control">
					</div>		
					<button type="submit" class="btn btn-primary">등록</button>
					<button type="submit" class="btn btn-secondary">취소</button>
				</form>	
            <!-- /.panel-body -->
        <!-- /.panel -->
    </div>
    <!-- /.col-lg-12 -->
</div>
<!-- /.row -->
</div>
</div>
</div>
            
</body>
</html>
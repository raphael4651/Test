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

	<div class="row card">
	    <div class="col-lg-12 card-body">
	        <h1 class="card-title">공지사항 글쓰기</h1>
	    </div>
	    <!-- /.col-lg-12 -->
	</div>
	
	<div class="row card">
    <div class="col-lg-12">
        <div class="card-body">
            <!-- /.panel-heading -->            
            <div class="card-body">            	
				<form role="form" action="/board/insertNotice" method="post">
				
					<div class="mb-3">
						<label class="form-group">제목</label>
						<input name="noticeTitle" class="form-control">
					</div>
					<div class="mb-3">
						<label class="form-group">내용</label>
						<textarea class="form-control" rows="3" name="noticeContent"></textarea>
					</div>
					<div class="mb-3">
						<label class="form-group">작성자</label>
						<input name="noticeWriter" class="form-control">
					</div>		
					<button type="submit" class="btn btn-primary">등록</button>
					<button type="button" class="btn btn-secondary">취소</button>
					
				</form>	
            <!-- /.panel-body -->
    		</div>
        <!-- /.panel -->
		</div>
    <!-- /.col-lg-12 -->
	</div>
	<!-- /.row -->
	</div>
</div>
            
</body>
</html>










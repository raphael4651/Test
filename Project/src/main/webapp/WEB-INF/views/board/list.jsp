<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>    
<%@ include file="../includes/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
  src="https://code.jquery.com/jquery-3.4.1.js"
  integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
  crossorigin="anonymous">
</script>
</head>
<body>

<div class="jumbotron">
	<div class="container">
	    <div class="col-lg-12">
	        <h1 class="page-header">판매게시판</h1>
	    </div>
	    <!-- /.col-lg-12 -->
	</div>

<!-- /.container -->
<div class="container">
    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-heading">
                Board List Page
                <button id="regBtn" type="button" class="btn btn-primary pull-right">새글 등록</button>
            </div>
            <!-- /.panel-heading -->
            <div class="panel-body">
                <table width="100%" class="table table-striped table-bordered table-hover">
                    <thead>
                    	<th>번호</th>
                    	<th>제목</th>
                    	<th>작성자</th>
                    	<th>작성일</th>
                    	<th>수정일</th>                    	                    
                    </thead>
                    
                    <c:forEach items="${list}" var="list">
                    <tr>
                    	<td>${list.tradeBno }</td>
                    	<td><a class="move" href='<c:out value="${list.tradeBno}"/>'>
                    		${list.tradeTitle } <b>[${list.tradeReplyCnt }]</b></a>                   		                   		
                   		</td>
                    	<td>${list.tradeWriter }</td>
                    	<td><fmt:formatDate pattern="yyyy-MM-dd" value="${list.tradeRegdate }"/></td>
                    	<td><fmt:formatDate pattern="yyyy-MM-dd" value="${list.tradeUpdatedate }"/></td>
                    </tr>
                    </c:forEach>                    
                </table>
                
                <form id="moveForm" method="get">
                </form>               
            <!-- /.panel-body -->
        </div>
        <!-- /.panel -->                
    </div>
    <!-- /.col-lg-12 -->
</div>
<!-- /.container -->	
</div>
<!-- ./jumbotron -->
</div>

<script>
	var moveForm = $("#moveForm");
	
	$(".move").on("click", function(e){
	    e.preventDefault();
	    
	    moveForm.append("<input type='hidden' name='tradeBno' value='"+ $(this).attr("href")+ "'>");
	    moveForm.attr("action", "/board/get");
	    moveForm.submit();
	});
</script>





	
	<!-- insert에서 값이 제대로 넘어 오는지 Test -->
<script>
	$(document).ready(function(){
		
		var result = '${result}'
		
		checkAlert(result);
		
		function checkAlert(result){
			if(result === ''){
				return;
			}
			
			if(result == "등록 성공"){
				alert("등록 완료")
			}
			
			if(result == "수정 성공"){
				alert("수정 완료")
			}
			
			if(result == "삭제 성공"){
				alert("삭제 완료")
			}
		}
	});
</script>
</body>
</html>
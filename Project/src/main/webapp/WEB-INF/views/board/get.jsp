<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ include file="../includes/header.jsp" %>

<div class="jumbotron">
<!-- /.container -->
<div class="container">
    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-heading">Board Read</div>
            <!-- /.panel-heading -->
            
            <div class="panel-body">                
                
                <div class="form-group">
               		<label>번호</label>
               		<input class="form-control" name="tradeBno" value="${pageInfo.tradeBno }" readonly>
               	</div>
               	<div class="form-group">
               		<label>제목</label>
               		<input class="form-control" name="tradeTitle" value="${pageInfo.tradeTitle }" readonly>
               	</div>
               	<div class="form-group">
               		<label>내용</label>
               		<textarea class="form-control" rows="3" name="tradeContent" readonly>${pageInfo.tradeContent }</textarea>
               	</div>
               	<div class="form-group">
               		<label>작성자</label>
               		<input class="form-control" name="tradeWriter" value="${pageInfo.tradeWriter}" readonly>
               	</div>
               	               	
          		<button class="btn btn-secondary" id="modify_btn">수정</button>
               	<button class="btn btn-primary" id="list_btn">목록</button> 
               	 
               	 <form id="infoForm" action="/board/modify" method="get">
               	 	<input type="hidden" id="tradeBno" name="tradeBno" value="${pageInfo.tradeBno}">
               	 </form>                             
                                
            </div>
            <!-- /.panel-body -->
        </div>
        <!-- /.panel -->
    </div>
    <!-- /.col-lg-12 -->
</div>
<!-- /.container -->
</div>

<script>
	var form = $("infoForm");
	
	$("#list_btn").on("click", function(e){
		form.find("#tradeBno").remove();
		form.attr("action", "/board/list");
		form.submit();
	})
	
	$("#modify_btn").on("click", function(e){	
		form.attr("action", "/board/modify");
		form.submit();
	})

</script>

<script>
	$(document).ready(function(){
		
		var result = '${result}'
		
		checkAlert(result);
		
		function checkAlert(result){
			if(result === ''){
				return;
			}
			
			if(result == "게시글 등록 성공"){
				alert("등록이 완료되었습니다.")
			}
			
			if(result == "수정 완료"){
				alert("수정이 완료되었습니다.")
			}
		}
	});
</script>
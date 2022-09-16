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
                <form id="modifyForm" action="/board/modify" method="post">
                <div class="form-group">
               		<label>번호</label>
               		<input class="form-control" name="tradeBno" value="${pageInfo.tradeBno }" readonly>
               	</div>
               	<div class="form-group">
               		<label>제목</label>
               		<input class="form-control" name="tradeTitle" value="${pageInfo.tradeTitle }">
               	</div>
               	<div class="form-group">
               		<label>내용</label>
               		<textarea class="form-control" rows="3" name="tradeContent">${pageInfo.tradeContent }</textarea>
               	</div>
               	<div class="form-group">
               		<label>작성자</label>
               		<input class="form-control" name="tradeWriter" value="${pageInfo.tradeWriter}" readonly>
               	</div>
               	               	          		
               	<button class="btn btn-primary" id="list_btn">목록</button>
               	<button class="btn btn-success" id="modify_btn">수정 완료</button>
               	<button class="btn btn-warning" id="cancel_btn">수정 취소</button>
               	<button class="btn btn-danger" id="delete_btn">삭제</button>
               	                	 
            	</form>
            	
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
	var form = $("#infoForm");        // 페이지 이동 form(리스트 페이지 이동, 조회 페이지 이동)
	var mForm = $("#modifyForm");    // 페이지 데이터 수정 from
	
	/* 목록 페이지 이동 버튼 */
	$("#list_btn").on("click", function(e){
	    form.find("#tradeBno").remove();
	    form.attr("action", "/board/list");
	    form.submit();
	});
	
	/* 수정 버튼 */
	$("#modify_btn").on("click", function(e){
	    mForm.submit();
	});
	
	/* 취소 버튼 */
	$("#cancel_btn").on("click", function(e){
	    form.attr("action", "/board/get");
	    form.submit();
	});   
	
	/* 삭제 버튼 */
	$("#delete_btn").on("click", function(e){
	    form.attr("action", "/board/delete");
	    form.attr("method", "post");
	    form.submit();
	});    

</script>
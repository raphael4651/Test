<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ include file="../includes/header.jsp" %>

<div class="container-lg">
    <div class="col-lg-12">
            <h1 class="page-header">판매게시판</h1>	            	      
    </div>
</div>

<div class="container-lg">	
<div class="row">	
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
            	               	
       			<button class="btn btn-primary" id="modify_btn">수정</button>
            	<button class="btn btn-success" id="list_btn">목록</button> 
            	 
            	 <form id="infoForm" action="/board/modify" method="get">
            	 	<input type="hidden" id="tradeBno" name="tradeBno" value="${pageInfo.tradeBno}">
            	 	<input type="hidden" name="pageNum" value='<c:out value="${cri.pageNum }"/>' >
            	 	<input type="hidden" name="amount" value='<c:out value="${cri.amount }"/>' >
            	 	<input type="hidden" name="keyword" value="${pageMaker.cri.keyword }">
            	 	<input type="hidden" name="type" value="${pageMaker.cri.type }">
            	 </form>                             
      		 </div>                     
		</div>
	</div>
</div>
</div>    
<script>
	var form = $("#infoForm");
	
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
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@include file="../includes/header.jsp" %>

<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">게시판</h1>
    </div>
    <!-- /.col-lg-12 -->
</div>

<!-- /.row -->
<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-heading">Board Read</div>
            <!-- /.panel-heading -->
            
            <div class="panel-body">                
                
                <form role="form" action="/board/modify" method="post">
                	<input type='hidden' name='pageNum' value='${cri.pageNum }'>
                	<input type='hidden' name='amount' value='${cri.amount }'>
                	
	                <div class="form-group">
	               		<label>번호</label>
	               		<input class="form-control" name="bno" value="${board.bno }" readonly>
	               	</div>
	               	<div class="form-group">
	               		<label>제목</label>
	               		<input class="form-control" name="title" value="${board.title }">
	               	</div>
	               	<div class="form-group">
	               		<label>내용</label>
	               		<textarea class="form-control" rows="3" name="content">${board.content }</textarea>
	               	</div>
	               	<div class="form-group">
	               		<label>작성자</label>
	               		<input class="form-control" name="writer" value="${board.writer }" readonly>
	               	</div>
	               	
	               	<button data-oper='modify' class="btn btn-default">수정</button>
	               	<button data-oper='remove' class="btn btn-danger">삭제</button>
	               	<button data-oper='list' class="btn btn-info">목록</button>
               	</form>     	
               	                
            </div>
            <!-- /.panel-body -->
        </div>
        <!-- /.panel -->
    </div>
    <!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<script type="text/javascript">
$(document).ready(function(){
	
	var formObj=$("form");
	
	$("button[data-oper='modify']").on('click',function(e){
		e.preventDefault();
		
		formObj.submit();
	});
	
	$("button[data-oper='list']").on('click',function(e){
		e.preventDefault();
		
		formObj.attr("action","/board/list");
		formObj.attr("method","get");
		
		var pageNumTag=$("input[name='pageNum']").clone();
		var amountTag=$("input[name='amount']").clone();
		
		formObj.empty();
		
		formObj.append(pageNumTag);
		formObj.append(amountTag);
		formObj.submit();
	});
	
	$("button[data-oper='remove']").on('click',function(e){
		e.preventDefault();
		
		formObj.attr('action','/board/remove');
		formObj.submit();
	});
	
	/* $('button').on('click',function(){
		
		var operation=$(this).data('oper');
		console.log(operation);
		
		if(operation=='remove'){
			formObj.attr('action','/board/remove');
		}else if(operation=='list'){
			formObj.attr("action","/board/list");
			formObj.attr("method","get");
			formObj.empty();
		}
		formObj.submit();
	});	 */
});
</script>

<%@include file="../includes/footer.jsp" %>

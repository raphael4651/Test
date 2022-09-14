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
                
                <div class="form-group">
               		<label>번호</label>
               		<input class="form-control" name="bno" value="${board.bno }" readonly>
               	</div>
               	<div class="form-group">
               		<label>제목</label>
               		<input class="form-control" name="title" value="${board.title }" readonly>
               	</div>
               	<div class="form-group">
               		<label>내용</label>
               		<textarea class="form-control" rows="3" name="content" readonly>${board.content }</textarea>
               	</div>
               	<div class="form-group">
               		<label>작성자</label>
               		<input class="form-control" name="writer" value="${board.writer }" readonly>
               	</div>
               	
           <%-- <button class="btn btn-default" onclick="location.href='board/modify?bno=${board.bno }'">수정</button>
               	<button class="btn btn-info" onclick="location.href='board/list">목록</button> --%>
               	
               	<button data-oper='modify' class="btn btn-success">수정</button>
               	<button data-oper='list' class="btn btn-info">목록</button>
                
                <form id='operForm' action="/board/modify" method="get">
                	<input type='hidden' id='bno' name='bno' value='${board.bno }'>
                	<input type='hidden' name='pageNum' value='${cri.pageNum }'>
                	<input type='hidden' name='amount' value='${cri.amount }'>
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
	
	var operForm=$("#operForm");
	
	$("button[data-oper='modify']").on('click',function(e){
		operForm.submit();
	});
	
	$("button[data-oper='list']").on('click',function(e){
		operForm.find("#bno").remove();
		operForm.attr("action",'/board/list').submit();
	});
	
});
</script>

<%@include file="../includes/footer.jsp" %>

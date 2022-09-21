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
<style>
	#paging{
		padding: 15px;
	}
	
</style>
</head>
<body>

<div class="jumbotron">
	<div class="container-lg">
	    <div class="col-lg-12">
	        <h1 class="page-header">판매게시판</h1>
	    </div>
	    <!-- /.col-lg-12 -->
	</div>

<!-- /.container -->
<div class="container text-center">
    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-heading">                
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
                

                <!-- 검색처리 -->
                <div class='row'>
                	<div class="col">                
                	<div class="p-3">
                	<form id='searchForm' action="/board/list" method="get">
                		<select name='type' class="select">
                			<option value="" ${pageMaker.cri.type==null?'selected':'' }>--</option>
                			<option value="T" ${pageMaker.cri.type eq 'T'?'selected':'' }>제목</option>
                			<option value="C" ${pageMaker.cri.type eq 'C'?'selected':'' }>내용</option>
                			<option value="W" ${pageMaker.cri.type eq 'W'?'selected':'' }>작성자</option>
                			<option value="TC" ${pageMaker.cri.type eq 'TC'?'selected':'' }>제목 or 내용</option>
                			<option value="TW" ${pageMaker.cri.type eq 'TW'?'selected':'' }>제목 or 작성자</option>
                			<option value="TWC" ${pageMaker.cri.type eq 'TWC'?'selected':'' }>제목 or 내용 or 작성자</option>
                		</select>
                	            
                		<input type='text' name='keyword' value="${pageMaker.cri.keyword }">
                		<input type='hidden' name='pageNum' value='${pageMaker.cri.pageNum }'>
                		<input type='hidden' name='amount' value='${pageMaker.cri.amount }'>
                		<input type='hidden' name='type' value='${pageMaker.cri.type }'>
                		<button class='btn btn-primary'>검색</button>
                	</form>
                	 </div>
                	</div>
              	</div>

                
                <!-- 페이징 처리 -->
                <div class="position-relative" id="paging">
                	<div class="position-absolute top-100 start-50 translate-middle">
                	
		                <nav aria-label="Page navigation">               	                	
		                	<ul class="pagination">
		                		<c:if test="${pageMaker.prev }">
		                			<li class="page-item previous"><a class="page-link" href="${pageMaker.startPage-1 }">이전</a></li>
		                		</c:if>
		                		
			                	<c:forEach var="num" begin="${pageMaker.startPage }" end="${pageMaker.endPage }">
			                		<li class="page-item ${pageMaker.cri.pageNum==num?'active':'' }"><a class="page-link" href="${num }">${num }</a></li>
			                	</c:forEach>
			                		                	
			               		<c:if test="${pageMaker.next }">
			               			<li class="page-item next"><a class="page-link" href="${pageMaker.endPage+1 }">다음</a></li>
			               		</c:if>
		               		</ul>    
		               	</nav>               
               		</div>	            	                	
                </div>
                           
                <form id="moveForm" method="get">
                	<input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum }">
                	<input type="hidden" name="amount" value="${pageMaker.cri.amount }">
                	<input type="hidden" name="keyword" value="${pageMaker.cri.keyword }">
                	<input type='hidden' name='type' value='${pageMaker.cri.type }'>
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
$(document).ready(function(){
	
	let result = '<c:out value="${result}"/>';
	
	checkAlert(result);
	console.log(result);
	
	function checkAlert(result){
		
		if(result === ''){
			return;
		}
		
		if(result === "등록 성공"){
			alert("등록이 완료되었습니다.");
		}
		
		if(result === "수정 성공"){
			alert("수정이 완료되었습니다.");
		}
		
		if(result === "삭제 성공"){
			alert("삭제가 완료되었습니다.");
		}		
	}	
	
});
	var moveForm = $("#moveForm");
	$(".move").on("click", function(e){
		e.preventDefault();
		
		moveForm.append("<input type='hidden' name='tradeBno' value='"+ $(this).attr("href")+ "'>");
		moveForm.attr("action", "/board/get");
		moveForm.submit();
	});
	
    $(".page-item a").on("click", function(e){
		e.preventDefault();
		moveForm.find("input[name='pageNum']").val($(this).attr("href"));
		moveForm.attr("action", "/board/list");
		moveForm.submit();
		
	});	 
	
	
  //검색
	var searchForm=$('#searchForm');
	
	$('#searchForm button').on('click',function(e){
		e.preventDefault();
		
		if(!searchForm.find('option:selected').val()){
			alert('검색종류를 선택하세요');
			return false;
		}
		if(!searchForm.find("input[name='keyword']").val()){
			alert('키워드를 입력하세요');
			return false;
		}
		
		searchForm.find("input[name='pageNum']").val("1");		
		searchForm.submit();
	});
	
	$('#regBtn').on('click',function(){		
		self.location='/board/insert';		
	});
</script>
</body>
</html>
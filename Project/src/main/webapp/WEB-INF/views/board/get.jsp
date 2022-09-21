<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ include file="../includes/header.jsp" %>
<style>
	#reply{
		margin-top: 20px;
	}
</style>

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

<!-- 댓글 -->
<div class="container-lg" id="reply">
<div class="row">
	<div class="col">		
		<div class="card">
			<div class="card-header">
				<i class="fa fa-comments fa-fw"></i> Reply
				<button id="addReplyBtn" class="btn btn-primary btn-sm pull-right">새 댓글</button>				
			</div>
		
			<div>
				<ul class="chat list-group list-group-flush">
					<li class="list-group-item" data-rno='12'>
						<div>
							<div class="header">
								<strong class="primary-font">user00</strong>
								<small class="pull-right text-muted">2022-01-01</small>
							</div>
							<p>Good job!</p>
						</div>
					</li>				
				</ul>
			</div>
			
			<!-- 페이지 번호 -->
			<div class="panel-footer">								
			</div>
		
		</div>
	</div>
</div>
</div>
<!-- Modal 추가 -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
	 		<div class="modal-header">
	 			<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
	 			<h4 class="modal-title" id="myModalLabel">REPLY MODAL</h4>
	 		</div>
	 		
	 		<div class="modal-body">
	 			<div class="form-group">
	 				<label>Reply</label>
	 				<input class="form-control" name='reply' value='New Reply!!!'>
	 			</div>
	 			<div class="form-group">
	 				<label>Replyer</label>
	 				<input class="form-control" name='replyer' value='replyer'>
	 			</div>
	 			<div class="form-group">
	 				<label>Reply Date</label>
	 				<input class="form-control" name='replyDate' value=''>
	 			</div>
	 		</div>
	 		
	 		<div class="modal-footer">
	 			<button id='modalModBtn' type="button" class="btn btn-primary">수정</button>
	 			<button id='modalRemoveBtn' type="button" class="btn btn-danger">삭제</button>
	 			<button id='modalRegisterBtn' type="button" class="btn btn-primary">등록</button>
	 			<button id='modalCloseBtn' type="button" class="btn btn-secondary" data-dismiss="modal">닫기</button>
	 		</div>
		</div>
	</div>
</div>
<!-- 댓글 처리 스크립트 -->
<script type="text/javascript" src="/resources/js/reply.js"></script>
<script>
$(document).ready(function(){
	
	var bnoValue='<c:out value="${pageInfo.tradeBno}"/>';
	var replyUL = $(".chat");
	
	showList(1);
	
	/* replyService.getList({tradeBno:bnoValue, page:1}, function(list){
		for(var i=0, len=list.length||0; i<len; i++){
			console.log(list[i]);
		}
	}) */
	
	//댓글 전체 조회
	function showList(page){		
		replyService.getList({tradeBno:bnoValue,page:page},				
		function(list){			
			console.log("댓글 목록:"+list);
						
			if(list==null || list.length==0){
				replyUL.html("");
				
				return;
			}
			
			var str="";			
			var len=list.length || 0;
			
			for(var i=0;i<len;i++){
				
				str+="<li class='list-group-item' data-rno='"+list[i].rno+"'>";
				str+="	<div>";
				str+="		<div class='header'>";
				str+="			<strong class='primary-font'>"+list[i].replyer+"</strong>";
				str+="			<small class='pull-right text-muted'>"+replyService.displayTime(list[i].replyDate)+"</small>";
				str+="		</div>";
				str+="		<p>"+list[i].reply+"</p>";
				str+="	</div>";
				str+="</li>";
				
			}
			replyUL.html(str);	//기존 내용 덮어쉬우기
					
		});  
	}
	
	//댓글 모달창
	var modal=$('.modal');
	var modalInputReply=modal.find("input[name='reply']");
	var modalInputReplyer=modal.find("input[name='replyer']");
	var modalInputReplyDate=modal.find("input[name='replyDate']");
	
	var modalModBtn=$('#modalModBtn');
	var modalRemoveBtn=$('#modalRemoveBtn');
	var modalRegisterBtn=$('#modalRegisterBtn');
	
	$("#addReplyBtn").on("click", function(e){
		modal.find("input").val("");
		modalInputReplyDate.closest("div").hide();
		modal.find("button[id !='modalCloseBtn']").hide();
		
		modalRegisterBtn.show();
		
		$(".modal").modal("show");
	});
	
	modalRegisterBtn.on("click",function(e){
		var reply = {
				reply: modalInputReply.val(),
				replyer: modalInputReplyer.val(),
				bno: bnoValue
		};
		replyService.add(reply, function(result){
			alert(result);
			modal.find("input").val("");
			modal.modal("hide");
			
			showList(1);
		});
	});
	
	//댓글 조회 클릭 이벤트 처리
	$(".chat").on("click", "li", function(e){
		var rno = $(this).data("rno");
		replyService.get(rno, function(reply){
			modalInputReply.val(reply.reply);
			modalInputReplyer.val(reply.replyer);
			modalInputReplyDate.val(
					replyService.displayTime(reply.replyDate)).attr("readonly","readonly");
			
			modal.data("rno",reply.rno);
			
			modal.find("button[id!='modalCloseBtn']").hide();		
			modalModBtn.show();
			modalRemoveBtn.show();
			
			$(".modal").modal("show");			
		})
	});
	
	//댓글 수정
	modalModBtn.on("click", function(e){
		var reply = {rno:modal.data("rno"), reply: modalInputReply.val()};
		replyService.update(reply, function(result){
			alert(result);
			modal.modal("hide");
			showList(1);
		})
	})
	
	//댓글 삭제
	modalRemoveBtn.on("click",function(e){
		var rno=modal.data("rno");
		
		replyService.remove(rno,function(result){
			alert("삭제 완료..."+result);		
			modal.modal("hide");
			
			showList(1);	//댓글 갱신
		});
	});
})	
	
</script>

<!-- form 처리 -->
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


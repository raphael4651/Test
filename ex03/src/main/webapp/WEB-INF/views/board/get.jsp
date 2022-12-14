<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="../includes/header.jsp" %>

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
                	<input type='hidden' name='type' value='${cri.type }'>
                	<input type='hidden' name='keyword' value='${cri.keyword }'>
                </form>
                                
            </div>
            <!-- /.panel-body -->
        </div>
        <!-- /.panel -->
    </div>
    <!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<div class="row">
	<div class="col-lg-12">
		
		<div class="panel panel-default">
			<div class="panel-heading">
				<i class="fa fa-comments fa-fw"></i> Reply
				<button id='addReplyBtn' class='btn btn-primary btn-xs pull-right'>새 댓글</button>
			</div>
		
		
			<div class="panel-body">
				<ul class="chat">
					<li class="left clearfix" data-rno='12'>
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
	 			<button id='modalModBtn' type="button" class="btn btn-warning">수정</button>
	 			<button id='modalRemoveBtn' type="button" class="btn btn-danger">삭제</button>
	 			<button id='modalRegisterBtn' type="button" class="btn btn-primary">등록</button>
	 			<button id='modalCloseBtn' type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
	 		</div>
		</div>
	</div>
</div>
                
<script src="/resources/js/reply.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	history.replaceState({},null,null);
	
	//댓글 페이지 처리
	var pageNum=1;
	var replyPageFooter=$(".panel-footer");
	
	function showReplyPage(replyCnt){
		var endNum=Math.ceil(pageNum/10.0)*10;
		var startNum=endNum-9;
		
		var prev=startNum!=1;
		var next=false;
		
		if(endNum*10>=replyCnt){
			endNum=Math.ceil(replyCnt/10.0);
		}
		if(endNum*10<replyCnt){
			next=true;
		}
		var str="<ul class='pagination pull-right'>";
		
		if(prev){
			str+="<li class='page-item'><a class='page-link' href='"+(startNum-1)+"'>이전</a></li>";
		}
		
		for(var i=startNum;i<=endNum;i++){
			var active=pageNum==i?"active":"";
			
			str+="<li class='page-item "+active+"'><a class='page-link' href='"+i+"'>"+i+"</a></li>";
		}
		
		if(next){
			str+="<li class='page-item'><a class='page-link' href='"+(endNum+1)+"'>다음</a></li>";
		}
		
		str+="</ul>";
		
		//replyPageFooter.append(str);
		replyPageFooter.html(str);
	}
	
	//댓글 페이지 번호 클릭시
	replyPageFooter.on("click","li a",function(e){
		e.preventDefault();
		console.log("page click");
		
		var targetPageNum=$(this).attr("href");
		console.log("targetPageNum:"+targetPageNum);
		
		pageNum=targetPageNum;
		
		showList(pageNum);		
	});
	
	//댓글 조회,추가,수정,삭제
	var bnoValue='${board.bno}';
	var replyUL=$(".chat");
	
	showList(1);
	
	//댓글 전체 조회
	function showList(page){
		
		replyService.getList({bno:bnoValue,page:page},				
			function(replyCnt,list){
				console.log("댓글 전체 갯수:"+replyCnt);
				console.log("댓글 목록:"+list);
				
				if(page==-1){
					pageNum=Math.ceil(replyCnt/10.0);
					showList(pageNum);
					return;
				}
							
				if(list==null || list.length==0){
					replyUL.html("");
					
					return;
				}
				
				var str="";			
				var len=list.length || 0;
				
				for(var i=0;i<len;i++){
					console.log(list[i]);
					
					str+="<li class='left clearfix' data-rno='"+list[i].rno+"'>";
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
				
				showReplyPage(replyCnt); //페이징 호출
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
	
	$('#addReplyBtn').on('click',function(e){
		//댓글 등록에서 보일 입력
		modal.find('input').val('');
		modalInputReplyDate.closest('div').hide();
		
		//댓글 등록에서 보일 버튼		
		modal.find("button[id!='modalCloseBtn']").hide();		
		modalRegisterBtn.show();
		
		//modal.find("button[id='modalModBtn']").hide();
		//modal.find("button[id='modalRemoveBtn']").hide();
		
		$(".modal").modal("show");
	});
	
	//댓글 등록
	modalRegisterBtn.on('click',function(e){
		
		var reply={
				reply:modalInputReply.val(),
				replyer:modalInputReplyer.val(),
				bno:bnoValue};
		
		replyService.add(reply,function(result){			
			alert("응답결과:"+result);
			
			modal.find('input').val('');
			modal.modal('hide');
			
			showList(-1);	//댓글 등록후 1페이지로 이동
		});
	});
	
	//댓글 li 클릭시 동작
	$(".chat").on("click","li",function(e){
		var rno=$(this).data("rno");
		
		console.log(rno);
		
		replyService.get(rno,function(reply){
			console.log(reply);
			
			modalInputReply.val(reply.reply);
			modalInputReplyer.val(reply.replyer);
			modalInputReplyDate.val(
					replyService.displayTime(reply.replyDate)).attr("readonly","readonly");
			
			modal.data("rno",reply.rno);
			
			modal.find("button[id!='modalCloseBtn']").hide();		
			modalModBtn.show();
			modalRemoveBtn.show();
			
			$(".modal").modal("show");
			
		});
	});
	
	//댓글 수정
	modalModBtn.on("click",function(e){
		var reply={
				rno:modal.data("rno"),
				reply:modalInputReply.val()};
		
		replyService.update(reply,function(result){
			alert("수정 완료..."+result);
			modal.modal("hide");
			
			showList(pageNum);	//댓글 갱신
		}); 
	});
	
	//댓글 삭제
	modalRemoveBtn.on("click",function(e){
		var rno=modal.data("rno");
		
		replyService.remove(rno,function(result){
			alert("삭제 완료..."+result);		
			modal.modal("hide");
			
			showList(pageNum);	//댓글 갱신
		});
	});	
	
});

//댓글 테스트 
var bnoValue='${board.bno}';

//추가
/* 
replyService.add(
	{reply:"JS Test",replyer:"tester",bno:bnoValue}
	,
	function(result){
		alert("응답결과:"+result);
	}
); 
*/

//전체 조회
/*
replyService.getList({bno:bnoValue,page:1},function(list){
	console.log("list.length:"+list.length);
	
	var len=list.length||0;
	for(var i=0;i<len;i++){
		console.log(list[i]);
	}
}); 
*/

//삭제
/*
replyService.remove(21,function(result){
	console.log("삭제:"+result);
	
	if(count==="success"){
		alert("REMOVED");
	}
},function(err){
	alert('ERROR...')
});
*/

//수정
/* 
replyService.update(
	{rno:22,bno:bnoValue,reply:"Modified Reply....."}
,function(result){
	alert("수정 완료...");
}); 
*/

//조회
/* replyService.get(10,function(data){
	console.log(data);
}); */
</script>

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

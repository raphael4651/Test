console.log("댓글 Module.....");

var replyService={};

var replyService=(function(){
	
	function add(reply,callback){
		console.log("add 댓글........");
		console.log("reply:"+reply.reply);
		console.log("replyer:"+reply.replyer);
		console.log("bno:"+reply.bno);
		
		$.ajax({
			type:'post',
			url:'/replies/new',
			data:JSON.stringify(reply),
			contentType:"application/json;charset=utf-8",
			success:function(result,status,xhr){
				if(callback){
					callback(result);
				}
			},
			error:function(xhr,status,er){
				if(error){
					error(er);
				}
			}
		});
	}
	
	//get.jsp의 showList(page)함수에서
	//param: replyService.getList의 Json값 
	//callback: function(replyCnt, list)의 함수값이 전달되어온다. 
	//js파일로 따로 두지않고 get.jsp의 스크립트에 모아놓아도 된다.
	function getList(param,callback,error){
		var bno=param.bno;
		
		console.log("bno:"+bno);
		
		var page=param.page || 1;
		
		$.getJSON("/replies/pages/"+bno+"/"+page+".json",
			function(data){
				if(callback){
					//callback(data); //댓글 목록만 가져오는 경우
					callback(data.replyCnt, data.list); //댓글 숫자와 목록을 가져오는 경우
				}
			}).fail(function(xhr,status,err){
				if(error){
					error();
				}
			});
	}
	
	
	function remove(rno,callback,error){
		$.ajax({
			type:'delete',
			url:'/replies/'+rno,			
			success:function(result,status,xhr){
				if(callback){
					callback(result);
				}
			},
			error:function(xhr,status,er){
				if(error){
					error(er);
				}
			}
		});
	}
	
	function update(reply,callback,error){
		console.log("update 댓글번호:"+reply.rno);
				
		$.ajax({
			type:'put',
			url:'/replies/'+reply.rno,
			data:JSON.stringify(reply),
			contentType:"application/json;charset=utf-8",
			success:function(result,status,xhr){
				if(callback){
					callback(result);
				}
			},
			error:function(xhr,status,er){
				if(error){
					error(er);
				}
			}
		});
	}
	
	function get(rno,callback,error){				
		console.log("rno:"+rno);
				
		$.get("/replies/"+rno+".json",
			function(result){
				if(callback){
					callback(result);
				}
			}).fail(function(xhr,status,err){
				if(error){
					error();
				}
			});
	}
	
	function displayTime(timeValue){
		
		var today=new Date();				//오늘날짜
		var dateObj=new Date(timeValue);	//등록날짜
		var str="";
		
		var yy=dateObj.getFullYear();		//오늘날짜
		var mm=dateObj.getMonth()+1;
		var dd=dateObj.getDate();
		
		var yy2=today.getFullYear();		//등록날짜
		var mm2=today.getMonth()+1;
		var dd2=today.getDate();
		
		if(yy==yy2 && mm==mm2 && dd==dd2){
			var hh=dateObj.getHours();
			var mi=dateObj.getMinutes();
			var ss=dateObj.getSeconds();
			
			return [(hh>9?'':'0')+hh,':',
					(mi>9?'':'0')+mi,':',
					(ss>9?'':'0')+ss].join('');
			//	9보다 클 경우 두자리수이므로 바로 적히고 9보다 작을 경우 앞에 0을 붙여서 두자리수로 만든다.
			// []배열 ex) 15:14:05초인경우 ['15',':','14',':','05',':'] 배열로 만들어진다
			// .join('') 배열로 되어있는 문자열을 하나로 만든다. split은 ':'등 을 기준으로 문자열을 쪼개서 배열로 만든다.
			// join('') '15:14:05' 로 만든다.
		}else{

			return [yy,'/',(mm>9?'':'0')+mm,'/',
						   (dd>9?'':'0')+dd].join('');
			// yy는 getFullYear 로 불러왔으므로 두자리수로 나온다.
			// ['yy','/','mm','/','dd','/']를 join해서
			// 'yy/mm/dd' 로 만든다.
		}
	}
	
	return {
		add:add,
		getList:getList,
		remove:remove,
		update:update,
		get:get,
		displayTime:displayTime
	};
})();

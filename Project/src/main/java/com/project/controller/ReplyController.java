package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.Criteria;
import com.project.model.ReplyPageDTO;
import com.project.model.ReplyVO;
import com.project.service.ReplyService;
import com.project.service2.pr_ReplyService;

import lombok.extern.log4j.Log4j;

@RequestMapping("/replies")
@RestController
@Log4j
public class ReplyController {

	@Autowired
	private ReplyService service;
	
	@Autowired
	private pr_ReplyService service2;

	//게시판
	
	//추가
	@PostMapping(value="/new",
			consumes="application/json",
			produces= {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> create(@RequestBody ReplyVO vo){
		System.out.println("ReplyVO:"+vo);
		
		int insertCount=service.register(vo);
		
		System.out.println("Reply 추가 갯수:"+insertCount);
		
		return insertCount==1
			?new ResponseEntity<>("success",HttpStatus.OK)
			:new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	//전체 조회
	@GetMapping(value="/pages/{bno}/{page}",
			produces= {
					MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<ReplyPageDTO> getList(
			@PathVariable("page") int page,
			@PathVariable("bno") Long bno){
		
		System.out.println("getList................");
		Criteria cri=new Criteria(page,10);
		System.out.println(cri);
		
		return new ResponseEntity<>(service.getListPage(cri,bno),HttpStatus.OK);
	}
	
	//조회
	@GetMapping(value="/{rno}",
			produces= {
					MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<ReplyVO> get(
			@PathVariable("rno") Long rno){
		
		System.out.println("조회:"+rno);
			
		return new ResponseEntity<>(service.get(rno),HttpStatus.OK);			
	}
	
	//삭제
	@DeleteMapping(value="/{rno}",
			produces= {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> remove(
			@PathVariable("rno") Long rno){
		
		System.out.println("삭제:"+rno);
			
		return service.remove(rno)==1
				?new ResponseEntity<>("success",HttpStatus.OK)
				:new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	//수정
	@RequestMapping(method= {RequestMethod.PUT,RequestMethod.PATCH},
			value="/{rno}",
			consumes="application/json",
			produces= {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> modify(
			@RequestBody ReplyVO vo,
			@PathVariable("rno") Long rno){
		
		vo.setRno(rno);
		
		System.out.println("번호:"+rno);
		System.out.println("수정:"+vo);
			
		return service.modify(vo)==1
				?new ResponseEntity<>("success",HttpStatus.OK)
				:new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	//가게홍보
	
	//추가
	@PostMapping(value="/new2",
			consumes="application/json",
			produces= {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> create2(@RequestBody ReplyVO vo){
		System.out.println("ReplyVO:"+vo);
		
		int insertCount=service2.register(vo);
		
		System.out.println("Reply 추가 갯수:"+insertCount);
		
		return insertCount==1
			?new ResponseEntity<>("success",HttpStatus.OK)
			:new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	//전체 조회
	@GetMapping(value="/pages2/{bno}/{page}",
			produces= {
					MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<ReplyPageDTO> getList2(
			@PathVariable("page") int page,
			@PathVariable("bno") Long bno){
		
		System.out.println("getList................");
		Criteria cri=new Criteria(page,10);
		System.out.println(cri);
		
		return new ResponseEntity<>(service2.getListPage(cri,bno),HttpStatus.OK);
	}
	
	//조회
	@GetMapping(value="/get/{rno}",
			produces= {
					MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<ReplyVO> get2(
			@PathVariable("rno") Long rno){
		
		System.out.println("조회:"+rno);
			
		return new ResponseEntity<>(service2.get(rno),HttpStatus.OK);			
	}
	
	//삭제
	@DeleteMapping(value="/remove/{rno}",
			produces= {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> remove2(
			@PathVariable("rno") Long rno){
		
		System.out.println("삭제:"+rno);
			
		return service2.remove(rno)==1
				?new ResponseEntity<>("success",HttpStatus.OK)
				:new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	//수정
	@RequestMapping(method= {RequestMethod.PUT,RequestMethod.PATCH},
			value="/modify/{rno}",
			consumes="application/json",
			produces= {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> modify2(
			@RequestBody ReplyVO vo,
			@PathVariable("rno") Long rno){
		
		vo.setRno(rno);
		
		System.out.println("번호:"+rno);
		System.out.println("수정:"+vo);
			
		return service2.modify(vo)==1
				?new ResponseEntity<>("success",HttpStatus.OK)
				:new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
		
	
	
	
	
}

package org.project.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.project.domain.SampleVO;
import org.project.domain.Ticket;

import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/sample")
@Log4j
public class SampleController {
	
	@GetMapping(value="/getText",produces="text/plain; charset=utf-8")
	public String getText() {
		System.out.println("MIME TYPE:"+MediaType.TEXT_PLAIN_VALUE);
		
		return "안녕하세요";
	}
	
	@GetMapping(value="/getSample",
			produces= {MediaType.APPLICATION_JSON_UTF8_VALUE,
					MediaType.APPLICATION_XML_VALUE})
	public SampleVO getSample() {
				
		return new SampleVO(112,"스타","로드");
	}
	
	@GetMapping("/getSample2")
	public SampleVO getSample2() {
				
		return new SampleVO(113,"로켓","라쿤");
	}
	
	@GetMapping("/getList")
	public List<SampleVO> getList() {
		
		List<SampleVO> list=new ArrayList<>();
		for(int i=1;i<=10;i++) {
			SampleVO sampleVO=new SampleVO(i,i+" First",i+" Last");
			list.add(sampleVO);
		}		
		return list;
	}
	
	@GetMapping("/getMap")
	public Map<String,SampleVO> getMap() {
		
		Map<String,SampleVO> map=new HashMap<>();
		map.put("First", new SampleVO(111,"그루트","주니어"));
		
		return map;
	}
	
	@GetMapping(value="/check",params= {"height","weight"})
	public ResponseEntity<SampleVO> check(double height,double weight) {
		
		SampleVO vo=new SampleVO(0,height+"",weight+"");
		ResponseEntity<SampleVO> result=null;
		
		if(height<150) {
			result=ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(vo);
		}else {
			result=ResponseEntity.status(HttpStatus.OK).body(vo);
		}
		
		return result;
	}
	
	@GetMapping("/product/{cat}/{pid}")
	public String[] getPath(
			@PathVariable("cat") String cat,
			@PathVariable("pid") Integer pid) {
				
		return new String[] {"category:"+cat,"productid:"+pid};
	}
	
	@PostMapping("/ticket")
	public Ticket convert(@RequestBody Ticket ticket) {
		//json -> 자바 객체 변환
		System.out.println("convert.......ticket"+ticket);
		
		return ticket;
	}
}

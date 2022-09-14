package org.zerock.controller;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.SampleDTO;
import org.zerock.domain.SampleDTOList;
import org.zerock.domain.TodoDTO;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/sample/*")
@Log4j
public class SampleController {
	
	/*
	 * @InitBinder public void initBinder(WebDataBinder binder) { SimpleDateFormat
	 * dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	 * binder.registerCustomEditor(java.util.Date.class, new
	 * CustomDateEditor(dateFormat, false)); }
	 * 
	 * @DateTimeFormat 어노테이션을 사용하면 @InitBinder를 사용하지않는다.
	 */
	
	@RequestMapping("")
	public void basic() {
		log.info("basic............");
	}
	
	@RequestMapping("/aaa")
	public void basic2() {
		log.info("basic aaa............");
	}
	
	@RequestMapping(value = "/basic", method = {RequestMethod.POST})
	public void basicGet() {
		log.info("basic get............");
	}
	
	@RequestMapping("/basicOnlyGet")
	public void basicGet2() {
		log.info("basic get only get............");
	}
	
	
	
	@GetMapping("/ex01")
	public String ex01(SampleDTO dto) {
		
		log.info("" + dto);
		log.info("이름:" + dto.getName());
		log.info("나이:" + dto.getAge());
		
		return "ex01";
	}
	
	@GetMapping("/ex02")
	public String ex02(@RequestParam("name") String n, @RequestParam("age") int a) {
		
		log.info("이름:" + n);
		log.info("나이:" + a);
		
		return "ex02";
	}
	/* String s = request.getParameta("name")과 동일하다.
	 * 받아오는 이름"name"과 넣을변수이름 String n이 이름이 같다면 ex01처럼 사용 이름이 다를경우 사용
	 *  */
	
	@GetMapping("/ex02List")
	public String ex02List(@RequestParam("ids")ArrayList<String> ids) {
		
		log.info("이름:" + ids);
		
		return "ex02List";
	}

	/* 통상적으로 위의 ArrayList를 사용 */
	
	@GetMapping("/ex02Array")
	public String ex02Array(@RequestParam("ids")String[] ids) {
		
		log.info("이름:" + Arrays.toString(ids));
		
		return "ex02Array";
	}
	
	@GetMapping("/ex02Bean")
	public String ex02bean(SampleDTOList list) {
		
		log.info(list);
		
		return "ex02Bean";
	}
	
	@GetMapping("/ex03")
	public String ex03(TodoDTO todo) {
		
		log.info(todo);
		
		return "ex03";
	}
	
	@GetMapping("/ex04")
	public String ex04(SampleDTO dto, @ModelAttribute("page") int page) {
		
		log.info(dto);
		log.info(page);
		
		return "/sample/ex04";
	}
	
	@GetMapping("/ex04redirect")
	public String ex04redirect(
			RedirectAttributes rttr) {
		
		rttr.addFlashAttribute("name", "bbb");
		rttr.addFlashAttribute("age", 20);
		rttr.addFlashAttribute("page", 1);
		
		return "redirect:/sample/ex04";
	}
	
	@GetMapping("/ex05")
	public void ex05() {
		
		log.info("/ex05.........");
	}
	
	@GetMapping("/ex06")
	public @ResponseBody SampleDTO ex06(SampleDTO dto) {
		
		/* SampleDTO dto = new SampleDTO(); 위의 SampleDTO dto와 동일*/
		dto.setAge(10);
		dto.setName("홍길동");
		
		return dto;
	}
	
	@GetMapping("/ex07")
	public ResponseEntity<String> ex07() {
		
		String msg = "{\"name\": \"홍길동\"}";
		
		HttpHeaders header = new HttpHeaders();
		header.add("Content-type", "application/json; charset=UTF-8");
		
		return new ResponseEntity<>(msg, header, HttpStatus.OK);
	}
	
	@GetMapping("/exUpload")
	public void exUpload() {
		log.info("/exUpload......");
	}
	
	@PostMapping("/exUploadPost")
	public void exUploadPost(ArrayList<MultipartFile> files) {
		
		
		files.forEach(file -> {
			log.info("-------------------------");
			log.info("name:" + file.getOriginalFilename());
			log.info("size:" + file.getSize());
		});
		
		/*위는 forEach를 활용한 람다식 밑은 for문 같은 방식
		 * 
		 * for(MultipartFile file:files) 
		 * { log.info("-------------------------");
		 * log.info("name:" + file.getOriginalFilename()); 
		 * log.info("size:" + file.getSize()); }
		 */
	}
}

/* RequestMapping과 GetMapping은 동일하다고 생각해도된다.
/* 주소값이 localhost:8080/sample/ */
/* 주소값이 localhost:8080/sample/aaa */
/* 일 때 log를 출력하는 컨트롤러 */

/* form에서 받는 입력값은 POST, a href=""는 GET 방식 생략하면 GET방식으로 작동
 * POST방식일 때는 method ={}로 명시해줘야한다. */

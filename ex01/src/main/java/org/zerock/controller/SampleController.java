package org.zerock.controller;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	
	@RequestMapping("")
	public void basic() {
		System.out.println("basic..............");
	}
	
	@RequestMapping("/aaa")
	public void basic2() {
		System.out.println("basic2..............");
	}
	
	@RequestMapping(value="/basic",method= {RequestMethod.GET,RequestMethod.POST})
	public void basicGet() {
		System.out.println("basic get..............");
	}
	
	@RequestMapping("/basicOnlyGet")
	public void basicGet2() {
		System.out.println("basic get only get..............");
	}
	
	@RequestMapping("/ex01")
	public String ex01(SampleDTO dto) {
		System.out.println(dto);
		System.out.println("이름:"+dto.getName());
		System.out.println("나이:"+dto.getAge());
		
		return "ex01";
	}
	
	@RequestMapping("/ex02")
	public String ex02(String name,int age) {		
		System.out.println("이름:"+name);
		System.out.println("나이:"+age);
		
		return "ex02";
	}
	
	@RequestMapping("/ex02List")
	public String ex02List(@RequestParam("ids") ArrayList<String> ids) {		
		System.out.println(ids);
				
		return "ex02List";
	}
	
	@RequestMapping("/ex02Array")
	public String ex02Array(String[] ids) {		
		System.out.println(Arrays.toString(ids));
				
		return "ex02Array";
	}
	
	@RequestMapping("/ex02Bean")
	public String ex02Bean(SampleDTOList list) {		
		System.out.println(list);
				
		return "ex02Bean";
	}
	
//	@InitBinder
//	public void initBinder(WebDataBinder binder) {
//		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
//		binder.registerCustomEditor(
//				java.util.Date.class, 
//				new CustomDateEditor(dateFormat,false));
//	}
	
	@RequestMapping("/ex03")
	public String ex03(TodoDTO todo) {		
		System.out.println(todo);
				
		return "ex03";
	}
	
	@RequestMapping("/ex04")
	public String ex04(SampleDTO dto,@ModelAttribute("page") int page) {		
		System.out.println(dto);
		System.out.println(page);
						
		return "/sample/ex04";
	}
	
	@RequestMapping("/ex04redirect")
	public String ex04redirect(RedirectAttributes rttr) {		
				
		rttr.addFlashAttribute("page",1);

		return "redirect:/sample/ex04";
	}
	
	@RequestMapping("/ex05")
	public void ex05() {		
		System.out.println("/ex05........");
	}
	
	@RequestMapping("/ex06")
	public @ResponseBody SampleDTO ex06(SampleDTO dto) {		
		System.out.println("/ex06........");
		
//		SampleDTO dto=new SampleDTO();
		dto.setName("홍길동");
		dto.setAge(10);
		
		return dto;
	}
	
	@RequestMapping("/ex07")
	public ResponseEntity<String> ex07() {		
		System.out.println("/ex07........");
		
		String msg="{\"name\":\"홍길동\"}";
		
		HttpHeaders header=new HttpHeaders();
		header.add("Content-Type", "application/json;charset=UTF-8");
		
		return new ResponseEntity<>(msg,header,HttpStatus.OK);
	}
	
	@RequestMapping("/exUpload")
	public void exUpload() {		
		System.out.println("/exUpload........");		
	}
	
	@RequestMapping("/exUploadPost")
	public void exUploadPost(ArrayList<MultipartFile> files) {		
		System.out.println("/exUploadPost........");
		
//		for(MultipartFile file:files) {
//			System.out.println("--------------------");
//			System.out.println("name:"+file.getOriginalFilename());
//			System.out.println("size:"+file.getSize());
//		}
		files.forEach(file->{
			System.out.println("--------------------");
			System.out.println("name:"+file.getOriginalFilename());
			System.out.println("size:"+file.getSize());
		});
	}
	
	
}

package com.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/sample/*")
@Controller
public class SampleController {
	@GetMapping("/all")
	public void doAll() {
		System.out.println("모두 접근 가능");
	}
	
	@GetMapping("/member")
	public void doMember() {
		System.out.println("멤버 접근 가능");
	}
	
	@GetMapping("/admin")
	public void doAdmin() {
		System.out.println("관리자 접근 가능");
	}
}

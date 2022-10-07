package org.project.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/sample/*")
@Controller
public class SampleController {
	
	@PreAuthorize("permitAll")
	@GetMapping("/all")
	public void doAll() {
		System.out.println("아무나 접근 가능");
	}
	
	@PreAuthorize("hasRole('ROLE_MEMBER')")
	@GetMapping("/member")
	public void doMember() {
		System.out.println("멤버만 접근 가능");
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/admin")
	public void doAdmin() {
		System.out.println("관리자만 접근 가능");
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_MEMBER')")
	@GetMapping("/annoMember")
	public void doMember2() {
		System.out.println("어노테이션 멤버 접근 가능");
	}
	
	@Secured({"ROLE_ADMIN"})
	@GetMapping("/annoAdmin")
	public void doAdmin2() {
		System.out.println("어노테이션 관리자만 접근 가능");
	}
}

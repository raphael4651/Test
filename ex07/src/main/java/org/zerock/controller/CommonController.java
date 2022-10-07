package org.project.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class CommonController {

	@GetMapping("/accessError")
	public void accessDenied(Authentication auth,Model model) {
		System.out.println("접근거부:"+auth);
		model.addAttribute("msg","접근 거부");
	}
	
	@GetMapping("/customLogin")
	public void loginInput(String error,String logout,Model model) {
		System.out.println("에러:"+error);
		System.out.println("로그아웃:"+logout);
		
		if(error!=null) {
			model.addAttribute("error","로그인 에러");
		}
		if(logout!=null) {
			model.addAttribute("logout","로그아웃!!!");
		}		
	}
	
	@GetMapping("/customLogout")
	public void loginGET() {
		System.out.println("로그아웃");
	}
	
}

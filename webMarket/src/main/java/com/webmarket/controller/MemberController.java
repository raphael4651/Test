package com.webmarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.webmarket.model.MemberVO;
import com.webmarket.service.MemberService;

@Controller
@RequestMapping(value = "/member")
public class MemberController {
	
	@Autowired
	private MemberService memberservice;
	
	@Autowired
	private JavaMailSender mailSender;
	
	//회원가입 페이지 이동
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public void loginGET() {
		System.out.println("회원가입 페이지 진입");
	}
		
	//회원가입
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String joinPOST(MemberVO member) throws Exception{
		System.out.println("join 진입");
		
		memberservice.memberJoin(member);
		
		System.out.println("join Service 성공");
		
		return "redirect:/main";
	}
	
	//로그인 페이지 이동
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public void joinGET() {
		System.out.println("로그인 페이지 진입");
	}
	
	//아이디 중복 검사
	@RequestMapping(value = "/memberIdChk", method = RequestMethod.POST)
	@ResponseBody
	public String memberIdChkPOST(String memberId) throws Exception{
		System.out.println("MemberIdChk() 진입");
		int result = memberservice.idCheck(memberId);
		System.out.println("결과값 = " + result);
		
		if(result != 0) {
			return "fail";
		}else {
			return "success";			
		}
	}
	
}

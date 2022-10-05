package com.webmarket.controller;

import java.util.Random;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
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
	
	//이메일 인증
	@RequestMapping(value = "/mailCheck", method = RequestMethod.GET)
	@ResponseBody
	public String mailCheckGET(String email) throws Exception{
		System.out.println("이메일 데이터 전송 확인");
		System.out.println("인증번호 : " + email);
		
		//인증번호 (난수) 생성
		Random random = new Random();
		int checkNum = random.nextInt(888888) + 111111;
		System.out.println("인증번호 " + checkNum);
		
		//이메일 보내기
		String setFrom = "tkalqnak0122@naver.com";
		String toMail = email;
		String title = "회원가입 인증 이메일입니다.";
		String content =
					   "홈페이지를 방문해 주셔서 감사합니다. " +
					   "<br><br>" +
					   "인증 번호는 " + checkNum + "입니다." +
					   "<br>" +
					   "해당 인증번호를 인증번호 확인란에 기입하여 주세요.";
		try {
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
			helper.setFrom(setFrom);
			helper.setTo(toMail);
			helper.setSubject(title);
			helper.setText(content, true);
			mailSender.send(message);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		String num = Integer.toString(checkNum);
		
		return num;
	}
}

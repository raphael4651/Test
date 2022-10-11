package com.webmarket.controller;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.webmarket.model.MemberVO;
import com.webmarket.service.MemberService;

@Controller
@RequestMapping(value = "/member")
public class MemberController {
	
	@Autowired
	private MemberService memberservice;	
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private BCryptPasswordEncoder pwEncoder;
	
	//회원가입 페이지 이동
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public void loginGET() {
		System.out.println("회원가입 페이지 진입");
	}
		
	//회원가입
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String joinPOST(MemberVO member) throws Exception{
		String rawPw = ""; 			//인코딩 전 비밀번호
		String encodePw = ""; 		//인코딩 후 비밀번호
		
		rawPw = member.getMemberPw();
		encodePw = pwEncoder.encode(rawPw);
		member.setMemberPw(encodePw);
		
		memberservice.memberJoin(member);
		
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
		
		/*
		 * //이메일 보내기 String setFrom = "tkalqnak0122@naver.com"; String toMail = email;
		 * String title = "회원가입 인증 이메일입니다."; String content = "홈페이지를 방문해 주셔서 감사합니다. " +
		 * "<br><br>" + "인증 번호는 " + checkNum + "입니다." + "<br>" +
		 * "해당 인증번호를 인증번호 확인란에 기입하여 주세요."; try { MimeMessage message =
		 * mailSender.createMimeMessage(); MimeMessageHelper helper = new
		 * MimeMessageHelper(message, true, "utf-8"); helper.setFrom(setFrom);
		 * helper.setTo(toMail); helper.setSubject(title); helper.setText(content,
		 * true); mailSender.send(message);
		 * 
		 * }catch (Exception e) { e.printStackTrace(); }
		 */
		
		String num = Integer.toString(checkNum);
		
		return num;
	}
	
	//로그인
	@RequestMapping(value="login", method = RequestMethod.POST)
	public String loginPOST(HttpServletRequest request, MemberVO member, RedirectAttributes rttr) throws Exception {
		HttpSession session = request.getSession();
		String rawPw = "";
		String encodePw = "";
		
		MemberVO lvo = memberservice.memberLogin(member);
		
		if(lvo != null) {
			rawPw = member.getMemberPw();
			encodePw = lvo.getMemberPw();
			
			if(true == pwEncoder.matches(rawPw, encodePw)) {
				lvo.setMemberPw("");
				session.setAttribute("member", lvo);
				return "redirect:/main";
				
			}else {
				rttr.addFlashAttribute("result", 0);
				return "redirect:/member/login";
			}
		}else {
			rttr.addFlashAttribute("result", 0);
			return "redirect:/member/login";
		}
		
	}
	
}

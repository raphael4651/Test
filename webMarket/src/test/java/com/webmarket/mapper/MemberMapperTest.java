package com.webmarket.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.webmarket.model.MemberVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class MemberMapperTest {
	
	@Autowired
	private MemberMapper memberMapper;
	
	//회원가입 쿼리 테스트
	@Test
	public void memberJoin() {
		MemberVO member = new MemberVO();
		member.setMemberId("spring_test");
		member.setMemberPw("spring_test");
		member.setMemberName("spring_test");
		member.setMemberMail("spring_test");
		member.setMemberAddr1("spring_test");
		member.setMemberAddr2("spring_test");
		member.setMemberAddr3("spring_test");
		
		memberMapper.memberJoin(member);
	}
	
	//아이디 중복 검사 
	@Test
	public void memberIdChk() throws Exception{
		String id = "admin";
		String id2 = "test1234";
		memberMapper.idCheck(id);
		memberMapper.idCheck(id2);
		System.out.println(memberMapper.idCheck(id));
		System.out.println(memberMapper.idCheck(id2));
	}
	
	//로그인 쿼리 테스트
	@Test
	public void memberLogin() throws Exception{
		MemberVO member = new MemberVO();
		
		//올바른 아이디 비밀번호 입력
		member.setMemberId("admin");
		member.setMemberPw("admin");
		
		//올바르지 않은 아이디 비밀번호
		//member.setMemberId("11");
		//member.setMemberPw("1234");
		
		memberMapper.memberLogin(member);
		System.out.println("결과 값 : " + memberMapper.memberLogin(member));
	}
	
}

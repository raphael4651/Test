package org.project.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.project.domain.MemberVO;
import org.project.mapper.MemberMapper;
import org.project.security.domain.CustomUser;

import lombok.extern.log4j.Log4j;

@Log4j
public class CustomUserDetailsService 
		implements UserDetailsService{

	@Autowired
	MemberMapper memberMapper;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		System.out.println("UserName으로 User 로드:"+userName);
		
		MemberVO vo=memberMapper.read(userName);
		
		System.out.println("member 쿼리 실행:"+vo);
		
		return vo==null?null:new CustomUser(vo);
	}
		
}

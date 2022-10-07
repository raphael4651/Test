package org.project.security;

import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.extern.log4j.Log4j;

@Log4j
public class CustomNoOpPasswordEncoder 
		implements PasswordEncoder{
	
	@Override	
	public String encode(CharSequence rawPassword) {		
		System.out.println("endcode 전:"+rawPassword);
		
		return rawPassword.toString();
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		System.out.println("매치:"+rawPassword+":"+encodedPassword);
		
		return rawPassword.toString().equals(encodedPassword);
	}

}

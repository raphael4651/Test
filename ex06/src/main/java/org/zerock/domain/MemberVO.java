package org.project.domain;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class MemberVO {
	String userid;
	String userpw;
	String userName;
	boolean enabled;
	
	Date regDate;
	Date updateDate;
	List<AuthVO> authList;
}

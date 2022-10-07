package org.project.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.project.domain.MemberVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		{"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
@Log4j
public class MemberMapperTests {
	
	@Autowired
	MemberMapper mapper;
	
	@Test
	public void testRead() {
		MemberVO vo=mapper.read("admin90");
		
		System.out.println(vo);
		
		vo.getAuthList().forEach(authVO->System.out.println(authVO));
	}
	
}

package org.zerock.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class SampleServiceTests {
	
	@Autowired
	//root-context.xml 에 있는 것을 모두 불러온다.
	private SampleService service;
	
	@Test
	public void testClass() {
		System.out.println(service);
		System.out.println(service.getClass().getName());
	}
	
	@Test
	public void testAdd() throws Exception{
		System.out.println(service.doAdd("123", "456"));
	}
	
	@Test
	public void testAddError() throws Exception{
		System.out.println(service.doAdd("123", "ABC"));
	}
}

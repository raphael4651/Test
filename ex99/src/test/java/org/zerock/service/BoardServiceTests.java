package org.project.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.project.domain.BoardVO;
import org.project.domain.Criteria;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardServiceTests {

	@Autowired
	BoardService service;
	
	@Test
	public void get() {
		
		System.out.println(service.get(1L)); 
		
	}
	@Test
	public void testList() {
		Criteria cri=new Criteria(1,10);
		
		int total=service.getTotal(cri);	
		
		System.out.println(total);
	}
	
	
	@Test
	public void testList1() {
		Criteria cri=new Criteria(1,10);
		
		System.out.println(service.getList_f(cri));
	}
	
	@Test
	public void remove() {
		
		System.out.println(service.remove(138L)); 
		
	}
	
	@Test
	public void update() {
		BoardVO board=new BoardVO();
		board.setBno(137L);
		board.setTitle("update");
		board.setContent("update");
		
		System.out.println(service.modify(board)); 
	}
	
	
	@Test
	public void modify() {
		
		BoardVO board=new BoardVO();
		
		board.setBno(39L);
		board.setContent("update content");
		board.setTitle("update title");
		
		System.out.println(service.modify(board)); 
		
	}
	
	@Test
	public void testsearch() {
		
		Criteria cri=new Criteria();
		cri.setKeyword("검색");
		cri.setType("T");
		
		List<BoardVO> list = service.getList(cri);
		list.forEach(board->log.info(board));
		
	}
	
	

}

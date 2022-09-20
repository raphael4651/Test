package com.project.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.project.model.BoardVO;
import com.project.model.Criteria;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class BoardServiceTests {

	@Autowired
	private BoardService service;
	
	//게시판 등록 테스트
	@Test
	public void testInsert() {		
		BoardVO vo = new BoardVO();
		
		vo.setTradeTitle("service test");
		vo.setTradeContent("service test");
		vo.setTradeWriter("service");		
		
		service.insert(vo);
		System.out.println(vo);
	}
	
	//게시판 목록 테스트
	@Test
	public void testGetList(){		
		service.getList().forEach(board -> System.out.println("" + board));		
	}
	
	//게시판 조회 테스트
	@Test
	public void testGetPage() {
		int bno = 6;
		System.out.println("" + service.getPage(bno));
	}
	
	//게시판 조회(페이징) 테스트
	@Test
	public void testGetListPaging() {
		Criteria cri = new Criteria();
		List list = service.getListPaging(cri);
		list.forEach(board -> System.out.println(""+board));
	}
	
	//게시판 수정 테스트
	@Test
	public void testModify() {
		BoardVO board = new BoardVO();
		board.setTradeBno(6);
		board.setTradeTitle("수정 ");
		board.setTradeContent("수정 ");
		
		int result = service.modify(board);
		System.out.println("결과 : " + result);
	}
	
	//게시판 삭제 테스트
	@Test
	public void testDelete() {
		int result = service.delete(3);
		System.out.println(result);
	}
}

package org.zerock.service;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardServiceTests {

	@Autowired
	BoardService service;
	
	@Test
	public void testExist() {
		System.out.println(service);
		assertNotNull(service);
	}
	
	@Test
	public void testRegister() {
		BoardVO board=new BoardVO();
		board.setTitle("새로 작성하는 글");
		board.setContent("새로 작성하는 내용");
		board.setWriter("newbie");
		
		service.register(board);
		
		System.out.println("생성 게시물 번호:"+board.getBno());
	}
	
//	@Test
//	public void testList() {
//		
//		service.getList().forEach(board->
//			System.out.println(board)
//		);		
//	}
	
	@Test
	public void testList() {
		Criteria cri=new Criteria(2,10);
		
		List<BoardVO> list=service.getList(cri);
		
		list.forEach(board->System.out.println(board));
	}
	
	@Test
	public void testGet() {
		
		System.out.println(service.get(6L));
	}
	
	@Test
	public void testDelete() {
		
		System.out.println("삭제 결과:"+service.remove(5L));
	}
	
	@Test
	public void testUpdate() {
		BoardVO board=service.get(6L);
		
		if(board==null) {
			return;
		}
		board.setTitle("제목 수정");
		
		System.out.println("수정 결과:"+service.modify(board));
	}
}

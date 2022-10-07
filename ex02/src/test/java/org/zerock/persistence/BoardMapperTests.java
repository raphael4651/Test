package org.project.persistence;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.project.domain.BoardVO;
import org.project.domain.Criteria;
import org.project.mapper.BoardMapper;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {

	@Autowired
	BoardMapper mapper;
	
	@Test
	public void testGetList() {
		mapper.getList().forEach(board->
			System.out.println(board)
		);
	}
	
	@Test
	public void testInsert() {
		BoardVO board=new BoardVO();
		board.setTitle("새로 작성하는 글");
		board.setContent("새로 작성하는 내용");
		board.setWriter("newbie");
		
		mapper.insert(board);
		
		System.out.println(board);
	}
	
	@Test
	public void testInsertSelectKey() {
		BoardVO board=new BoardVO();
		board.setTitle("새로 작성하는 글 select key");
		board.setContent("새로 작성하는 내용 select key");
		board.setWriter("newbie");
		
		mapper.insertSelectKey(board);
		
		System.out.println(board);
	}
	
	@Test
	public void testRead() {
		BoardVO board=mapper.read(5L);
		
		System.out.println(board);
	}
	
	@Test
	public void testDelete() {
		int a=mapper.delete(2L);
		
		if(a>0) {
			System.out.println("삭제 성공");
		}else {
			System.out.println("삭제 실패");
		}
	}
	
	@Test
	public void testUpdate() {
		BoardVO board=new BoardVO();
		board.setBno(5L);
		board.setTitle("수정된 제목");
		board.setContent("수정된 내용");
		board.setWriter("user00");
		
		int count=mapper.update(board);
		if(count>0)
			System.out.println("수정 성공");
		else 
			System.out.println("수정 실패");	
	}
	
	@Test
	public void testPaging() {
		Criteria cri=new Criteria();
		cri.setPageNum(3);
		cri.setAmount(10);
		
		List<BoardVO> list=mapper.getListWithPaging(cri);
		
		list.forEach(board->System.out.println(board));
	}
	
	@Test
	public void testSearch() {
		Criteria cri=new Criteria();
		cri.setKeyword("새로");
		cri.setType("TC");
		
		List<BoardVO> list=mapper.getListWithPaging(cri);
		
		list.forEach(board->System.out.println(board));
	}
}

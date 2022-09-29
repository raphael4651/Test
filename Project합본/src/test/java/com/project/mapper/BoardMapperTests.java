package com.project.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.project.model.TradeBoardVO;
import com.project.model.TradeCriteria;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class TradeBoardmapperTests {
	
	@Autowired
	private TradeBoardmapper mapper;
	
	//게시판 등록 테스트
	@Test
	public void testInsert() {
		TradeBoardVO vo = new TradeBoardVO();
		
		vo.setTradeTitle("mapper test");
		vo.setTradeContent("mapper test");
		vo.setTradeWriter("mapper");
		
		mapper.insert(vo);
	}
	
	//게시판 목록 테스트
	@Test
	public void testGetList() {
		List list = mapper.getList();
		
		list.forEach(board -> System.out.println("" + board));
	}
	
	//게시판 목록 페이징 테스트
	@Test
	public void testGetListPaging() {
		TradeCriteria cri = new TradeCriteria();
		
		cri.setPageNum(5);
		
		List list = mapper.getListPaging(cri);
		
		list.forEach(board -> System.out.println(""+board));
	}
	
	//게시판 조회 테스트
	@Test
	public void testGetPage() {
		int bno = 6;
		
		System.out.println(mapper.getPage(bno));
	}

	//게시판 수정 테스트
	@Test
	public void testModify() {
		TradeBoardVO board = new TradeBoardVO();
		board.setTradeBno(6);
		board.setTradeTitle("수정 수정");
		board.setTradeContent("수정 내용");
		
		int result = mapper.modify(board);
		System.out.println("결과 : " + result);
	}
	
	//게시판 삭제 테스트
	@Test
	public void testDelete() {
		int result = mapper.delete(6);
		System.out.println("삭제 완료 " +  result);
	}
}

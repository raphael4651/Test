package com.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.project.model.BoardVO;
import com.project.model.Criteria;

public interface BoardMapper {
//판매 게시판
	//게시글 등록
	public void insert(BoardVO board);
	
	public void insertSelectKey(BoardVO board);
	
	//게시판 목록
	public List<BoardVO> getList();
	
	//게시판 목록(페이징)
	public List<BoardVO> getListPaging(Criteria cri);
	
	//게시판 조회
	public BoardVO getPage(int tradeBno);
	
	//게시판 수정
	public int modify(BoardVO board);
	
	//게시판 삭제
	public int delete(Long tradeBno);
	
	//게시판 총 갯수
	public int getTotal(Criteria cri);
	
	//게시판 제목에 댓글갯수
	public void updateReplyCnt(@Param("tradeBno")Long tradeBno, @Param("amount")int amount);

//구매 게시판
	//게시글 등록
	public void insert2(BoardVO board);
	
	public void insertSelectKey2(BoardVO board);
	
	//게시판 목록
	public List<BoardVO> getList2();
	
	//게시판 목록(페이징)
	public List<BoardVO> getListPaging2(Criteria cri);
	
	//게시판 조회
	public BoardVO getPage2(int tradeBno2);
	
	//게시판 수정
	public int modify2(BoardVO board);
	
	//게시판 삭제
	public int delete2(Long tradeBno2);
	
	//게시판 총 갯수
	public int getTotal2(Criteria cri);
	
	//게시판 제목에 댓글갯수
	public void updateReplyCnt2(@Param("tradeBno2")Long tradeBno2, @Param("amount")int amount);
	
	
}

package com.project.mapper;

import java.util.List;

import com.project.model.BoardVO;
import com.project.model.Criteria;

public interface BoardMapper {

	//게시글 등록
	public void insert(BoardVO board);
	
	//게시판 목록
	public List<BoardVO> getList();
	
	//게시판 목록(페이징)
	public List<BoardVO> getListPaging(Criteria cri);
	
	//게시판 조회
	public BoardVO getPage(int tradeBno);
	
	//게시판 수정
	public int modify(BoardVO board);
	
	//게시판 삭제
	public int delete(int tradeBno);
	
	//게시판 총 갯수
	public int getTotal(Criteria cri);
	
}

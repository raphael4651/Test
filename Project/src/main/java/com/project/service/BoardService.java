package com.project.service;

import java.util.List;

import com.project.model.BoardVO;

public interface BoardService {
	
	//게시판 등록
	public void insert(BoardVO board);

	//게시판 목록
	public List<BoardVO> getList();
	
	//게시판 조회
	public BoardVO getPage(int tradeBno);
	
	//게시판 수정
	public int modify(BoardVO board);
}
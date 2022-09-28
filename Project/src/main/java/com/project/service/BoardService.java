package com.project.service;

import java.util.List;

import com.project.model.BoardAttachVO;
import com.project.model.BoardVO;
import com.project.model.Criteria;

public interface BoardService {
//판매 게시판	
	//게시판 등록
	public void insert(BoardVO board);

	//게시판 목록
	public List<BoardVO> getList();
	
	//게시판 목록(페이징)
	public List<BoardVO> getListPaging(Criteria cri);
	
	//첨부파일 목록
	public List<BoardAttachVO> getAttachList(Long bno);
	
	//게시판 조회
	public BoardVO getPage(int tradeBno);
	
	//게시판 수정
	public boolean modify(BoardVO board);
	
	//게시판 삭제
	public int delete(int tradeBno);
	
	//게시판 총 갯수
	public int getTotal(Criteria cri);

	public boolean remove(Long bno);
	
	
//구매 게시판
	//게시판 등록
	public void insert2(BoardVO board);

	//게시판 목록
	public List<BoardVO> getList2();
	
	//게시판 목록(페이징)
	public List<BoardVO> getListPaging2(Criteria cri);
	
	//첨부파일 목록
	public List<BoardAttachVO> getAttachList2(Long bno2);
	
	//게시판 조회
	public BoardVO getPage2(int tradeBno2);
	
	//게시판 수정
	public boolean modify2(BoardVO board);
	
	//게시판 삭제
	public int delete2(int tradeBno2);
	
	//게시판 총 갯수
	public int getTotal2(Criteria cri);

	public boolean remove2(Long bno2);
	
//공지사항	
	//공지사항 등록
	public void insertNotice(BoardVO board);

	//공지사항 목록
	public List<BoardVO> getListNotice();
	
	//공지사항 목록(페이징)
	public List<BoardVO> getListPagingNotice(Criteria cri);
	
	//공지사항 조회
	public BoardVO getPageNotice(int noticeBno);
	
	//공지사항 수정
	public boolean modifyNotice(BoardVO board);
	
	//공지사항 삭제
	public int deleteNotice(int noticeBno);
	
	//공지사항 총 갯수
	public int getTotalNotice(Criteria cri);
}

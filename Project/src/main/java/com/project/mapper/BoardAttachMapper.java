package com.project.mapper;

import java.util.List;

import com.project.model.BoardAttachVO;

public interface BoardAttachMapper {
//판매 게시판
	//첨부파일 등록
	public void insert(BoardAttachVO vo);
	
	//첨부파일 삭제
	public void delete(String uuid);
	
	//첨부파일 조회
	public List<BoardAttachVO> findByBno(Long bno);
	
	//게시글과 첨부파일 삭제
	public void deleteAll(Long tradeBno);
	
	//DB확인후 불일치시 파일 삭제
	public List<BoardAttachVO> getOldFiles();
	
//구매 게시판
	//첨부파일 등록
	public void insert2(BoardAttachVO vo);
	
	//첨부파일 삭제
	public void delete2(String uuid2);
	
	//첨부파일 조회
	public List<BoardAttachVO> findByBno2(Long bno2);
	
	//게시글과 첨부파일 삭제
	public void deleteAll2(Long tradeBno2);
	
	//DB확인후 불일치시 파일 삭제
	public List<BoardAttachVO> getOldFiles2();

}

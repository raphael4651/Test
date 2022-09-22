package com.project.mapper;

import java.util.List;

import com.project.model.BoardAttachVO;

public interface BoardAttachMapper {
	//첨부파일 등록
	public void insert(BoardAttachVO vo);
	
	//첨부파일 삭제
	public void delete(String uuid);
	
	//첨부파일 조회
	public List<BoardAttachVO> findByBno(Long bno);
}

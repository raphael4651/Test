package com.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.project.model.Criteria;
import com.project.model.ReplyVO;

public interface ReplyMapper {

	//댓글 등록
	public int insert(ReplyVO vo);
	
	//댓글 조회
	public ReplyVO read(Long rno);
	
	//댓글 삭제
	public int delete (Long rno);
	
	//댓글 수정
	public int update(ReplyVO reply);
	
	//댓글 페이징
	public List<ReplyVO> getListPaging(
			@Param("cri") Criteria cri,
			@Param("bno") Long bno);
}

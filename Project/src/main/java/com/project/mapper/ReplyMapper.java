package com.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.project.model.Criteria;
import com.project.model.ReplyVO;

public interface ReplyMapper {
//판매 게시판
	//댓글 등록
	public int insert(ReplyVO vo);
	
	//댓글 조회
	public ReplyVO read(Long rno);
	
	//댓글 삭제
	public int delete (Long rno);
	
	//게시글 삭제시 삭제
	public int deleteAll (Long tradeBno);
	
	//댓글 수정
	public int update(ReplyVO reply);
	
	//댓글 페이징
	public List<ReplyVO> getListWithPaging(
			@Param("cri") Criteria cri,
			@Param("bno") Long bno);
	
	//댓글 총 갯수
	public int getCountByBno(Long bno);

//구매 게시판
	//댓글 등록
	public int insert2(ReplyVO vo);
	
	//댓글 조회
	public ReplyVO read2(Long rno2);
	
	//댓글 삭제
	public int delete2 (Long rno2);
	
	//게시글 삭제시 삭제
	public int deleteAll2 (Long tradeBno2);
	
	//댓글 수정
	public int update2(ReplyVO reply2);
	
	//댓글 페이징
	public List<ReplyVO> getListWithPaging2(
			@Param("cri") Criteria cri,
			@Param("bno2") Long bno2);
	
	//댓글 총 갯수
	public int getCountByBno2(Long bno2);

}

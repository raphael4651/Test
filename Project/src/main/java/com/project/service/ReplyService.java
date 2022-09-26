package com.project.service;

import java.util.List;

import com.project.model.Criteria;
import com.project.model.ReplyPageDTO;
import com.project.model.ReplyPageDTO2;
import com.project.model.ReplyVO;

public interface ReplyService {
//판매 게시판
	public int register(ReplyVO vo);
	
	public ReplyVO get(Long rno);
	
	public int modify(ReplyVO vo);
	
	public int remove(Long rno);
	
	public List<ReplyVO> getList(Criteria cri, Long bno);
	
	public ReplyPageDTO getListPage(Criteria cri, Long bno);
	
//구매 게시판
	public int register2(ReplyVO vo);
	
	public ReplyVO get2(Long rno2);
	
	public int modify2(ReplyVO vo);
	
	public int remove2(Long rno2);
	
	public List<ReplyVO> getList2(Criteria cri, Long bno2);
	
	public ReplyPageDTO2 getListPage2(Criteria cri, Long bno2);
}

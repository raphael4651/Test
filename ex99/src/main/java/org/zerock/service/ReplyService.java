package org.project.service;

import java.util.List;

import org.project.domain.Criteria;
import org.project.domain.ReplyPageDTO;
import org.project.domain.ReplyVO;

public interface ReplyService {

	int register(ReplyVO vo);
	
	ReplyVO get(Long rno);
	
	int modify(ReplyVO vo);
	
	int remove(Long rno);
	
	List<ReplyVO> getList(Criteria cri,Long bno);
	
	ReplyPageDTO getListPage(Criteria cri,Long bno);
	
	int getCount(Long bno);
	
}

package org.zerock.service;

import java.util.List;

import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyPageDTO;
import org.zerock.domain.ReplyVO;

public interface ReplyService {

	int register(ReplyVO vo);
	ReplyVO get(Long rno);
	int modify(ReplyVO vo);
	int remove(Long rno);
	List<ReplyVO> getList(Criteria cri,Long bno);
	ReplyPageDTO getListPage(Criteria cri,Long bno);
}

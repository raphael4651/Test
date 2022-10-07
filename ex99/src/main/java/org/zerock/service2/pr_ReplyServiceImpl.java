package org.project.service2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.project.domain.Criteria;
import org.project.domain.ReplyPageDTO;
import org.project.domain.ReplyVO;
import org.project.mapper2.pr_BoardMapper;
import org.project.mapper2.pr_ReplyMapper;

@Service
public class pr_ReplyServiceImpl implements pr_ReplyService{
	
	@Autowired
	pr_ReplyMapper mapper;
	
	@Autowired
	pr_BoardMapper boardmapper;
	
	@Transactional
	@Override
	public int register(ReplyVO vo) {
		boardmapper.updateReplyCnt(vo.getBno(),1);
		return mapper.insert(vo);
	}

	@Override
	public ReplyVO get(Long rno) {
		return mapper.read(rno);
	}

	@Override
	public int modify(ReplyVO vo) {		
		return mapper.update(vo);
	}
	
	@Transactional
	@Override
	public int remove(Long rno) {
		ReplyVO vo=mapper.read(rno);
		boardmapper.updateReplyCnt(vo.getBno(),-1);
		return 0;
	}

	@Override
	public List<ReplyVO> getList(Criteria cri, Long bno) {		
		return mapper.getListWithPaging(cri, bno);
	}

	@Override
	public ReplyPageDTO getListPage(Criteria cri, Long bno) {
		int cnt=mapper.getCountByBno(bno);
		List<ReplyVO> list=mapper.getListWithPaging(cri, bno);
		return new ReplyPageDTO(cnt,list);
	}

	@Override
	public int getCount(Long bno) {
		int cnt=mapper.getCountByBno(bno);
		return cnt;
	}

}

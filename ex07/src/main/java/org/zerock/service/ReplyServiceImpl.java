package org.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.project.domain.Criteria;
import org.project.domain.ReplyPageDTO;
import org.project.domain.ReplyVO;
import org.project.mapper.BoardMapper;
import org.project.mapper.ReplyMapper;

import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class ReplyServiceImpl implements ReplyService{

	@Autowired
	ReplyMapper mapper;
	
	@Autowired
	BoardMapper boardMapper;
	
	@Transactional
	@Override
	public int register(ReplyVO vo) {
		System.out.println("register....."+vo);
		
		boardMapper.updateReplyCnt(vo.getBno(), 1);
		
		return mapper.insert(vo);
	}

	@Override
	public ReplyVO get(Long rno) {
		System.out.println("get......"+rno);
		
		return mapper.read(rno);
	}

	@Override
	public int modify(ReplyVO vo) {
		System.out.println("modify....."+vo);
		
		return mapper.update(vo);
	}

	@Transactional
	@Override
	public int remove(Long rno) {
		System.out.println("remove....."+rno);
		
		ReplyVO vo=mapper.read(rno);
		boardMapper.updateReplyCnt(vo.getBno(), -1);
		
		return mapper.delete(rno);		
	}
	
	@Override
	public List<ReplyVO> getList(Criteria cri, Long bno) {
		System.out.println("get Reply List "+bno);
		
		return mapper.getListWithPaging(cri, bno);		
	}

	@Override
	public ReplyPageDTO getListPage(Criteria cri, Long bno) {
		int cnt=mapper.getCountByBno(bno);
		List<ReplyVO> list=mapper.getListWithPaging(cri, bno);
		
		System.out.println("service......");
		System.out.println("service 전체갯수:"+cnt);
		System.out.println("service 리스트:"+list);
		
		return new ReplyPageDTO(cnt,list);
	}
	
}

package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.mapper.BoardMapper;
import com.project.mapper.ReplyMapper;
import com.project.model.Criteria;
import com.project.model.ReplyPageDTO;
import com.project.model.ReplyPageDTO2;
import com.project.model.ReplyVO;

@Service
public class ReplyServiceImpl implements ReplyService{
//판매 게시판
	@Autowired
	private ReplyMapper mapper;
	
	@Autowired
	private BoardMapper boardMapper;
	
	@Transactional
	@Override
	public int register(ReplyVO vo) {
		System.out.println("register...." + vo);
		boardMapper.updateReplyCnt(vo.getBno(), 1);
		return mapper.insert(vo);
	}

	@Override
	public ReplyVO get(Long rno) {
		System.out.println("get...." + rno);
		return mapper.read(rno);
	}

	@Override
	public int modify(ReplyVO vo) {
		System.out.println("modify...." + vo);
		return mapper.update(vo);
	}

	@Transactional
	@Override
	public int remove(Long rno) {
		System.out.println("remove...." + rno);
		ReplyVO vo = mapper.read(rno);
		boardMapper.updateReplyCnt(vo.getBno(), -1);
		return mapper.delete(rno);
	}

	@Override
	public List<ReplyVO> getList(Criteria cri, Long bno) {
		System.out.println("특정 게시물의 댓글 목록 리스트...." + bno);
		return mapper.getListWithPaging(cri, bno);
	}

	@Override
	public ReplyPageDTO getListPage(Criteria cri, Long bno) {
		return new ReplyPageDTO(
				mapper.getCountByBno(bno),
				mapper.getListWithPaging(cri, bno));
	}
//구매 게시판 끝

//판매 게시판
	
	@Transactional
	@Override
	public int register2(ReplyVO vo) {
		System.out.println("register2...." + vo);
		boardMapper.updateReplyCnt2(vo.getBno2(), 1);
		return mapper.insert2(vo);
	}

	@Override
	public ReplyVO get2(Long rno2) {
		System.out.println("get2...." + rno2);
		return mapper.read2(rno2);
	}

	@Override
	public int modify2(ReplyVO vo) {
		System.out.println("modify2...." + vo);
		return mapper.update2(vo);
	}

	@Transactional
	@Override
	public int remove2(Long rno2) {
		System.out.println("remove2...." + rno2);
		ReplyVO vo = mapper.read2(rno2);
		boardMapper.updateReplyCnt2(vo.getBno2(), -1);
		return mapper.delete2(rno2);
	}

	@Override
	public List<ReplyVO> getList2(Criteria cri, Long bno2) {
		System.out.println("특정 게시물의 댓글 목록 리스트2...." + bno2);
		return mapper.getListWithPaging2(cri, bno2);
	}

	@Override
	public ReplyPageDTO2 getListPage2(Criteria cri, Long bno2) {
		return new ReplyPageDTO2(
				mapper.getCountByBno2(bno2),
				mapper.getListWithPaging2(cri, bno2));
	}

}

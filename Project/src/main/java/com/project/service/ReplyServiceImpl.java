package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.mapper.ReplyMapper;
import com.project.model.Criteria;
import com.project.model.ReplyVO;

@Service
public class ReplyServiceImpl implements ReplyService{

	@Autowired
	private ReplyMapper mapper;

	@Override
	public int register(ReplyVO vo) {
		System.out.println("register...." + vo);
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

	@Override
	public int remove(Long rno) {
		System.out.println("remove...." + rno);
		return mapper.delete(rno);
	}

	@Override
	public List<ReplyVO> getList(Criteria cri, Long bno) {
		System.out.println("특정 게시물의 댓글 목록 리스트...." + bno);
		return mapper.getListPaging(cri, bno);
	}
	
	
}

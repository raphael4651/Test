package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.mapper.BoardMapper;
import com.project.model.BoardVO;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardMapper mapper;
	
	@Override
	public void insert(BoardVO board) {
		mapper.insert(board);
	}

	@Override
	public List<BoardVO> getList() {
		return mapper.getList();
	}

	@Override
	public BoardVO getPage(int tradeBno) {
		return mapper.getPage(tradeBno);
	}

	@Override
	public int modify(BoardVO board) {
		return mapper.modify(board);
	}
	
	
	
}

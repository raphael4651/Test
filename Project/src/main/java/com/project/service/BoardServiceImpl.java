package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.mapper.BoardAttachMapper;
import com.project.mapper.BoardMapper;
import com.project.model.BoardAttachVO;
import com.project.model.BoardVO;
import com.project.model.Criteria;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardMapper mapper;
	
	@Autowired
	private BoardAttachMapper attachMapper;
	
	@Transactional
	@Override
	public void insert(BoardVO board) {
		mapper.insertSelectKey(board);
		
		if(board.getAttachList() == null || board.getAttachList().size() <= 0) {
			return;
		}
		board.getAttachList().forEach(attach ->{
			attach.setBno((long) board.getTradeBno());
			attachMapper.insert(attach);
		});
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

	@Override
	public int delete(int tradeBno) {
		return mapper.delete(tradeBno);
	}

	@Override
	public List<BoardVO> getListPaging(Criteria cri) {
		return mapper.getListPaging(cri);
	}

	@Override
	public int getTotal(Criteria cri) {
		return mapper.getTotal(cri);
	}

	@Override
	public List<BoardAttachVO> getAttachList(Long bno) {
		System.out.println("해당 첨부파일 리스트 가져오기" + bno);
		
		return attachMapper.findByBno(bno);
	}
	
	
	
}

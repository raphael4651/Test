package org.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.project.domain.BoardVO;
import org.project.domain.Criteria;
import org.project.mapper.BoardMapper;

import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	BoardMapper mapper;
	
	@Override
	public void register(BoardVO board) {
		System.out.println("register 실행");
		
		mapper.insertSelectKey(board);
	}
	
//	@Override
//	public List<BoardVO> getList() {
//		System.out.println("getList.....");
//		
//		return mapper.getList();
//	}
	
	@Override
	public List<BoardVO> getList(Criteria cri) {
		System.out.println("getList with criteria:"+cri);
		
		return mapper.getListWithPaging(cri);
	}

	@Override
	public BoardVO get(Long bno) {
		System.out.println("get.....");
		
		return mapper.read(bno);
	}

	@Override
	public boolean modify(BoardVO board) {
		System.out.println("modify....."+board);
		
		return mapper.update(board)==1;
	}

	@Override
	public boolean remove(Long bno) {
		System.out.println("remove....."+bno);
		
		return mapper.delete(bno)==1;
	}

	@Override
	public int getTotal(Criteria cri) {
		System.out.println("get total count");
		return mapper.getTotalCount(cri);
	}		
	
}

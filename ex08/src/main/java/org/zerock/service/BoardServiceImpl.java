package org.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.domain.BoardAttachVO;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.mapper.BoardAttachMapper;
import org.zerock.mapper.BoardMapper;

import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	BoardMapper mapper;
	
	@Autowired
	BoardAttachMapper attachMapper;
	
	@Transactional
	@Override
	public void register(BoardVO board) {
		System.out.println("register 실행");
		
		mapper.insertSelectKey(board);
		
		//첨부파일 없으면 DB 추가 안함
		if(board.getAttachList()==null || board.getAttachList().size()<=0) {
			return;
		}
		
		board.getAttachList().forEach(attach->{
			attach.setBno(board.getBno());
			attachMapper.insert(attach);
		});
	}
	
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

	@Transactional
	@Override
	public boolean modify(BoardVO board) {
		System.out.println("modify....."+board);
		
		attachMapper.deleteAll(board.getBno());
		
		boolean modifyResult=mapper.update(board)==1;
		
		if(modifyResult && board.getAttachList()!=null && board.getAttachList().size()>0) {
			board.getAttachList().forEach(attach->{
				attach.setBno(board.getBno());
				attachMapper.insert(attach);
			});
		}
		
		return modifyResult;
	}

	@Override
	public boolean remove(Long bno) {
		System.out.println("remove....."+bno);
		
		attachMapper.deleteAll(bno);
		
		return mapper.delete(bno)==1;
	}

	@Override
	public int getTotal(Criteria cri) {
		System.out.println("get total count");
		return mapper.getTotalCount(cri);
	}

	@Override
	public List<BoardAttachVO> getAttachList(Long bno) {
		System.out.println("getAttachList 첨부파일 리스트 bno:"+bno);
		
		return attachMapper.findByBno(bno);
	}		
	
}

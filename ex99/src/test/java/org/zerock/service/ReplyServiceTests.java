package org.project.service;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.project.domain.Criteria;
import org.project.domain.ReplyVO;
import org.project.mapper.ReplyMapper;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ReplyServiceTests {

	Long[] bnoArr = {132L,131L,130L,129L,128L};
	
	
	@Autowired
	private ReplyMapper mapper;
	
	@Autowired
	private ReplyService service;
	
	@Test
	public void testCreate() {
		
		IntStream.rangeClosed(1,10).forEach(i->{
			ReplyVO vo=new ReplyVO();
			
			vo.setBno(bnoArr[i % 5]);
			vo.setReply("댓글테스트"+i);
			vo.setReplyer("작성자"+i);
			
			mapper.insert(vo);
		});
	}
	
	@Test
	public void testRead() {
		
		Long targetRno=5L;
		ReplyVO vo=mapper.read(targetRno);
		log.info(vo);
		
	}
	
	@Test
	public void testremove() {
		
		Long targetRno=1L;
		mapper.delete(targetRno);
		
	}

	@Test
	public void testupdate() {
		
		Long targetRno=10L;
		
		ReplyVO vo=mapper.read(targetRno);
		
		vo.setReply("update reply");
		
		int count=mapper.update(vo);
		
		log.info(count);
	}
	

	@Test
	public void testlist() {
		
		Criteria cri=new Criteria();
		
		List<ReplyVO> replies = mapper.getListWithPaging(cri, 130L);
		
		log.info(replies);
		
	}
	
	@Test
	public void testcount() {
		
		int replies = service.getCount(132L);
		
		log.info(replies);
		
	}
	
}







package org.project.mapper;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.project.domain.Criteria;
import org.project.domain.ReplyVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ReplyMapperTests {

	@Autowired
	ReplyMapper mapper;
	
	//게시판에 있는 번호
	Long[] bnoArr= {168L,167L,166L,165L,164L};
	
	@Test
	public void testMapper() {
		System.out.println(mapper);
	}
	
	@Test
	public void testCreate() {
		
		IntStream.rangeClosed(1,10).forEach(i->{
			ReplyVO vo=new ReplyVO();
			vo.setBno(bnoArr[i%5]);
			vo.setReply("댓글 테스트 "+i);
			vo.setReplyer("replyer"+i);
			
			mapper.insert(vo);
		});
	}
	
	@Test
	public void testRead() {
		Long targetRno=5L;
		ReplyVO vo=mapper.read(targetRno);
		System.out.println(vo);
	}
	
	@Test
	public void testDelete() {
		Long targetRno=2L;
		mapper.delete(targetRno);
		System.out.println("삭제완료");
	}
	
	@Test
	public void testUpdate() {
		Long targetRno=3L;
		
		ReplyVO vo=mapper.read(targetRno);
		vo.setReply("수정 댓글3");
		
		int count=mapper.update(vo);
		
		System.out.println("수정 갯수:"+count);		
	}
	
	@Test
	public void testList() {
		Criteria cri=new Criteria();
		List<ReplyVO> replies=mapper.getListWithPaging(cri, bnoArr[0]);
	}
	
	@Test
	public void testList2() {
		Criteria cri=new Criteria(2,10);
		List<ReplyVO> replies=mapper.getListWithPaging(cri, 168L);
		replies.forEach(reply->System.out.println(reply));
	}
	
}


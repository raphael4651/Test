package com.project.mapper;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.project.model.Criteria;
import com.project.model.ReplyVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class ReplyMapperTests {

	//게시판에 있는 번호
	Long[] bnoArr= {222L,221L,220L,219L,218L};
	
	@Autowired
	private ReplyMapper mapper;
	
	//댓글 데이터베이스 연결 테스트
	@Test
	public void testMapper() {
		System.out.println(mapper);
	}
	
	//댓글 등록 테스트
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
	
	//댓글 조회 테스트
	@Test
	public void testRead() {
		Long targetRno=4L;
		ReplyVO vo=mapper.read(targetRno);
		System.out.println(vo);
	}
	
	//댓글 삭제 테스트
	@Test
	public void testDelete() {
		Long targetRno = 4L;
		mapper.delete(targetRno);
	}
	
	//댓글 수정 테스트
	@Test
	public void testUpdate() {
		Long targetRno = 5L;
		ReplyVO vo = mapper.read(targetRno);
		vo.setReply("update reply");
		int count = mapper.update(vo);
		System.out.println(count);
	}
	
	//특정 게시물의 댓글 조회 테스트
	@Test
	public void testList() {
		Criteria cri = new Criteria();
		List<ReplyVO> replies = mapper.getListWithPaging(cri, bnoArr[0]);
		
		replies.forEach(reply -> System.out.println("" + reply));
		
	}
	
	//댓글 페이징 처리 테스트
	@Test
	public void testList2() {
		Criteria cri = new Criteria(1, 10);
		List<ReplyVO> replies = mapper.getListWithPaging(cri, 220L);
		replies.forEach(reply -> System.out.println(""+ reply));
	}
	
}

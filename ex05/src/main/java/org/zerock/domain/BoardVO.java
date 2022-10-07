package org.project.domain;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class BoardVO {
	
	Long bno;
	String title;
	String content;
	String writer;
	Date regdate;
	Date updateDate;
	
	int replyCnt;
	
	List<BoardAttachVO> attachList;
}

package org.project.domain;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class BoardVO {

	Long bno;
	String cgo,title,content,writer;
	Date regdate, updateDate;
	
	int replycnt;
	
	List<BoardAttachVO> attachList;
	
}

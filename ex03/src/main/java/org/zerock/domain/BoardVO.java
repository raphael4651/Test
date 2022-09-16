package org.zerock.domain;

import java.util.Date;

import lombok.Data;

@Data
public class BoardVO {
	
	Long bno;
	String title;
	String content;
	String writer;
	Date regdate;
	Date updateDate;
}

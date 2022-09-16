package com.project.model;

import java.util.Date;

import lombok.Data;

@Data
public class BoardVO {
	//게시글 번호
	private int tradeBno;
	//게시글 제목
	private String tradeTitle;
	//게시글 내용
	private String tradeContent;
	//게시글 작성자
	private String tradeWriter;
	//게시글 작성일자
	private Date tradeRegdate;
	//게시글 수정일자
	private Date tradeUpdatedate;
	//게시글 댓글 수
	private int tradeReplyCnt;
	
	
}

package org.project.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class TodoDTO {
	
	String title;
	
	@DateTimeFormat(pattern="yyyy/MM/dd")
	Date dueDate;
}

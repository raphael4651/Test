package org.zerock.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;


@Data
@AllArgsConstructor
//Data는 기본생성자만 만들어주고
//AllArgsConstructor은 기본 생성자를 제외한 생성자를 만들어준다.
//NoArgsConstructor은 기본생성자를 만들어 준다.
@Getter
public class ReplyPageDTO {
	
	private int replyCnt;
	private List<ReplyVO> list;
}

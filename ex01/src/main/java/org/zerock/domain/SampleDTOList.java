package org.zerock.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class SampleDTOList {
	
	List<SampleDTO> list;
	
	public SampleDTOList() {
		list=new ArrayList<>();
	}
}

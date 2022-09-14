package org.zerock.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.mapper.Sample1Mapper;
import org.zerock.mapper.Sample2Mapper;

@Transactional
@Service
public class SampleTxServiceImpl implements SampleTxService{
	
	@Autowired
	private Sample1Mapper mapper1;
	
	@Autowired
	private Sample2Mapper mapper2;

	@Override
	public void addData(String value) {
		
		System.out.println("mapper1.........");
		mapper1.insertCol1(value);
		
		System.out.println("mapper2.........");
		mapper2.insertCol2(value);
		
		System.out.println("end.............");
	}
}

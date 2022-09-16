package org.zerock.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.mapper.Sample1Mapper;
import org.zerock.mapper.Sample2Mapper;

@Service
public class SampleTxServiceImpl implements SampleTxService{

	@Autowired
	Sample1Mapper mapper1;
	
	@Autowired
	Sample2Mapper mapper2;
	
	@Transactional
	@Override
	public void addData(String value) {
		System.out.println("mapper1.....");
		mapper1.insertCol1(value);
		
		System.out.println("mapper2.....");
		mapper2.insertCol2(value);
	}

}

package org.zerock.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {

	@Select("SELECT sysdate FROM dual")
	public String getTime();
	//@Select("SQL문")을 사용해서 실행
	
	public String getTime2();
	//TimeMapper.xml을 호출해서 사용
}

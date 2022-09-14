package org.zerock.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
	//@Data에 포함된 어노테이션
	//@ToString
	//@Getter
	//@Setter
	//@RequiredArgsConstructor 생성자생성
	//@Data를 쓰지않고 필요한 것만 어노테이션해서 생성할 수 있다.
public class Restaurant {
	
	@Autowired
	/* @Setter(onMethod_ =@Autowired) */
	private Chef chef;
	// Chef chef = new Chef();
	// Restaurant restaurant = new Restaurant();
	// restaurant.setChef(chef);
	// 를 스프링에서 자동으로 넣어준 것
}

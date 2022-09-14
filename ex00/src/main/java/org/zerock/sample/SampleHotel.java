package org.zerock.sample;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Component
@ToString
@Getter
@AllArgsConstructor 
//모든 생성자를 만든다
public class SampleHotel {
	
	private Chef chef;

	/*
	 * public SampleHotel(Chef chef) { super(); this.chef = chef; }
	 */
	
	
}

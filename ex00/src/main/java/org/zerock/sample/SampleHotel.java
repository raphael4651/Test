package org.project.sample;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Component
@ToString
@Getter
@AllArgsConstructor
//@RequiredArgsConstructor
public class SampleHotel {
	
	@NonNull
	private Chef chef;

//	public SampleHotel(Chef chef) {
//		this.chef = chef;
//	}
}

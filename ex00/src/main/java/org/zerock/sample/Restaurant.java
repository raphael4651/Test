package org.project.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
//@ToString
//@Getter
//@Setter
//@RequiredArgsConstructor
public class Restaurant {

	@Autowired
	private Chef chef;

	
}

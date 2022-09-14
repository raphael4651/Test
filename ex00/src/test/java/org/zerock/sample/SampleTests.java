package org.zerock.sample;

import static org.junit.Assert.assertNotNull;

//junit은 src/test/java 에서 사용
import org.junit.Test;
import org.junit.runner.RunWith;
//spring 에서 test 라이브러리가 필요하다. 즉 src/test/java에서 사용
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;




@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class SampleTests {
	
	@Setter(onMethod_ = {@Autowired})
	private Restaurant restaurant;
	// @Autowired (or @Inject)
	// private Restaurant restaurant; 
	// 라고도 사용할 수 있다. 위의 것이 개선된 것이나 동작하는덴 차이가없다.
	
	@Test
	public void testExist() {
	// junit test를 위해서 이름을 test로 시작하게 만든다
	// 메소드 이름 우클릭 후  run as test로 메소드단위 test도 가능하다
		
		assertNotNull(restaurant);
		//junit에서 static으로 만들어 놓은 것
		//assert NotNull, True 등 여러가지가 있다.
		
		log.info(restaurant);
		// INFO값 : org.zerock.sample.SampleTests - Restaurant(chef=Chef())
		// .info error 등으로 다른 명령어를 통해 색깔 구분을 할 수 있다.
		// 메세지를 구분
		log.error("------------------");
		log.info(restaurant.getChef());
		//log와 System.out.println과 콘솔창 출력자체는 같으나 정보량이 다름
	}
}

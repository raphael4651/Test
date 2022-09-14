package org.zerock.aop;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect		//AOP
@Component	//객체생성
public class LogAdvice {

	@Before( "execution(* org.zerock.service.SampleService*.doAdd(String, String)) && args(str1, str2)")
	//Before 제일 먼저 실행 / 기준점()/ execution(* : 리턴타입이 모두 가능
	//SampleService* : 로 시작하는 모든 것(인터페이스, 자바 등 모두가능)
	// ...service*.*(..)) .*: 모든 메소드 (..): 최소한 한개 이상의 전달값이 있다.
	
	//자바파일(콘트롤러, 이름 등등)을 실행하기 이전에 무조건 먼저 실행한다.
	public void logBefore(String str1, String str2) {
		System.out.println("=====AOP Before=====");
		System.out.println("str1 : " + str1);
		System.out.println("str2 : " + str2);
	}
	
	@AfterThrowing(pointcut = "execution(* org.zerock.service.SampleService*.*(..))", throwing="exception")
	public void logException(Exception exception) {
		System.out.println("Exception....!!!!");
		System.out.println("exception : " + exception);
	}
	
	@Around("execution(* org.zerock.service.SampleService*.*(..))")
	public Object logTime(ProceedingJoinPoint pjp) {
		long start = System.currentTimeMillis();
		
		System.out.println("Target: " + pjp.getTarget());
		System.out.println("param : " + Arrays.toString(pjp.getArgs()));
		
		Object result = null;
		
		try {
			result = pjp.proceed();
		}catch(Throwable e) {
			e.printStackTrace();
		}
		
		long end = System.currentTimeMillis();
		
		System.out.println("Time : " + (end - start));
		
		return result;
		
		
		/*
		 * Target: org.zerock.service.SampleServiceImpl@106cc338 //Around 
		 * param : [123, 456]									 //Around
		 * =====AOP Before===== 								 //Before
		 * str1 : 123 str2 : 456 								 //Before
		 * Time : 3 											 //Around
		 * 579													 //TestCode
		 */

	}
}

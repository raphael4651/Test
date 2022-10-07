package org.project.aop;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j;

@Aspect
@Log4j
@Component
public class LogAdvice {

	@Before("execution(* org.project.service.SampleService*.*(..))")
	public void logBefore() {
		System.out.println("================");
	}
	
	@Before("execution(* org.project.service.SampleService*.*(..)) && args(str1,str2)")
	public void logBeforeWithParam(String str1,String str2) {
		System.out.println("str1:"+str1);
		System.out.println("str2:"+str2);
	}
	
	@AfterThrowing(
			pointcut="execution(* org.project.service.SampleService*.*(..))",
			throwing="e")
	public void logException(Exception e) {
		System.out.println("Exception.....!!!!!");
		System.out.println("exception:"+e);
	}
	
	@Around("execution(* org.project.service.SampleService*.*(..))")
	public Object logTime(ProceedingJoinPoint pjp) {
		long start=System.currentTimeMillis();
		
		System.out.println("Target:"+pjp.getTarget());
		System.out.println("Param:"+Arrays.toString(pjp.getArgs()));
		
		Object result=null;
		
		try {
			result=pjp.proceed();
		}catch(Throwable e) {
			e.printStackTrace();
		}
		long end=System.currentTimeMillis();
		
		System.out.println("TIME:"+(end-start));
		
		return result;
	}
}

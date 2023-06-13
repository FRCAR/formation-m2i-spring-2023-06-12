package com.bigcorp.booking.correction.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggerAspect{
	
	@Before("(execution(public * com.bigcorp.booking.correction.service.*.*(..)))")
	public void doLog() {
		System.out.println("La méthode va être appelée");
	}
	
	@AfterReturning(pointcut="(execution(public * com.bigcorp.booking.correction.service.*.*(..)))"
			,returning = "valeurRetournee")
	public void doLogAfter(Object valeurRetournee) {
		System.out.println("La méthode a été appelée, et a renvoyé : " + valeurRetournee);
	}
	
	@AfterThrowing(pointcut="(execution(public * com.bigcorp.booking.correction.service.*.*(..)))"
			,throwing = "exceptionLancee")
	public void doLogWhenThrowing(Throwable exceptionLancee) {
		System.out.println(exceptionLancee.getMessage());
	}
	
}

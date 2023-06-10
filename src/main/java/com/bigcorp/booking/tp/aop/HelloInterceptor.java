package com.bigcorp.booking.tp.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component // Le bean sera placé dans le contexte Spring
@Aspect // Il servira d’aspect
public class HelloInterceptor {

	@AfterReturning(pointcut= "execution(public * com.bigcorp.booking.tp.service.*.sayHello(..))",
			returning ="monArgument")
	public void log(Object monArgument) {
		System.out.println("Je suis appelée, ma valeur de retour vaut : " + monArgument);
	}
	
	
	@Around(value = "execution(public * com.bigcorp.booking.tp.service.*.*(..))")
	public Object computeTime(ProceedingJoinPoint pjp) throws Throwable{
		long startTimeMillis = System.currentTimeMillis();
		Object returnValue = pjp.proceed();
		long endTimeMillis = System.currentTimeMillis();
		System.out.println("Ai mis : " + (endTimeMillis - startTimeMillis) + " pour exécuter la méthode" );
		return returnValue;
	}
	
}

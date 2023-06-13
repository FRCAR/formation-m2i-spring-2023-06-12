package com.bigcorp.booking.correction.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
/**
 * Ce component est annoté avec @Aspect pour
 * définir des Advices des comportement transverses
 */
@Component
@Aspect
public class LoggerAspect{
	
	/**
	 * Cette méthode s'exécute avant toute méthode publique du package service
	 */
	@Before("(execution(public * com.bigcorp.booking.correction.service.*.*(..)))")
	public void doLog() {
		System.out.println("La méthode va être appelée");
	}
	
	/**
	 * Celle-ci s'exécute après toute méthode publique du package service qui se termine correctement.
	 * La valeur renvoyée par la méthode s'affiche sur la console.
	 * @param valeurRetournee
	 */
	@AfterReturning(pointcut="(execution(public * com.bigcorp.booking.correction.service.*.*(..)))"
			,returning = "valeurRetournee")
	public void doLogAfter(Object valeurRetournee) {
		System.out.println("La méthode a été appelée, et a renvoyé : " + valeurRetournee);
	}
	
	/**
	 * Celle-ci s'exécute après toute méthode publique du package service qui lance une exception.
	 * La valeur renvoyée par la méthode s'affiche sur la console.
	 * @param valeurRetournee
	 */
	@AfterThrowing(pointcut="(execution(public * com.bigcorp.booking.correction.service.*.*(..)))"
			,throwing = "exceptionLancee")
	public void doLogWhenThrowing(Throwable exceptionLancee) {
		System.out.println(exceptionLancee.getMessage());
	}
	

	/**
	 * Celle-ci s'exécute autour de toute méthode publique du package service.
	 * Elle logue le temps que prend la méthode
	 * @param valeurRetournee
	 */
	@Around(value = "execution(public * com.bigcorp.booking.correction.service.*.*(..))")
	public Object computeTime(ProceedingJoinPoint pjp) throws Throwable{
		long startTimeMillis = System.nanoTime();
		Object returnValue = pjp.proceed();
		long endTimeMillis = System.nanoTime();
		System.out.println("Ai mis : " + (endTimeMillis - startTimeMillis) + " ns pour exécuter la méthode" );
		return returnValue;
	}
	
}

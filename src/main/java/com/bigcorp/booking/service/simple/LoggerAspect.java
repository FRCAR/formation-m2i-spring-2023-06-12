package com.bigcorp.booking.service.simple;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component // Le bean sera placé dans le contexte Spring
@Aspect // Il servira d’aspect
public class LoggerAspect {

	@Before("execution(public * com.bigcorp.booking.service.simple.*.*(..))")
	// pointcut : méthode exécutée quand la cible sera elle-même exécutée
	public void log() {
		System.out.println("Une méthode a été appelée");
	}
}
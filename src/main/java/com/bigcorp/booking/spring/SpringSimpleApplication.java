package com.bigcorp.booking.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bigcorp.booking.bean.subpackage.Child;


public class SpringSimpleApplication {

	public static void main(String[] args) {
		try(AnnotationConfigApplicationContext appContext
				= new AnnotationConfigApplicationContext()){
			
			appContext.scan("com.bigcorp.booking.bean");
			appContext.refresh();
			
			Child child = appContext.getBean(Child.class);
			child.afficheSalut();
			System.out.println("Toy == null ? " + (child.getToy() == null));
			
		}
	}

}
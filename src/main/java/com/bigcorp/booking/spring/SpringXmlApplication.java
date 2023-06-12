package com.bigcorp.booking.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bigcorp.booking.bean.subpackage.Child;
import com.bigcorp.booking.bean.subpackage.Toy;

public class SpringXmlApplication {

	public static void main(String[] args) {
		// Instanciation du contexte Spring 
		try(ClassPathXmlApplicationContext appContext 
				= new ClassPathXmlApplicationContext("beans.xml")){
			
			// Récupération du bean child du contexte 
			Child child = appContext.getBean(Child.class);
			
			// Test des beans Spring
			System.out.println(child.getNom());
			Toy toy = child.getToy();
			
			System.out.println("Toy == null ? " + (toy == null));
			
		}
		
	}

}
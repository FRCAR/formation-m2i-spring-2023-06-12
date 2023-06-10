package com.bigcorp.booking.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SprintXmlApplication {

	public static void main(String[] args) {
		try (ClassPathXmlApplicationContext appContext 
				= new ClassPathXmlApplicationContext("beans.xml")) {
			//récupérer ici un bean du contexte Spring avec appContext.getBean

		}
		
		//Récupérer une instance de MonControleurWeb 
	
//		try (AnnotationConfigApplicationContext appContext = 
//				new AnnotationConfigApplicationContext(SpringConfiguration.class)) {
//			MonControleurWeb monControleurWeb = appContext.getBean(MonControleurWeb.class);	
//			
//			System.out.println(monControleurWeb.getMonService().getMonDao());
//			monControleurWeb.getMonService().getMonDao().save(null);
//			
//		}
	
	
	}

}
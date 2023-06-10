package com.bigcorp.booking.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bigcorp.booking.jdbcdao.ExampleJdbcDao;
import com.bigcorp.booking.jdbcdao.ExampleJdbcNamedDao;
import com.bigcorp.booking.model.Example;
import com.bigcorp.booking.spring.simple.configuration.SpringJdbcTemplateConfiguration;

public class SpringJdbcTemplateApplication {

	public static void main(String[] args) {
		try (AnnotationConfigApplicationContext appContext 
				= new AnnotationConfigApplicationContext(SpringJdbcTemplateConfiguration.class)) {
			
			//Récupérer ici une instance d'un DAO JDBC
			ExampleJdbcDao exampleJdbcDao 
				= appContext.getBean(ExampleJdbcDao.class);
			exampleJdbcDao.dropAndCreateTable();
			Example example = new Example();
			example.setId(1l);
			String nomExemple = "Mon exemple";
			example.setNom(nomExemple);
			exampleJdbcDao.insert(example);
			exampleJdbcDao.findByNom(nomExemple).forEach(e -> System.out.println("J'ai trouvé l'exemple avec l'id : %1$s et le nom %2$s".formatted(e.getId(), e.getNom())));

			ExampleJdbcNamedDao exampleJdbcNamedDao 
				= appContext.getBean(ExampleJdbcNamedDao.class);
			exampleJdbcNamedDao.findByNom(nomExemple).forEach(e -> System.out.println("Avec le JdbcNamed, j'ai trouvé l'exemple avec l'id : %1$s et le nom %2$s".formatted(e.getId(), e.getNom())));
		}
		

	
	
	}

}
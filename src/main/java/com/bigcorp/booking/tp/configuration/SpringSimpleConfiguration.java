package com.bigcorp.booking.tp.configuration;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

//Déclare un bean de configuration
//ce bean va créer d'autres instances
@Configuration
//
////Scanne les composants trouvés dans le
////package fourni en paramètre
@EnableAspectJAutoProxy
@ComponentScan("com.bigcorp.booking.tp.service")
@EnableJpaRepositories("com.bigcorp.booking.tp.dao")
public class SpringSimpleConfiguration {

	// Définit le nom de l'unité de persistence
	private static final String PERSISTENCE_UNIT_NAME = "persistence-unit";

	/**
	 * Crée une entityManagerFactory, utilisée pour créer des entityManagers
	 * 
	 * @return
	 */
	@Bean
	public EntityManagerFactory entityManagerFactory() {
		return Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	}

	@Bean(name = "transactionManager")
	public PlatformTransactionManager dbTransactionManager(EntityManagerFactory emf) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(
				emf);
		return transactionManager;
	}

	@Bean
	public DataSource myH2DataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:file:~/h2-data/formation-spring-jdbc-template");
		dataSource.setUsername("test");
		dataSource.setPassword("test");

		return dataSource;
	}

}
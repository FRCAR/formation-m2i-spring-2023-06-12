package com.bigcorp.booking.correction.configuration;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.bigcorp.booking.correction.service.HyperBean;
import com.bigcorp.booking.correction.service.SuperBean;

@Configuration
@ComponentScan({ "com.bigcorp.booking.correction.service", "com.bigcorp.booking.correction.aspect",
		"com.bigcorp.booking.correction.dao.jdbc" })
@EnableJpaRepositories("com.bigcorp.booking.correction.dao.jpa")
//@EnableAspectJAutoProxy
@EnableTransactionManagement
@PropertySource("classpath:mon-application.properties")
public class TpServiceConfiguration {

	// Définit le nom de l'unité de persistence
	private static final String PERSISTENCE_UNIT_NAME = "persistence-unit";

	@Bean
	public SuperBean superBean() {
		return new SuperBean();
	}

	@Bean
	@Profile("sebastien")
	public HyperBean monHyperBeanAvecNomDefini() {
		return new HyperBean("Profil Sébastien actif");
	}

	@Bean
	@Profile("!sebastien")
	public HyperBean hyperBean2() {
		return new HyperBean("Profil Sébastien inactif");
	}

	@Bean
	public DataSource myH2DataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:file:~/h2-data/formation-spring-2023-06");
		dataSource.setUsername("test");
		dataSource.setPassword("test");
		return dataSource;
	}
	
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

}

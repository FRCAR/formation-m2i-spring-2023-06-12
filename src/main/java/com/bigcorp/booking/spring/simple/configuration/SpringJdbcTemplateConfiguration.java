package com.bigcorp.booking.spring.simple.configuration;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan("com.bigcorp.booking.jdbcdao")
public class SpringJdbcTemplateConfiguration {
	
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
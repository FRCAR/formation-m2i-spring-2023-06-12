package com.bigcorp.booking.correction.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

import com.bigcorp.booking.correction.service.HyperBean;
import com.bigcorp.booking.correction.service.SuperBean;

@Configuration
@ComponentScan("com.bigcorp.booking.correction.service")
@PropertySource("classpath:mon-application.properties")
public class TpServiceConfiguration {
	
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
	
}

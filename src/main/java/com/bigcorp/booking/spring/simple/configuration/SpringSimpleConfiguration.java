package com.bigcorp.booking.spring.simple.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

//Déclare un bean de configuration
//ce bean va créer d'autres instances
@Configuration

//Scanne les composants trouvés dans le
//package fourni en paramètre
@ComponentScan("com.bigcorp.booking.service")
@EnableAspectJAutoProxy
public class SpringSimpleConfiguration {

}
package com.bigcorp.booking.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.bigcorp.booking.model.Example;
import com.bigcorp.booking.spring.simple.configuration.SpringSimpleConfiguration;

@SpringJUnitConfig(SpringSimpleConfiguration.class)
public class ExampleServiceTest {
	
	@Autowired
	private ExampleService exampleService;

	@Test
	void testSave() {
		Example example = new Example();
		exampleService.save(example);
		Assertions.assertNotNull(example);
	}

}

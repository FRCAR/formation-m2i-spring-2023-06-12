package com.bigcorp.booking.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.bigcorp.booking.correction.configuration.TpServiceConfiguration;
import com.bigcorp.booking.correction.model.Plane;
import com.bigcorp.booking.correction.service.PlaneService;

@SpringJUnitConfig(TpServiceConfiguration.class)
public class PlaneServiceTest {
	
	@Autowired
	private PlaneService planeService;

	@Test
	void testSave() {
		Plane plane = new Plane();
		Plane savedPlane = planeService.save(plane);
		Assertions.assertNotNull(savedPlane.getId());
	}

}

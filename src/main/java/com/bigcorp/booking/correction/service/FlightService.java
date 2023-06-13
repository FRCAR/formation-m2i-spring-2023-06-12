package com.bigcorp.booking.correction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.bigcorp.booking.correction.dao.jpa.FlightDao;
import com.bigcorp.booking.correction.model.Flight;

@Component
public class FlightService {
	
	@Autowired
	private FlightDao flightDao;

	public void sayHello() {
		System.out.println("Hello");
	}
	
	@Transactional
	public void save(Flight flight) {
		flightDao.save(flight);
	}

}

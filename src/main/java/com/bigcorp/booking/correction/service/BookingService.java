package com.bigcorp.booking.correction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookingService {
	
	@Autowired
	private FlightService flightService;
	
	@Autowired
	private HyperBean hyperBean;

	public FlightService getFlightService() {
		return flightService;
	}

	public void setFlightService(FlightService flightService) {
		this.flightService = flightService;
	}

	public HyperBean getHyperBean() {
		return hyperBean;
	}

	

}

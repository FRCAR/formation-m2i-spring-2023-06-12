package com.bigcorp.booking.correction;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bigcorp.booking.correction.configuration.TpServiceConfiguration;
import com.bigcorp.booking.correction.service.BookingService;
import com.bigcorp.booking.correction.service.FlightService;


public class CorrectionServiceAnnotationLauncher {

	public static void main(String[] args) {

		// Instanciation du contexte Spring 
		try(AnnotationConfigApplicationContext appContext
				= new AnnotationConfigApplicationContext()){
			
			appContext.register(TpServiceConfiguration.class);
			appContext.refresh();
			
			FlightService flightService = appContext.getBean(FlightService.class);
			flightService.sayHello();
			
			BookingService bookingService = appContext.getBean(BookingService.class);
			bookingService.getFlightService().sayHello();
			
		}
	}

}
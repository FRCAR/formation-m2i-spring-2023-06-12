package com.bigcorp.booking.correction;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bigcorp.booking.correction.service.BookingService;
import com.bigcorp.booking.correction.service.FlightService;


public class CorrectionServiceAnnotationScanLauncher {

	public static void main(String[] args) {

		// Instanciation du contexte Spring 
		try(AnnotationConfigApplicationContext appContext
				= new AnnotationConfigApplicationContext()){

			//Scan du contexte 
			appContext.scan("com.bigcorp.booking.correction");
			appContext.refresh();
			
			// Récupération du bean child du contexte 
			FlightService flightService = appContext.getBean(FlightService.class);
			flightService.sayHello();
			
			BookingService bookingService = appContext.getBean(BookingService.class);
			bookingService.getFlightService().sayHello();
			
		}
	}

}
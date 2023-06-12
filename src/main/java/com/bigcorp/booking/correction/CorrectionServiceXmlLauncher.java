package com.bigcorp.booking.correction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bigcorp.booking.correction.service.BookingService;
import com.bigcorp.booking.correction.service.FlightService;

public class CorrectionServiceXmlLauncher {

	public static void main(String[] args) {
		// Instanciation du contexte Spring 
		try(ClassPathXmlApplicationContext appContext 
				= new ClassPathXmlApplicationContext("correction-beans.xml")){
			
			// Récupération du bean child du contexte 
			FlightService flightService = appContext.getBean(FlightService.class);
			flightService.sayHello();
			
			BookingService bookingService = appContext.getBean(BookingService.class);
			bookingService.getFlightService().sayHello();
			
		}
		
	}

}
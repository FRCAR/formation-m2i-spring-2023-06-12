package com.bigcorp.booking.correction;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bigcorp.booking.correction.configuration.TpServiceConfiguration;
import com.bigcorp.booking.correction.service.BookingService;
import com.bigcorp.booking.correction.service.FlightService;
import com.bigcorp.booking.correction.service.HyperBean;
import com.bigcorp.booking.correction.service.PlaneService;
import com.bigcorp.booking.correction.service.SuperBean;

public class CorrectionServiceAnnotationLauncher {

	public static void main(String[] args) {

		// Instanciation du contexte Spring
		try (AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext()) {

			appContext.register(TpServiceConfiguration.class);
			appContext.refresh();

			FlightService flightService = appContext.getBean(FlightService.class);
			flightService.sayHello();

			BookingService bookingService = appContext.getBean(BookingService.class);
			bookingService.getFlightService().sayHello();

			SuperBean superBean = appContext.getBean(SuperBean.class);
			System.out.println("superBean != null ? " + (superBean != null));

			System.out.println("bookingService.getHyperBean() != null ? "
					+ (bookingService.getHyperBean() != null));

			System.out.println("Max plane : " + appContext.getBean(PlaneService.class).getMaxPlane());

			try {
				System.out.println("Le bean de type : HyperBean dans le contexte est : "
						+ appContext.getBean(HyperBean.class).getName());
			} catch (Exception e) {
				System.out.println("Non mais en fait ça va.");
			}

		}
	}

}
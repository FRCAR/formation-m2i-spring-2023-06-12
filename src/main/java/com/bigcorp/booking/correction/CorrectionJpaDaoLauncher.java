package com.bigcorp.booking.correction;

import java.time.LocalDateTime;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bigcorp.booking.correction.configuration.TpServiceConfiguration;
import com.bigcorp.booking.correction.model.Flight;
import com.bigcorp.booking.correction.service.BookingService;
import com.bigcorp.booking.correction.service.FlightService;

public class CorrectionJpaDaoLauncher {

	public static void main(String[] args) {

		// Instanciation du contexte Spring
		try (AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext()) {

			appContext.register(TpServiceConfiguration.class);
			appContext.refresh();
			
			Flight flight = new Flight();
			LocalDateTime departureTime = LocalDateTime.of(2023, 6, 1, 10, 45, 00);
			flight.setDeparture(departureTime);
			flight.setArrival(LocalDateTime.of(2023, 6, 1, 12, 45, 00));
			flight.setFrom("Paris");
			flight.setTo("Berlin");
			
			FlightService flightService = appContext.getBean(FlightService.class);
			flightService.save(flight);
			
			BookingService bookingService = appContext.getBean(BookingService.class);
			
			bookingService.createBooking(flight, "Jean", "Dupont");
			
			System.out.println("Il y a " + bookingService.findByNames("Jean","DUpOnT").size() + " bookings trouvés.");
			
			LocalDateTime threeHoursBeforeDeparture = departureTime.minusHours(3);
			LocalDateTime threeHoursAfterDeparture = departureTime.plusHours(3);
			
			
			System.out.println("Bookings après " +  threeHoursBeforeDeparture + " :");
			bookingService.findByFlightDepartureAfter(threeHoursBeforeDeparture).forEach(System.out::println);

			System.out.println("Bookings après " +  departureTime + " :");
			bookingService.findByFlightDepartureAfter(departureTime).forEach(System.out::println);
			
			System.out.println("Bookings après " +  threeHoursAfterDeparture + " :");
			bookingService.findByFlightDepartureAfter(threeHoursAfterDeparture).forEach(System.out::println);
		}
	}

}
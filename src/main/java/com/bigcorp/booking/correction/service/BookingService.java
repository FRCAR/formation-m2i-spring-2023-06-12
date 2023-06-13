package com.bigcorp.booking.correction.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bigcorp.booking.correction.dao.jpa.BookingDao;
import com.bigcorp.booking.correction.model.Booking;
import com.bigcorp.booking.correction.model.Flight;

@Component
public class BookingService {

	@Autowired
	private FlightService flightService;

	@Autowired
	private HyperBean hyperBean;

	@Autowired
	private BookingDao bookingDao;

	public FlightService getFlightService() {
		return flightService;
	}

	public void setFlightService(FlightService flightService) {
		this.flightService = flightService;
	}

	public HyperBean getHyperBean() {
		return hyperBean;
	}
	
	public List<Booking> findByNames(String firstName, String lastName){
		return bookingDao.findByFirstNameAndLastNameIgnoreCase(firstName, lastName);
	}
	
	public List<Booking> findByFlightDepartureAfter(LocalDateTime minTime){
		return bookingDao.findByFlightDepartureGreaterThanEqual(minTime);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public Booking createBooking(String firstName, String lastName) {
		Booking booking = new Booking();
		booking.setFirstName(firstName);
		booking.setLastName(lastName);
		bookingDao.save(booking);
		return booking;
	}

	@Transactional
	public Booking createBooking(Flight flight, String firstName, String lastName) {
		Booking booking = new Booking();
		booking.setFirstName(firstName);
		booking.setLastName(lastName);
		booking.setFlight(flight);
		bookingDao.save(booking);
		return booking;
	}
	
}
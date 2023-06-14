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
	public void deleteById(Long id) {
		flightDao.deleteById(id);
	}
	
	/**
	 * Sauvegarde flight. Renvoie 
	 * un Flight qu'il vaut mieux utiliser pour la suite : 
	 * la persistence peut avoir changé l'objet
	 * @param flight
	 * @return
	 */
	@Transactional
	public Flight save(Flight flight) {
		return flightDao.save(flight);
	}
	
	@Transactional
	public void findById(Long id) {
		flightDao.findById(id);
	}

}

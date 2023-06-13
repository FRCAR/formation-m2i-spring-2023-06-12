package com.bigcorp.booking.correction.dao.jpa;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bigcorp.booking.correction.model.Flight;

@Repository
public interface FlightDao extends CrudRepository<Flight, Long>{
	
	//Récupérer les vols(Flight) par from.
	List<Flight> findByFrom(String from);
	
	//Récupérer les réservations des vols par to : la liste des réservations des vols qui arrivent à un aéroport.
	List<Flight> findByTo(String to);
	
	//Récupérer les vols à partir d’une certaine date
	List<Flight> findByDepartureGreaterThan(LocalDateTime minDeparture);
	
	

}
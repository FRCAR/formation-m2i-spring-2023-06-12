package com.bigcorp.booking.correction.dao.jpa;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bigcorp.booking.correction.model.Booking;

@Repository
public interface BookingDao extends CrudRepository<Booking, Long>{
	
	@Query("select b from Booking b where b.firstName = :firstName")
	List<Booking> superFind(@Param("firstName") String firstName);
	
	//Récupérer les réservations (Booking) par lastName.
	List<Booking> findByLastName(String lastName);
	
	//Récupérer les réservations par  firstName et lastName
	List<Booking> findByFirstNameAndLastNameIgnoreCase(String firstName, String lastName);
	
	//Récupérer les réservations par  firstName et lastName sans tenir compte de la casse
	List<Booking> findByFirstNameAndLastNameAllIgnoreCase(String firstName, String lastName);
	
	//Récupérer les réservations des vols à partir d’une certaine date
	List<Booking> findByFlightDepartureGreaterThanEqual(LocalDateTime minDeparture);

}
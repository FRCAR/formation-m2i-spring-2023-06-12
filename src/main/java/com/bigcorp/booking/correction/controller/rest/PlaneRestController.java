package com.bigcorp.booking.correction.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.bigcorp.booking.correction.model.Plane;
import com.bigcorp.booking.correction.service.PlaneService;

@RestController
@RequestMapping("/rest/v1/planes")
public class PlaneRestController {
	
	@Autowired 
	private PlaneService planeService;
	
	@GetMapping(path="/{id}")
	public Plane getById(@PathVariable("id") Long id) {
		Plane plane = planeService.findById(id);
		if(plane == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No plane found");
		}
		return plane;
	}

}

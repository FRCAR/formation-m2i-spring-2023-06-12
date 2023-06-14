package com.bigcorp.booking.correction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bigcorp.booking.correction.model.Plane;
import com.bigcorp.booking.correction.service.PlaneService;

@Controller
public class PlaneController {

	@Autowired
	private PlaneService planeService;

	@RequestMapping(path = "/planes", method = RequestMethod.GET)
	public ModelAndView getPlanes() {
		return new ModelAndView("planes", "planes", planeService.findAll());
	}

	@RequestMapping(path = "/plane-detail", method = RequestMethod.GET)
	public ModelAndView getCamionParIdAvecParametreDeRequete(@RequestParam(name = "id") Long id) {
		return new ModelAndView("plane-detail", "plane", planeService.findById(id));
	}

	@PostMapping("/plane-detail")
	public ModelAndView processSubmit(@ModelAttribute("plane") Plane plane, BindingResult result) {
		ModelAndView mav = new ModelAndView("plane-detail");
		mav.addObject("plane", plane);
		if (result.hasErrors()) {
			return mav;
		}
		// else
		Plane savedPlane = planeService.save(plane);
		mav.addObject("plane", savedPlane);
		return mav;
	}

}
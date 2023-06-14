package com.bigcorp.booking.correction.controller;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MonPremierControleur {
	
	@RequestMapping(path="/salut",method = RequestMethod.GET )
	public String getSalut() {
		return "vue-salut";
	}
	
	@ModelAttribute("maValeur")
	public String getMaValeur() {
		return LocalDateTime.now().toString();
	}
	
	@ModelAttribute("camion")
	public Camion getCamion() {
		Camion camion = new Camion(1,"Volvo");
		return camion;
	}
	
	@ModelAttribute("camions")
	public List<Camion> getCamions() {
		return Arrays.asList(new Camion(1, "Volvo"), new Camion(2, "Renault"));
	}
	
	@RequestMapping(path="/camion",method = RequestMethod.GET )
	public ModelAndView getCamionParIdAvecParametreDeRequete(@RequestParam(name = "camionId") Integer id) {
		return new ModelAndView("vue-salut", "camionDynamique", new Camion(id, "monCamion"));
	}
	
	@RequestMapping(path="/camion/{camionId}",method = RequestMethod.GET )
	public ModelAndView getCamionParIdAvecVariableDansLePath(@PathVariable(name = "camionId") Integer id) {
		return new ModelAndView("vue-salut", "camionDynamique", new Camion(id, "monCamion"));
	}
}
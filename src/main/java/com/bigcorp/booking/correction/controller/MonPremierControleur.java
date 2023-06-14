package com.bigcorp.booking.correction.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MonPremierControleur {
	
	@RequestMapping(path="/salut",method = RequestMethod.GET )
	public String getSalut() {
		return "vue-salut";
	}

}
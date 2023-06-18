package com.bigcorp.booking.correction.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginLogoutController {
	
	@GetMapping(path="/")
	public String planes() {
		return "redirect:/planes";
	}
	
	@GetMapping(path="/login")
	public String login() {
		return "login";
	}
	
	@GetMapping(path="/logout")
	public String logout() {
		return "logout";
	}

}
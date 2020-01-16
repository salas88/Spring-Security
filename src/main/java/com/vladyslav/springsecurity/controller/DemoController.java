package com.vladyslav.springsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {
	
	@GetMapping("/")
	public String showHome() {
		return "home";
	}
	
	@GetMapping("/leaders")
	public String showPageForManager() {
		
		return "leaders-page";
	}
	
	@GetMapping("/admins")
	public String showPageForAdmins() {
		
		return "admins-page";
	}

}

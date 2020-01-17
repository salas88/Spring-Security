package com.vladyslav.springsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	
	@GetMapping("/showPageforLogin")
	public String showLoginPage() {
		
		return "fancy-login";
	}
	
	@GetMapping("/access-denied")
	public String showPageAccessDenied() {
		
		return "access-denied";
	}

}

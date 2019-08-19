package com.customer_tracker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class WelcomeController {
	
	@RequestMapping("/")
	public String welcomePage() {
		return "welcome";
	}
}

package com.dhruba.microservices.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GreetingController {
	
	@GetMapping("greeting")
	public String greet(Map<String, Object> model) {
		model.put("message", "Hello Dhruba"); // put data in model
		return "greeting";//looks for a jsp page called greeting
	}
}

package com.dhruba.microservices.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.dhruba.microservices.model.Registration;

@Controller
public class RegistrationController {
	
	/*@GetMapping("registration")
	public String getRegistration(Map<String, Object> model) {
		return "registration";//looks for a jsp page called greeting
	}*/
	
	
	@GetMapping("registration")
	public String getRegistration(@ModelAttribute("registration") Registration registration) {
		return "registration";//looks for a jsp page called greeting
	}
	
	@PostMapping("registration")
	public String addRegistration(@Valid @ModelAttribute("registration") Registration registration,
			BindingResult result) {
		if(result.hasErrors()) {
			return "registration";
		}
		return "redirect:registration";// looks for a jsp page called greeting
	}
}

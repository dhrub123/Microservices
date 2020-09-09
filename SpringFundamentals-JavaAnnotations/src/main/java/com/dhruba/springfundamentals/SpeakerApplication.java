package com.dhruba.springfundamentals;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.dhruba.springfundamentals.config.AppConfig;
import com.dhruba.springfundamentals.service.SpeakerService;

public class SpeakerApplication {
	
	public static void main(String[] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		SpeakerService service = context.getBean("speakerService",SpeakerService.class);
		SpeakerService service1 = context.getBean("speakerService",SpeakerService.class);
		System.out.println(service + " " + service1);
		
		service.list().stream().forEach(speaker -> System.out.println(speaker));
	}
}

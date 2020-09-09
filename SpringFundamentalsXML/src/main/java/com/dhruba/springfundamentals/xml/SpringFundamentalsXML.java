package com.dhruba.springfundamentals.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dhruba.springfundamentals.xml.service.SpeakerService;

public class SpringFundamentalsXML {
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		SpeakerService service = context.getBean("speakerServiceFromConstructor",SpeakerService.class);
		service.list().stream().forEach(speaker -> System.out.println(speaker));
		
		System.out.println();
		
		SpeakerService service2 = context.getBean("speakerServiceFromSetter",SpeakerService.class);
		service2.list().stream().forEach(speaker -> System.out.println(speaker));
		
		System.out.println();
		
		SpeakerService service3 = context.getBean("speakerServiceFromConstructorAutowire",SpeakerService.class);
		service3.list().stream().forEach(speaker -> System.out.println(speaker));
		
		System.out.println();
		
		SpeakerService service4 = context.getBean("speakerServiceAutowireByName",SpeakerService.class);
		service4.list().stream().forEach(speaker -> System.out.println(speaker));
		
		System.out.println();
		
		SpeakerService service5 = context.getBean("speakerServiceAutowireByType",SpeakerService.class);
		service5.list().stream().forEach(speaker -> System.out.println(speaker));
	}
}

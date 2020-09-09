package com.dhruba.springfundamentals.config;

import java.util.Calendar;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.dhruba.springfundamentals.util.CalendarFactory;

/**
 * This beans are all singletons and will only be called the first time
 */
@Configuration//applicationContext.xml replaced by this annotation
@ComponentScan({"com.dhruba.springfundamentals"})
public class AppConfig {
	/*
	@Bean(name="speakerService")//Spring bean are defined by @Bean
	@Scope(value=BeanDefinition.SCOPE_SINGLETON)
	//@Scope(value=BeanDefinition.SCOPE_PROTOTYPE)
	public SpeakerService getSpeakerService() {
		//setter injection
		//SpeakerServiceImpl service = new SpeakerServiceImpl();
		//service.setSpeakerRepository(getSpeakerRepository());
		//This is setter injection
		
		//constructor injection
		//SpeakerServiceImpl service = new SpeakerServiceImpl(getSpeakerRepository());
		//This is constructor injection
		SpeakerServiceImpl service = new SpeakerServiceImpl();
		return service;
	}*/
	
	/*@Bean(name="speakerRepository")//only 1 will get created, this is a singleton
	public SpeakerRepository getSpeakerRepository() {
		return new SpeakerRepositoryImpl();
	}*/
	
	@Bean(name="cal")
	public CalendarFactory calFactory() {
		CalendarFactory factory = new CalendarFactory();
		factory.addDays(2);
		return factory;
	}
	
	@Bean
	public Calendar cal() throws Exception{
		return calFactory().getObject();
	}
}

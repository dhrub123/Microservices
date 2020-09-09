package com.dhruba.microservices.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

@Configuration
public class TemplateResolver {
	
	@Autowired
	public ApplicationContext applicationContext;
	
	@Bean
	public SpringResourceTemplateResolver springResourceTemplateResolver() {
		SpringResourceTemplateResolver springResourceTemplateResolver = new SpringResourceTemplateResolver();
		springResourceTemplateResolver.setApplicationContext(applicationContext);
		springResourceTemplateResolver.setPrefix("/WEB-INF/views/");
		springResourceTemplateResolver.setSuffix(".html");
		return springResourceTemplateResolver;
	}
	
	@Bean
	public SpringTemplateEngine thymeleafTemplateEngine() {
		SpringTemplateEngine thymeleafTemplateEngine = new SpringTemplateEngine();
		thymeleafTemplateEngine.setTemplateResolver(springResourceTemplateResolver());
		thymeleafTemplateEngine.setEnableSpringELCompiler(true);
		return thymeleafTemplateEngine;
	}
	
	@Bean
	public ViewResolver thymeleafResolver() {
		ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
		viewResolver.setTemplateEngine(thymeleafTemplateEngine());
		viewResolver.setOrder(0);
		return viewResolver;
	}

}

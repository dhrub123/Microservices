package com.dhruba.justgifit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.boot.autoconfigure.jmx.JmxAutoConfiguration;
import org.springframework.boot.autoconfigure.websocket.servlet.WebSocketServletAutoConfiguration;

@SpringBootApplication(exclude = { JacksonAutoConfiguration.class, JmxAutoConfiguration.class,
		WebSocketServletAutoConfiguration.class })
public class JustGifItApplication {

	public static void main(String[] args) {
		SpringApplication.run(JustGifItApplication.class, args);
	}
	
	//The following are examples of tweaking auto configuration
	/*@Bean
	public FilterRegistrationBean deRegisterHiddenHttpMethodFilter(HiddenHttpMethodFilter filter) {
		FilterRegistrationBean bean = new FilterRegistrationBean(filter);
		bean.setEnabled(false);
		return bean;
	}
	
	@Bean
	public FilterRegistrationBean deRegisterHttpPutFormContentFilter(HttpPutFormContentFilter filter) {
		FilterRegistrationBean bean = new FilterRegistrationBean(filter);
		bean.setEnabled(false);
		return bean;
	}
	
	@Bean
	public FilterRegistrationBean deregisterRequestContextFilter(RequestContextFilter filter) {
		FilterRegistrationBean bean = new FilterRegistrationBean(filter);
		bean.setEnabled(false);
		return bean;
	}*/
	
	

}

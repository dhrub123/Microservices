package com.dhruba.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.dhruba.microservices.zuul.filter.ProxyFilter;
import com.dhruba.microservices.zuul.filter.StartPreFilter;
import com.dhruba.microservices.zuul.filter.StopPostFilter;

@EnableZuulProxy
@SpringBootApplication
public class SpringCloudZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudZuulApplication.class, args);
	}
	
	@Bean
	public ProxyFilter proxyFilter() {
		return new ProxyFilter();
	}
	
	/**
	 * If we call this URL now, http://localhost:8086/api/tollproxy/tollrate/2?source=mobile
	 * We will see filter being logged.
	 */
	
	@Bean
	public StartPreFilter startPreFilter() {
		return new StartPreFilter();
	}
	
	@Bean
	public StopPostFilter stopPostFilter() {
		return new StopPostFilter();
	}

}

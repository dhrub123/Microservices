package com.dhruba.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;

@SpringBootApplication
@EnableTask
public class SpringCloudProjectTaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudProjectTaskApplication.class, args);
	}

}

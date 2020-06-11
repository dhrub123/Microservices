package com.dhruba.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class SpringCloudConfigProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudConfigProjectApplication.class, args);
	}

}

package com.dhruba.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.stream.EnableTurbineStream;

@EnableTurbineStream
@SpringBootApplication
public class SpringCloudHystrixTurbineStreamDashBoardApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudHystrixTurbineStreamDashBoardApplication.class, args);
	}

}

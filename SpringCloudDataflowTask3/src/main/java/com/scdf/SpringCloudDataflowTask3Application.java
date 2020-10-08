package com.scdf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.context.annotation.Bean;

@EnableTask
@EnableConfigurationProperties(Task3Properties.class)
@SpringBootApplication
public class SpringCloudDataflowTask3Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudDataflowTask3Application.class, args);
	}
	
	@Bean
	public Task3 task3() {
		return new Task3();
	}
	public class Task3 implements CommandLineRunner{
		
		@Autowired
		private Task3Properties config;
		@Override
		public void run(String... args) throws Exception {
			System.out.println("Source : " + config.getSourceFilepath());
			System.out.println("Destination : " + config.getDestinationFilePath());
			System.out.println("Control Message : " + config.getControlMessage());
			
			if(config.getControlMessage().equals("fail")) {
				System.out.println("Throwing Exception....");
				throw new Exception("I am angry");
			}
			
			System.out.println("Task3 complete");
		}
		
	}

}

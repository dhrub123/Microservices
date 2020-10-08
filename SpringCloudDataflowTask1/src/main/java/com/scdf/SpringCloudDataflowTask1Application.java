package com.scdf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.context.annotation.Bean;

@EnableTask
@EnableConfigurationProperties(Task1Properties.class)
@SpringBootApplication
public class SpringCloudDataflowTask1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudDataflowTask1Application.class, args);
	}
	
	@Bean
	public Task1 task1() {
		return new Task1();
	}
	public class Task1 implements CommandLineRunner{
		
		@Autowired
		private Task1Properties config;
		@Override
		public void run(String... args) throws Exception {
			System.out.println("Source : " + config.getSourceFilepath());
			System.out.println("Destination : " + config.getDestinationFilePath());
			System.out.println("Control Message : " + config.getControlMessage());
			
			if(config.getControlMessage().equals("fail")) {
				System.out.println("Throwing Exception....");
				throw new Exception("I am angry");
			}
			
			System.out.println("Task1 complete");
		}
		
	}

}

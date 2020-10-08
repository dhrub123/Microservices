package com.scdf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.context.annotation.Bean;

@EnableTask
@EnableConfigurationProperties(Task2Properties.class)
@SpringBootApplication
public class SpringCloudDataflowTask2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudDataflowTask2Application.class, args);
	}
	
	@Bean
	public Task2 task2() {
		return new Task2();
	}
	public class Task2 implements CommandLineRunner{
		
		@Autowired
		private Task2Properties config;
		@Override
		public void run(String... args) throws Exception {
			System.out.println("Source : " + config.getSourceFilepath());
			System.out.println("Destination : " + config.getDestinationFilePath());
			System.out.println("Control Message : " + config.getControlMessage());
			
			if(config.getControlMessage().equals("fail")) {
				System.out.println("Throwing Exception....");
				throw new Exception("I am angry");
			}
			
			System.out.println("Task2 complete");
		}
		
	}

}

package com.dhruba.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.handler.annotation.SendTo;

@EnableBinding(Sink.class)
//@EnableBinding(Processor.class)
@SpringBootApplication
public class SpringCloudStreamIntakeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudStreamIntakeApplication.class, args);
	}
	
	/*@StreamListener(Sink.INPUT)
	public void log(String msg) {
		System.out.println(msg);
	}*/
	
	/*
	@ServiceActivator(inputChannel=Sink.INPUT)
	public void log(String msg) {
		System.out.println(msg);
	}*/
	
	/*@StreamListener(Processor.INPUT)
	@SendTo(Processor.OUTPUT)
	public String log(String msg) {
		System.out.println(msg);
		return msg;
	}*/
	
	@StreamListener(target=Sink.INPUT , condition="headers['speed']>40")
	public void logFast(String msg) {
		System.out.println("fast - " + msg);
	}
	
	@StreamListener(target=Sink.INPUT , condition="headers['speed']<=40")
	public void logSlow(String msg) {
		System.out.println("slow - " + msg);
	}

}

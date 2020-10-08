package com.scdfdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.handler.annotation.SendTo;

@EnableConfigurationProperties(TollreadingProperties.class)
@EnableBinding(Processor.class)
@SpringBootApplication
public class SpringCloudDataflowScoringStreamAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudDataflowScoringStreamAppApplication.class, args);
	}

	@Autowired
	private TollreadingProperties properties;
	
	@StreamListener(Processor.INPUT)
	@SendTo(Processor.OUTPUT)
	public TollReading assignScore(TollReading r) {
		System.out.println("station is " + r.getStationid());
		int fraudThreshold = properties.getFraudThreshold();
		int fraudProbabilityScore = 0;
		if (r.getStationid() == 110) {
			fraudProbabilityScore = 30;
		}
		if (fraudProbabilityScore > fraudThreshold) {
			r.setIsFraud(true);
		}
		return r;
	}

}

package com.dhruba.microservices;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TollProcessingTasks implements CommandLineRunner {
	@Override
	public void run(String... strings) throws Exception {
		// StationId,LicensePlate,TimeStamp
		if (null != strings) {
			System.out.println("parameter length is " + strings.length);
			String stationId = strings[1];
			String licensePlate = strings[2];
			String timestamp = strings[3];
			System.out.println("stationId = " + stationId + " licensePlate = " + licensePlate + " timestamp = " + timestamp);
		}
	}
}

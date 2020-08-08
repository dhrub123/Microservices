package com.dhruba.microservices;

import java.util.Hashtable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import brave.Span;
import brave.Tracer;

@SpringBootApplication
@RestController
public class SpringCloudVehicleDetailsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudVehicleDetailsServiceApplication.class, args);
	}

	@Autowired
	private Tracer tracer;

	@RequestMapping(value = "/customer/{cid}/vehicledetails", method = RequestMethod.GET)
	public @ResponseBody String getCustomerVehicleDetails(@PathVariable Integer cid) {

		Span s = this.tracer.newTrace().name("lookupVehicle").start();
		String result;
		try {
			s.tag("customerId", cid.toString());
			s.annotate("Start database lookup");

			Hashtable<Integer, String> vehicles = new Hashtable<Integer, String>();
			vehicles.put(100, "Lincoln Continental; Plate SNUG30");
			vehicles.put(101, "Chevrolet Camaro; Plate R7TYR43");
			vehicles.put(102, "Volkswagen Beetle; Plate 6CVI3E2");

			result = vehicles.get(cid);
			s.annotate("Finish database lookup");
		} finally {
			s.finish();
		}

		return result;
	}
}

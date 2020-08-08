package com.dhruba.microservices;

import org.springframework.context.annotation.Bean;
import brave.sampler.Sampler;

public class CustomSampler {
	
	@Bean
	public Sampler smartSampler() {
		
		return new Sampler() {
			
			@Override
			public boolean isSampled(long traceId) {
				return true;
			}
		};
	}
}

package com.scdfdemo;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("fraud")
public class TollreadingProperties {

	private Integer fraudThreshold = 10;

	public Integer getFraudThreshold() {
		return fraudThreshold;
	}

	public void setFraudThreshold(Integer fraudThreshold) {
		this.fraudThreshold = fraudThreshold;
	}

}

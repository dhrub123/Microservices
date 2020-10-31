package com.justgifit.autoconfigure;

import java.io.File;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "com.justgifit")
public class JustGifItProperties {

	private File gifLocation;
	private boolean optimize;

	public boolean isOptimize() {
		return optimize;
	}

	public void setOptimize(boolean optimize) {
		this.optimize = optimize;
	}

	public File getGifLocation() {
		return gifLocation;
	}

	public void setGifLocation(File gifLocation) {
		this.gifLocation = gifLocation;
	}

}

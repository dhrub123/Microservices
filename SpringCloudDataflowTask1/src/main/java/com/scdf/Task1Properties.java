package com.scdf;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("task1")
public class Task1Properties {

	private String sourceFilepath;
	private String destinationFilePath;
	private String controlMessage;

	public String getSourceFilepath() {
		return sourceFilepath;
	}

	public void setSourceFilepath(String sourceFilepath) {
		this.sourceFilepath = sourceFilepath;
	}

	public String getDestinationFilePath() {
		return destinationFilePath;
	}

	public void setDestinationFilePath(String destinationFilePath) {
		this.destinationFilePath = destinationFilePath;
	}

	public String getControlMessage() {
		return controlMessage;
	}

	public void setControlMessage(String controlMessage) {
		this.controlMessage = controlMessage;
	}

}

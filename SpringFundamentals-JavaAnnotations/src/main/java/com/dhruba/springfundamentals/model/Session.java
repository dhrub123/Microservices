package com.dhruba.springfundamentals.model;

import java.util.List;

public class Session {

	private Long sessionId;

	private String sessionName;

	private String sessionDescription;

	private Integer sessionLength;

	private List<Speaker> speakers;

	// This helps in serialization and deserialization
	public Session() {
	}

	public String getSessionName() {
		return sessionName;
	}

	public Long getSessionId() {
		return sessionId;
	}

	public void setSessionId(Long sessionId) {
		this.sessionId = sessionId;
	}

	public void setSessionName(String sessionName) {
		this.sessionName = sessionName;
	}

	public String getSessionDescription() {
		return sessionDescription;
	}

	public void setSessionDescription(String sessionDescription) {
		this.sessionDescription = sessionDescription;
	}

	public Integer getSessionLength() {
		return sessionLength;
	}

	public void setSessionLength(Integer sessionLength) {
		this.sessionLength = sessionLength;
	}

	public List<Speaker> getSpeakers() {
		return speakers;
	}

	public void setSpeakers(List<Speaker> speakers) {
		this.speakers = speakers;
	}

	@Override
	public String toString() {
		return "Session [sessionId=" + sessionId + ", sessionName=" + sessionName + ", sessionDescription="
				+ sessionDescription + ", sessionLength=" + sessionLength + ", speakers=" + speakers + "]";
	}
		
}

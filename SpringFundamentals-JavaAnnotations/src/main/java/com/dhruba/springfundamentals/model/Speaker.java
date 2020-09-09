package com.dhruba.springfundamentals.model;

import java.util.Arrays;
import java.util.List;

public class Speaker {

	private Long speakerId;

	private String firstName;

	private String lastName;

	private String title;

	private String company;

	private String speakerBio;

	private byte[] speakerPhoto;

	private List<Session> sessions;
	
	private double seedNum;

	public Speaker() {
	}

	public Speaker(Long speakerId, String firstName, String lastName, String title, String company, String speakerBio,
			byte[] speakerPhoto, List<Session> sessions, double seedNum) {
		this.speakerId = speakerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.title = title;
		this.company = company;
		this.speakerBio = speakerBio;
		this.speakerPhoto = speakerPhoto;
		this.sessions = sessions;
		this.seedNum = seedNum;
	}

	public byte[] getSpeakerPhoto() {
		return speakerPhoto;
	}

	public void setSpeakerPhoto(byte[] speakerPhoto) {
		this.speakerPhoto = speakerPhoto;
	}

	public String getFirstName() {
		return firstName;
	}

	public Long getSpeakerId() {
		return speakerId;
	}

	public void setSpeakerId(Long speakerId) {
		this.speakerId = speakerId;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getSpeakerBio() {
		return speakerBio;
	}

	public void setSpeakerBio(String speakerBio) {
		this.speakerBio = speakerBio;
	}

	public List<Session> getSessions() {
		return sessions;
	}

	public void setSessions(List<Session> sessions) {
		this.sessions = sessions;
	}
	
	public double getSeedNum() {
		return seedNum;
	}

	public void setSeedNum(double seedNum) {
		this.seedNum = seedNum;
	}

	@Override
	public String toString() {
		return "Speaker [speakerId=" + speakerId + ", firstName=" + firstName + ", lastName=" + lastName + ", title="
				+ title + ", company=" + company + ", speakerBio=" + speakerBio + ", speakerPhoto="
				+ Arrays.toString(speakerPhoto) + ", sessions=" + sessions + ", seedNum=" + seedNum + "]";
	}

}

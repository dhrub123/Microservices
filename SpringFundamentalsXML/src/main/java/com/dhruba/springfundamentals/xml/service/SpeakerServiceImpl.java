package com.dhruba.springfundamentals.xml.service;

import java.util.List;

import org.springframework.beans.BeanUtils;

import com.dhruba.springfundamentals.xml.model.Speaker;
import com.dhruba.springfundamentals.xml.repository.SpeakerRepository;

public class SpeakerServiceImpl implements SpeakerService{
	
	private SpeakerRepository speakerRepository ;
	
	public SpeakerServiceImpl(SpeakerRepository speakerRepository) {
		this.speakerRepository = speakerRepository;
	}
	
	public SpeakerServiceImpl() {
	}

	@Override
	public List<Speaker> list() {
		return speakerRepository.findAll();
	}
	
	@Override
	public Speaker get(Long id) {
		return speakerRepository.getOne(id);
	}
	
	@Override
	public Speaker create(final Speaker speaker) {
		return speakerRepository.saveAndFlush(speaker);
	}
	
	@Override
	public void delete(Long id) {
		speakerRepository.deleteById(id);
	}
	
	@Override
	public Speaker update(Long id, Speaker speaker) {
		Speaker exisitingSpeaker = speakerRepository.getOne(id);
		BeanUtils.copyProperties(speaker, exisitingSpeaker, "session_id");
		return speakerRepository.saveAndFlush(exisitingSpeaker);
	}
	
	public void setSpeakerRepository(SpeakerRepository speakerRepository) {
		this.speakerRepository = speakerRepository;
	}
		
}

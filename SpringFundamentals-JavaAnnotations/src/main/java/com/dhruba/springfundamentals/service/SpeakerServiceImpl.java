package com.dhruba.springfundamentals.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.dhruba.springfundamentals.model.Speaker;
import com.dhruba.springfundamentals.repository.SpeakerRepository;

@Service("speakerService")
@Scope(value=BeanDefinition.SCOPE_SINGLETON)//optional
public class SpeakerServiceImpl implements SpeakerService{
	
	private SpeakerRepository speakerRepository;
	
	//This is for constructor injection
	@Autowired
	public SpeakerServiceImpl(SpeakerRepository speakerRepository) {
		this.speakerRepository = speakerRepository;
	}
	
	public SpeakerServiceImpl() {
	}
	
	@PostConstruct
	private void initialize() {
		//Please do not add config things like opening db connections here
		System.out.println("Initializing now");
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
	
	//@Autowired
	public void setSpeakerRepository(SpeakerRepository speakerRepository) {
		this.speakerRepository = speakerRepository;
	}
		
}

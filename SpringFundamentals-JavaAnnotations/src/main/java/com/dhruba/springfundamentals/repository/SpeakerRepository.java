package com.dhruba.springfundamentals.repository;

import java.util.List;

import com.dhruba.springfundamentals.model.Speaker;

public interface SpeakerRepository{
	
	public List<Speaker> findAll();

	public Speaker getOne(Long id);

	public Speaker saveAndFlush(Speaker speaker);

	public void deleteById(Long id);

	public Speaker update(Long id, Speaker speaker);
}

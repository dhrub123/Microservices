package com.dhruba.springfundamentals.service;

import java.util.List;

import com.dhruba.springfundamentals.model.Speaker;

public interface SpeakerService {

	public List<Speaker> list();

	public Speaker get(Long id);

	public Speaker create(Speaker speaker);

	public void delete(Long id);

	public Speaker update(Long id, Speaker speaker);

}
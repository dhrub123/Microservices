package com.dhruba.springfundamentals.xml.repository;

import java.util.ArrayList;
import java.util.List;

import com.dhruba.springfundamentals.xml.model.Speaker;

public class SpeakerRepositoryImpl implements SpeakerRepository {

	@Override
	public List<Speaker> findAll() {
		List<Speaker> speakers = new ArrayList<Speaker>();
		speakers.add(new Speaker((long) 102, "Dhruba", "Nag", "Director", "NCorp", "Warfare spec", null, null));
		speakers.add(new Speaker((long) 103, "Dayita", "Das", "Director", "NCorp", "Greedy Eater spec", null, null));
		speakers.add(new Speaker((long) 104, "Mita", "Nag", "Director", "NCorp", "Chef spec", null, null));
		speakers.add(new Speaker((long) 105, "Paresh", "Nag", "Director", "NCorp", "Yoga spec", null, null));
		return speakers;
	}

	@Override
	public Speaker getOne(Long id) {
		return new Speaker((long) 104, "Mita", "Nag", "Director", "NCorp", "Chef spec", null, null);
	}

	@Override
	public Speaker saveAndFlush(Speaker speaker) {
		return null;
	}

	@Override
	public void deleteById(Long id) {

	}

	@Override
	public Speaker update(Long id, Speaker speaker) {
		return null;
	}

}

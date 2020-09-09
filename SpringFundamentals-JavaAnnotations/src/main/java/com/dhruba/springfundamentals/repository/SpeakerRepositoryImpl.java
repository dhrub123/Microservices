package com.dhruba.springfundamentals.repository;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.dhruba.springfundamentals.model.Speaker;

@Repository("speakerRepository")
public class SpeakerRepositoryImpl implements SpeakerRepository {
	
	@Autowired
	private Calendar cal;
	
	//SPEL
	@Value("#{ T(java.lang.Math).random() * 100}")
	private double seedNum;
	
	@Override
	public List<Speaker> findAll() {
		List<Speaker> speakers = new ArrayList<Speaker>();
		speakers.add(new Speaker((long) 102, "Dhruba", "Nag", "Director", "NCorp", "Warfare spec", null, null, seedNum));
		speakers.add(new Speaker((long) 103, "Dayita", "Das", "Director", "NCorp", "Greedy Eater spec", null, null, seedNum));
		speakers.add(new Speaker((long) 104, "Mita", "Nag", "Director", "NCorp", "Chef spec", null, null, seedNum));
		speakers.add(new Speaker((long) 105, "Paresh", "Nag", "Director", "NCorp", "Yoga spec", null, null, seedNum));
		System.out.println("cal = " + cal.getTime());
		return speakers;
	}

	@Override
	public Speaker getOne(Long id) {
		return new Speaker((long) 104, "Mita", "Nag", "Director", "NCorp", "Chef spec", null, null, seedNum);
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

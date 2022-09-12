package com.sj.dojosandninjas.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.sj.dojosandninjas.models.Dojo;
import com.sj.dojosandninjas.models.Ninja;
import com.sj.dojosandninjas.repositories.NinjaRepo;

@Service
public class NinjaService {
	private final NinjaRepo ninjaRepo;

	public NinjaService(NinjaRepo ninjaRepo) {
		this.ninjaRepo = ninjaRepo;
	}

	public Ninja createNinja(@Valid Ninja ninja) {
		return ninjaRepo.save(ninja);
	}

	
	
}

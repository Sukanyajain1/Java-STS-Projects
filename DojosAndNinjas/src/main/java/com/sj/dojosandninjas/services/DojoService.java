package com.sj.dojosandninjas.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.sj.dojosandninjas.models.Dojo;
import com.sj.dojosandninjas.repositories.DojoRepo;

@Service
public class DojoService {
	private final DojoRepo dojoRepo;

	public DojoService(DojoRepo dojoRepo) {
		this.dojoRepo = dojoRepo;
	}

	public Dojo findDojo(Long id) {
		Optional<Dojo> optionalDojo = dojoRepo.findById(id);
        if(optionalDojo.isPresent()) {
            return optionalDojo.get();
        } else {
            return null;
        }
	}

	public Dojo createDojo(@Valid Dojo dojo) {
		return dojoRepo.save(dojo);
	}

	public List<Dojo> allDojos() {
		return dojoRepo.findAll();
	}
	
	
}

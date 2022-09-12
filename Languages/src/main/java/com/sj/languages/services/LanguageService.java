package com.sj.languages.services;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sj.languages.models.Language;
import com.sj.languages.repositories.LanguageRepo;

@Service

public class LanguageService {
	private final LanguageRepo languageRepo;
	
//	SERVICE CONSTRUCTOR
	public LanguageService(LanguageRepo languageRepo) {
		this.languageRepo = languageRepo;
	}
	
//	ALL THE METHODS/LOGIC THAT WILL BE CALLED BY THE CONTROLLER

	
//	--------------------------------------------------------------------
//	RETURNS ALL THE LANGUAGES
//	--------------------------------------------------------------------
	public List<Language> allLanguages() {
		return languageRepo.findAll();
	}

	public Language createLanguage(Language language) {
		return languageRepo.save(language);
	}

	public Language showOneLanguage(Long id) {
		Optional<Language> optionalLanguage = languageRepo.findById(id);
        if(optionalLanguage.isPresent()) {
            return optionalLanguage.get();
        } else {
            return null;
        }
	}


	
//	--------------------------------------------------------------------
//	RETURNS ONE LANGUAGE BY ID
//	--------------------------------------------------------------------
	
	
	
	
	
//	--------------------------------------------------------------------
//	CREATES A NEW LANGUAGES
//	--------------------------------------------------------------------
	
	
	
	
	
//	--------------------------------------------------------------------
//	DELETES A LANGUAGES
//	--------------------------------------------------------------------
	public void deleteLanguage(Long id) {
		languageRepo.deleteById(id);		
	}
}

package com.sj.languages.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sj.languages.models.Language;
import com.sj.languages.services.LanguageService;

@Controller
@RequestMapping("/languages")
public class MainController {
	
//	INJECT THE SERVICE INTO THE CONTROLLER
	private final LanguageService languageServ;

	
//	CONSTRUCTOR
	public MainController(LanguageService languageServ) {
		this.languageServ = languageServ;
	}
	
	
//	MAP ROUTES AND METHOD CALLS
	
	
//	--------------------------------------------------------------------
//	SHOWS ALL THE LANGUAGES --- DASHBOARD
//	--------------------------------------------------------------------
	@GetMapping("")
	public String dashboard (@ModelAttribute("newLanguage") Language language, Model model) {
		List<Language> languages = languageServ.allLanguages();
		model.addAttribute("languages", languages);
		return "dashboard.jsp";
	}
	
	
	
	
//	--------------------------------------------------------------------
//	SHOWS ONE LANGUAGE BY ID --- SHOW PAGE
//	--------------------------------------------------------------------
	@GetMapping("show/{id}")
	public String dashboard (@PathVariable(value = "id") Long id, Model model) {
		Language oneLanguage = languageServ.showOneLanguage(id);
		model.addAttribute("oneLanguage", oneLanguage);
		return "showLanguage.jsp";
	}
	
	
	
//	--------------------------------------------------------------------
//	CREATES A NEW LANGUAGES  --- CREATE NEW
//	--------------------------------------------------------------------	
	@PostMapping("/create")
	public String createLanguage(@Valid @ModelAttribute("newLanguage") Language language, BindingResult result, Model model) {
		if (result.hasErrors()) {
			List<Language> languages = languageServ.allLanguages();
			model.addAttribute("languages", languages);
            return "dashboard.jsp";
        } else {
        	languageServ.createLanguage(language);
            return "redirect:/languages";
        }
	}
	
	
	
	
//	--------------------------------------------------------------------
//	DELETES A LANGUAGES  --- REDIRECTS TO DASHBOARD
//	--------------------------------------------------------------------
	@GetMapping("delete/{id}")
	public String deleteLanguage(@PathVariable(value = "id") Long id) {
		languageServ.deleteLanguage(id);
		return "redirect:/languages";
	}
}

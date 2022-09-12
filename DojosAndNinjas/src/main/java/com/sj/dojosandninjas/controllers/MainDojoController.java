package com.sj.dojosandninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sj.dojosandninjas.models.Dojo;
import com.sj.dojosandninjas.models.Ninja;
import com.sj.dojosandninjas.services.DojoService;
import com.sj.dojosandninjas.services.NinjaService;

@Controller
public class MainDojoController {

	
	public MainDojoController(NinjaService ninjaService, DojoService dojoService) {
		this.ninjaService = ninjaService;
		this.dojoService = dojoService;
	}


	private final NinjaService ninjaService;
	private final DojoService dojoService;
	
	
//	----------------------------------------------------------------------
//	SHOW ALL THE NINJAS OF ONE DOJO
//	----------------------------------------------------------------------

	@GetMapping("/dojos/{id}")
	public String ninjasOfDojo (@PathVariable(value = "id") Long id, Model model) {
		Dojo oneDojo = dojoService.findDojo(id);
		model.addAttribute("oneDojo", oneDojo);
		return "showNinjasOfDojo.jsp";
	}
	
//	----------------------------------------------------------------------
//	CREATE ONE DOJO
//	----------------------------------------------------------------------
	@GetMapping("/dojos/new")
	public String newDojo (@ModelAttribute("dojo") Dojo dojo) {
		return "newDojo.jsp";
	}
	
	@PostMapping("/dojos/processing")
    public String create(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
        if (result.hasErrors()) {
            return "newDojo.jsp";
        } else {
        	dojoService.createDojo(dojo);
        	Long id = dojo.getId();
            return "redirect:/dojos/"+id;
        }
    }
//	----------------------------------------------------------------------
//	CREATE ONE NINJA
//	----------------------------------------------------------------------
	@GetMapping("/ninjas/new")
	public String newNinja (@ModelAttribute("ninja") Ninja ninja, Model model) {
		List<Dojo> dojos = dojoService.allDojos();
		model.addAttribute("dojos", dojos);
		return "newNinja.jsp";
	}
	
	@PostMapping("/ninjas/processing")
    public String create(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
        if (result.hasErrors()) {
            return "newNinja.jsp";
        } else {
        	ninjaService.createNinja(ninja);
        	Dojo dojo = ninja.getDojo();
            return "redirect:/dojos/"+dojo.getId();
        }
    }
	
}

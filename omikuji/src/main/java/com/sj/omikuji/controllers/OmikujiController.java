package com.sj.omikuji.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sj.omikuji.models.Omikuji;

@Controller
@RequestMapping("/omikuji")
public class OmikujiController {
	@RequestMapping("")
	public String index(HttpSession session) {
		session.invalidate();
		return "index.jsp";
	}
	
	@RequestMapping(value="/processing", method=RequestMethod.POST)
	public String processOmikuji (HttpSession session, 
			@RequestParam(value = "random_number") Integer randomNumber,
			@RequestParam(value = "city") String city,
			@RequestParam(value = "person") String person,
			@RequestParam(value = "hobby") String hobby,
			@RequestParam(value = "living_thing") String livingThing,
			@RequestParam(value = "personal_message") String personalMessage) {
		Omikuji userFortune = new Omikuji( randomNumber, city,  person, hobby, livingThing, personalMessage);
		session.setAttribute("userFortune", userFortune);
		System.out.println("This is working!!!!!!!!!!!");
		return "redirect:/omikuji/show";
	}
	
	@RequestMapping("/show")
	public String omikujiResult (HttpSession session, Model model) {
		System.out.println("This is ALSO working!!!!!!!!!!!");
		Omikuji userFortune = (Omikuji) session.getAttribute("userFortune");
		model.addAttribute("userFortune", userFortune);
		return "result.jsp";
	}
}

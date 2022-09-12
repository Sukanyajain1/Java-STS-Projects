package com.sj.ninjagoldgame.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class GameController {
	@SuppressWarnings("unchecked")
	@RequestMapping("/gold")
	public String index(HttpSession session, Model model) {
		System.out.println("This is the beginning!!!!!!!!");
//		this is the render page for gold form
//		display the number of coins a person has
		Integer coins = (Integer) session.getAttribute("coins");
		ArrayList<String> action = (ArrayList<String>) session.getAttribute("action");
		session.setAttribute("action", action);
		if(coins == null) {
			session.setAttribute("coins", 0);			
			model.addAttribute("coins", 0);
		}
		else {
			model.addAttribute("coins", coins);
		}
		if(action == null) {
			ArrayList<String> newArrayList = new ArrayList<String>();
			session.setAttribute("action", newArrayList);			
			model.addAttribute("action", newArrayList);
		}
		else {
			model.addAttribute("action", action);
		}
		return "index.jsp";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/points", method = RequestMethod.POST)
	public String processCoins(
			HttpSession session, 
			Model model, 
			@RequestParam(value = "farm", required = false) String farm,
			@RequestParam(value = "cave", required = false) String cave,
			@RequestParam(value = "house", required = false) String house,
			@RequestParam(value = "quest", required = false) String quest) {
		
		System.out.println("This is working!!!!!!!!");

		Date date = new Date();
		String newAction = new String();
		Integer coins = (Integer) session.getAttribute("coins");
		ArrayList<String> action = (ArrayList<String>) session.getAttribute("action");

//		if the value is farm: pick an integer between 10 and 20 and add it to the counter in session
		if (farm != null) {
			System.out.println("Passed the if statement!!!!!!!!");
			Integer random = new Random().nextInt(11) + 10;
			System.out.println("Got the random integer!!!!!!!!" + random);
			coins += random;
			System.out.println("Added the random integer!!!!!!!!" + coins);
			newAction = "You entered a farm and earned " + random + " gold. (" + date + ")";
			System.out.println("Made the newAction variable!!!!!!!!");
			System.out.println(newAction);
			action.add(newAction);
			System.out.println(action);
			System.out.println("Added the newAction variable!!!!!!!!");
		}
//		if the value is cave: pick an integer between 10 and 20 and add it to the counter in session
		if (cave != null) {
			Integer random = new Random().nextInt(11) + 5;
			coins += random;
			action.add(new String("You entered a cave and earned " + random + " gold. (" + date + ")"));
		}
//		if the value is house: pick an integer between 10 and 20 and add it to the counter in session
		if (house != null) {
			Integer random = new Random().nextInt(4) + 2;
			coins += random;
			action.add("You entered a house and earned " + random + " gold. (" + date + ")");
		}
//		if the value is quest: pick an integer between -50 and 50 and add it to the counter in session
		if (quest != null) {
			Integer random = new Random().nextInt(51);
			Integer roulette = new Random().nextInt(2);
			if (roulette == 0) {
				random *= -1;
			}
			coins += random;
			if (random < 0) {
				random *= -1;
				action.add("You failed a quest and lost " + random + " gold. (" + date + ")");
			}
			else{
				action.add("You completed a quest and earned " + random + " gold. (" + date + ")");
			}
		}
		
		session.setAttribute("coins", coins);
		session.setAttribute("action", action);	
		
		return "redirect:/gold";
	}
	
	@PostMapping("/reset")
	public String reset(HttpSession session, @RequestParam(value = "reset", required = false) String reset) {
		session.invalidate();
		return "redirect:/gold";
	}
	
	
}

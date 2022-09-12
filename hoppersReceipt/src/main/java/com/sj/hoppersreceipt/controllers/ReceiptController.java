package com.sj.hoppersreceipt.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ReceiptController {
// injection model model
// make the espresso
// fill the cup
// pour it into the drink with all other ingredients
	@RequestMapping("/")
	public String index (Model model) {
		String custName = "Sukanya Jain";
		String itemName = "Water bottles";
		double price = 10000.78 ;
		String description = "A lot of water in very tiny biodegradable droplet shells.";
		String vendor = "Not clouds";
		
		model.addAttribute("cust_name", custName);
		model.addAttribute("item_name", itemName);
		model.addAttribute("price", price);
		model.addAttribute("description", description);
		model.addAttribute("vendor", vendor);
		
		return "index.jsp";
	}
}


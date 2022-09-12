package com.sj.displaydate.controllers;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//THINGS THAT NEED TO BE DONE:
//controller annotation
//request mapping
//member variables?
//public string method with parameters as model model
//make the member variables (they are actually the values that will be assigned to keys in the model instance)
//do the model.addAttribute for the key value pairs
//return the template

@Controller

public class DateTimeController {
	Date date = new Date ();
	@RequestMapping("/")
	public String index(Model model) {
		return "index.jsp";
	}

	@RequestMapping("/date")
	public String date(Model model) {
//		Date currentDate = date.getDate();
		
//		model.addAttribute("date", );
//		date.
		return "date.jsp";
	}
	
	@RequestMapping("/time")
	public String time(Model model) {
//		Date time = date.
		return "time.jsp";
	}
}

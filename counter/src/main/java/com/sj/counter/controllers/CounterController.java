package com.sj.counter.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/your_server")
public class CounterController {
	@RequestMapping("")
	public String index(HttpSession session, Model model) {
		
		Integer counter = (Integer) session.getAttribute("counter");
		if(counter == null) {
			session.setAttribute("counter", 0);
		}
		else {
			counter += 1;
			session.setAttribute("counter", counter);
		}
		return "index.jsp";
	}
	
	@RequestMapping("/counter")
	public String counter(HttpSession session, Model model) {
		Integer result = (Integer) session.getAttribute("counter");
		model.addAttribute("counter", result);
		return "counter.jsp";
	}
}

package com.sj.mvc.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sj.mvc.models.Book;
import com.sj.mvc.services.BookService;

@Controller
public class MainController {

//	inject the BookService into your main controller (you can give it a different variable name in the scope of the controller to catch any errors)
	private final BookService bookServ;
	
	
//	CONSTRUCTOR FOR THE MAIN CONTROLLER
	public MainController (BookService bookServ) {
		this.bookServ = bookServ;
	}
	
//	THE FIRST REQUEST MAPPING-- MAPPING TO THE BASE ROUTE
	
//	1. first you instantiate a list or the domain model itself (or an optional?) AND call a method from the repository
//	2. then you store it in the model function to send it to the jsp page
//	3. you can also store this information in session if you need to, for whichever model you are working with 
	@RequestMapping("/")
	public String index(Model model) {
		List<Book> books = bookServ.allBooks();
		model.addAttribute("books", books);
		return "index.jsp";
	}
}
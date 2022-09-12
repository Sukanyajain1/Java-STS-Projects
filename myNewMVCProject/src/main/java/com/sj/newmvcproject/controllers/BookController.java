package com.sj.newmvcproject.controllers;


import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sj.newmvcproject.models.Book;
import com.sj.newmvcproject.services.BookService;

@Controller
public class BookController {
	
	private final BookService bookServ;
	public BookController(BookService bookServ) {
		this.bookServ = bookServ;
	}
//------------------------------------------------------------------------------
//	DISPLAY ALL THE BOOKS
//------------------------------------------------------------------------------

	@RequestMapping("/")
	public String index(Model model) {
		System.out.println("THIS IS THE HOME PAGE!!!!!!!!!!!!!!!!!!");
		List<Book> books = bookServ.allBooks();
		model.addAttribute ("books", books);
		return "index.jsp";
	}
	
	
//------------------------------------------------------------------------------
//	DISPLAY ONLY ONE OF THE BOOKS
//------------------------------------------------------------------------------

	@RequestMapping("/books/{id}")
	public String showBook(Model model, @PathVariable("id") Long id) {
		System.out.println("THIS IS THE DISPLAY ONE BOOK PAGE!!!!!!!!!!!!!!!!!!");
		Book oneBook = bookServ.findBook(id);
		model.addAttribute ("oneBook", oneBook);
		return "show.jsp";
	}
	
//------------------------------------------------------------------------------
//	CREATE A NEW BOOK
//------------------------------------------------------------------------------
	@GetMapping("/books/new")
	public String newBook(@ModelAttribute("book") Book book) {
		return "newBook.jsp";
	}
	
	@PostMapping("/books")
	public String create(@Valid @ModelAttribute("book") Book book, BindingResult result) {
		if (result.hasErrors()) {
			System.out.println(result);
			return "newBook.jsp";
		}
		else {
			bookServ.createBook(book);
			return "redirect:/";
		}
	}
	
//------------------------------------------------------------------------------
//	UPDATE A BOOK
//------------------------------------------------------------------------------
	@RequestMapping("/update/{id}")
	public String updatePage(
			@PathVariable("id") Long id,
			Model model) {
		System.out.println("THIS IS THE UPDATE PAGE!!!!!!!!!!!!!!!!!!");
		Book oneBook = bookServ.findBook(id);
		System.out.println("THIS IS THE ONE BOOK ID!!!!!!!!!!!!!!!!!!");
		System.out.println(oneBook.getId());
		model.addAttribute ("oneBook", oneBook);
		return "update.jsp";
	}
	
	@PutMapping("/edit/{id}")
	public String updateProcessing(@Valid @ModelAttribute("oneBook") Book book, BindingResult result) {
		System.out.println("WE ARE PROCESSING THE BOOK UPDATE!!!!!!!!!!!!!!!!!!");
		if (result.hasErrors()) {
			System.out.println(result);
			return "update.jsp";
		} else {
			bookServ.updateBook(book);
			return "redirect:/";			
		}
	}
	
	
//------------------------------------------------------------------------------
//	DELETE A BOOK
//------------------------------------------------------------------------------
	@GetMapping("/delete/{id}")	
	public String deleteBook(@PathVariable("id") Long id) {
			bookServ.deleteBookById(id);
			return "redirect:/";
		}
	
//------------------------------------------------------------------------------
//------------------------------------------------------------------------------
	
//------------------------------------------------------------------------------
//------------------------------------------------------------------------------
	
//------------------------------------------------------------------------------
//------------------------------------------------------------------------------
	
//------------------------------------------------------------------------------
//------------------------------------------------------------------------------
	
//------------------------------------------------------------------------------
//------------------------------------------------------------------------------
	
	
	

	

}

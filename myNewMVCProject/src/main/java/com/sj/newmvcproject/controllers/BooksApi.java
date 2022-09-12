//package com.sj.newmvcproject.controllers;
//
//import java.util.List;
//
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.sj.newmvcproject.models.Book;
//import com.sj.newmvcproject.services.BookService;
//
//@RestController
//public class BooksApi {
//	private final BookService bookServ;
//	public BooksApi(BookService bookServ) {
//		this.bookServ = bookServ;
//	}
//	
//	@RequestMapping("/")
//	public String index(Model model) {
//		List<Book> books = bookServ.allBooks();
//		model.addAttribute ("books", books);
//		return "index.jsp";
//	}
//	
//	@RequestMapping("/update_book")
//	public String updateForm () {
//		return "update.jsp";
//	}
//	
//	
//	
//	@RequestMapping(value = "/api/books/{id}", method = RequestMethod.PUT)
//	public Book update(
//			@PathVariable("id") Long id,
//			@RequestParam(value = "title") String title,
//			@RequestParam(value = "description") String desc,
//			@RequestParam(value = "language") String lang,
//			@RequestParam(value = "pages") Integer pages) {
//		
////		YOU HAVE TO INSTANTIATE A BOOK BY USING THE DOMAIN MODEL CONSTRUCTOR
//		Book book = new Book(title, desc, lang, pages);
//		book.setId(id);
////		THEN YOU CALL THE SERVICE METHOD AND SAVE THE BOOK INSTANCE INTO THE DATABASE WITH AN ID
//		book = bookServ.updateBook(book);
//		return book;
//	}
//	
//	@RequestMapping (value = "/api/books/{id}", method = RequestMethod.DELETE)
//	public void destroy(@PathVariable ("id") Long id) {
//		bookServ.deleteBookById(id);
//	}
//}

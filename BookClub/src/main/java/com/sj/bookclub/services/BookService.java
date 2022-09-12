package com.sj.bookclub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sj.bookclub.models.Book;
import com.sj.bookclub.repositories.BookRepo;

@Service
public class BookService {
//	ADDING IN THE REPOSITORY AS A DEPENDENCY
	private final BookRepo bookRepo;
	
//	CONSTRUCTOR
	public BookService(BookRepo bookRepo) {
		this.bookRepo = bookRepo;
	}
	
	
	
	
//	============================================================
//	returns all the books
	public List<Book> allBooks(){
		return bookRepo.findAll();
		bookRepo.
	}
//	============================================================
	public List<Book> allBooks() {
		return null;
	}
//	============================================================
	
//	creates a book
	public Book createBook(Book b) {
		return bookRepo.save(b);
	}
	
//	retrieves a book
	public Book findBook(Long id) {
//		Optional returns an object that may or may not contain your search result- if it contains null, you are preparing the method to handle that result and return null further into the chain.
		Optional<Book> optionalBook = bookRepo.findById(id);
		if (optionalBook.isPresent()) {
			return optionalBook.get();
		}else {			
			return null;
		}
	}
	
//	updates a book
	public Book updateBook(Book b) {
		return bookRepo.save(b);
	}
	
//	deletes a book by id
	public void deleteBookById(Long id) {
		bookRepo.deleteById(id);
	}

}
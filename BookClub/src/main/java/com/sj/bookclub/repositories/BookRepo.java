package com.sj.bookclub.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sj.bookclub.models.Book;

@Repository
public interface BookRepo extends CrudRepository <Book, Long>{

//	LISTING OUT THE CHECKLIST OF METHODS WE HAVE AVAILABLE TO USE IN OUR APPLICATION IN THE CONTEXT OF THE BOOKS MODEL
	
	
//	this method retrieves all the books from the database
	List<Book> findAll();

//  this method deletes the book by id
	void deleteById(Long id);
}


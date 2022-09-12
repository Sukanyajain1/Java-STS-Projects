package com.sj.mvc.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sj.mvc.models.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long>{
//this method retrieves all the books from the database
	List<Book> findAll();

	
//this method retrieves a book by the id, and can handle if there is no book by that id
	Optional<Book> findById(Long id);
	
	
//this method deletes book by id
	void deleteById(Long id);
	
	
//this method finds the books with descriptions containing the search string
	List<Book> findByDescriptionContaining(String search);
	
	
//this method counts how many titles contain a certain string
	List<Book> countByTitleContaining(String search);
	
	
//this method deletes a book that starts with a specific string
	List<Book> deleteByTitleStartingWith(String search);

	
}

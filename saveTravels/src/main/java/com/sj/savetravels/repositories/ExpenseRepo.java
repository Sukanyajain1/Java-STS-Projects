package com.sj.savetravels.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sj.savetravels.models.Expense;

@Repository
public interface ExpenseRepo extends CrudRepository<Expense, Long>{
//LISTING OUT THE ROSTER OF FUNCTIONS WE NEED TO CALL IN THE SERVICE FILE
//	Like contents table

	
	
	List<Expense> findAll();

	void deleteById(Long id);

}

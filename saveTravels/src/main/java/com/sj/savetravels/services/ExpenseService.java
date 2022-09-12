package com.sj.savetravels.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.sj.savetravels.models.Expense;
import com.sj.savetravels.repositories.ExpenseRepo;

@Service
public class ExpenseService {
//add the repository as a dependency
	private final ExpenseRepo expenseRepo;
	
//	constructor
	public ExpenseService(ExpenseRepo expenseRepo) {
		this.expenseRepo = expenseRepo;
	}
	
//	methods
//	returns all expenses
	public List<Expense> allExpenses(){
		return expenseRepo.findAll();
	}
//	creates (saves) an expense

	public Expense createExpense(@Valid Expense expense) {
		return expenseRepo.save(expense);
	}
	
//	retrieves an expense
	public Expense findExpense(Long id) {
//		Optional returns an object that may or may not contain your search result- if it contains null, you are preparing the method to handle that result and return null further into the chain.
		Optional<Expense> optionalExpense = expenseRepo.findById(id);
		if (optionalExpense.isPresent()) {
			return optionalExpense.get();
		}else {
			System.out.println("The Expense was null");
			return null;
		}
	}

	public Expense updateExpense(Expense expense) {
		return expenseRepo.save(expense);
		
	}

	public void deleteExpense(Long id) {
		expenseRepo.deleteById(id);
	}
}

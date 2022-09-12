package com.sj.savetravels.controllers;

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
import org.springframework.web.bind.annotation.RequestMethod;

import com.sj.savetravels.models.Expense;
import com.sj.savetravels.services.ExpenseService;

@Controller
public class MainController {
	
//inject service into controller
	private final ExpenseService expenseServ;
	
	
//constructor
	public MainController (ExpenseService expenseServ) {
		this.expenseServ = expenseServ;
	}

//------------------------------------------------------------------------------
//	RENDERING THE MAIN DISPLAY PAGE
	
//	AND
	
//	CREATE AN EXPENSE
//------------------------------------------------------------------------------	
	@GetMapping("/")
	public String index(Model model, @ModelAttribute("expense") Expense expense) {
		List<Expense> expenses = expenseServ.allExpenses();
		model.addAttribute("expenses", expenses);
		return "index.jsp";
	}
	
	@PostMapping("/new")
	public String newExpense(Model model, @Valid @ModelAttribute("expense") Expense expense, BindingResult result) {
		if (result.hasErrors()) {
			System.out.println(result);
			List<Expense> expenses = expenseServ.allExpenses();
			model.addAttribute("expenses", expenses);
			
			return "index.jsp";
		}
		else {
			expenseServ.createExpense(expense);
			return "redirect:/";
		}
	}
	

//------------------------------------------------------------------------------
//	DISPLAY ONLY ONE EXPENSE
//------------------------------------------------------------------------------
	@GetMapping("/show/{id}")
	public String showOneExpense(@PathVariable("id") Long id, Model model) {
		Expense oneExpense = expenseServ.findExpense(id);
		model.addAttribute("oneExpense", oneExpense);
		return "showExpense.jsp";
	}
	
	
//------------------------------------------------------------------------------
//	UPDATE AN EXPENSE
//------------------------------------------------------------------------------
	@GetMapping("/update/{id}")
	public String updateForm(@PathVariable("id") Long id, Model model) {
		System.out.println("THE GET METHOD FOR THE UPDATE IS WORKING!!!!!!!!!!");
		Expense oneExpense = expenseServ.findExpense(id);
		model.addAttribute("oneExpense", oneExpense);
		Long testerId = oneExpense.getId();
		System.out.println(testerId);
		return "updateExpense.jsp";
	}
//	System.out.println("THIS AN ERROR RESULT!!!!!!!!!!");
	
	@PutMapping("/update/processing/{id}")
    public String updateProcess(@Valid @ModelAttribute("oneExpense") Expense expense, BindingResult result) {
//		System.out.println("THE PUT METHOD FOR THE UPDATE IS STARTING!!!!!!!!!!");
		if (result.hasErrors()) {
            return "updateExpense.jsp";
        } else {
            expenseServ.updateExpense(expense);
            return "redirect:/";
        }
	}
	
	
//------------------------------------------------------------------------------
//	DELETE AN EXPENSE
//------------------------------------------------------------------------------
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable("id") Long id) {
		expenseServ.deleteExpense(id);
		return "redirect:/";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

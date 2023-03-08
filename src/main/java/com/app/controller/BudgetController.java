package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Budget;
import com.app.service.BudgetService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/Budget")
public class BudgetController {
	
	@Autowired
	private BudgetService budgetserv;
	
	@GetMapping("/getallreport")
	public List<Budget>getAllBudget(){
		return budgetserv.getallBudget();
	}
	
	@PostMapping("/addBudget")
	public Budget addbudget(@RequestBody Budget addBudget) {
		return budgetserv.addBudget(addBudget);
	}
	
	@DeleteMapping("/deleteBudget/{id}")
	String deleteBudget(Long id) {
		return budgetserv.deleteBudget(id);
	}
	

}

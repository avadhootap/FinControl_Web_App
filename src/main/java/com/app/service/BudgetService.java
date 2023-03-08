package com.app.service;

import java.util.List;

import com.app.pojos.Budget;

public interface BudgetService {
	
	List<Budget>getallBudget();
	
	Budget addBudget(Budget addBudget);
	
	String deleteBudget(Long id);

}

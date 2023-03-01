package com.app.service;

import java.time.LocalDate;
import java.util.List;

import com.app.pojos.Expense;
import com.app.pojos.ExpenseCategoryType;
import com.app.pojos.User;

//import com.app.pojos.Expense;

public interface ExpenseService {
	
    List<Expense>getAllExpense();
	
	Expense addExpense(Expense addExpense);
	
	String deleteExpense(Long id);
	
	Expense updateExpense(Expense updateExp);
	
	List<Expense> getExpenseByDate(LocalDate date,User user);
	
	List<Expense> getExpenseByCategory(ExpenseCategoryType getcategory,User user);
	
	List<Expense> getExpenseByAmount(double amount,User user);
	
	List<Expense> getByUser(User user);

}

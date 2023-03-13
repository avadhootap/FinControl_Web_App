package com.app.service;

import java.time.LocalDate;
import java.util.List;

import com.app.dto.UpdateExpenseDto;
import com.app.pojos.Expense;
import com.app.pojos.ExpenseCategoryType;
import com.app.pojos.Income;
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
	
	public Double getTotalExpenseByUserId(Long userId);
	
	List<Expense>getgetUserExpensesSortedByAmount(Long userId);
	
	List<Expense>getgetUserExpensesSortedByDate(Long userId);
	
	public List<Expense> getExpensesByUserAndDateRange(Long userId, LocalDate startDate, LocalDate endDate);
	
	Expense getExpenseById(Long id);
	
	public String UpdateExpenseData(Long id,UpdateExpenseDto dto);
	
	List <Expense> getExpenseListByUserId(Long id);
	
	Expense addExpenseByUserId(Long id,Expense addExpense);

}

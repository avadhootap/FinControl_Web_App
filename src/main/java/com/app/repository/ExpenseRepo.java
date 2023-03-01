package com.app.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Expense;
import com.app.pojos.ExpenseCategoryType;
import com.app.pojos.User;


public interface ExpenseRepo extends JpaRepository<Expense, Long> {
	
	List<Expense> findByDateAndUser(LocalDate date,User user);

	List<Expense> findByCategoryTypeAndUser(ExpenseCategoryType categoryType, User user);
	
	List<Expense> findByAmountAndUser(double amount,User user);
	
	List<Expense> findByUser(User user);
	
}

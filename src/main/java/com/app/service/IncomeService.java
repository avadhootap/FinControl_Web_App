package com.app.service;

import java.time.LocalDate;
import java.util.List;

import com.app.pojos.Income;
import com.app.pojos.IncomeCategoryType;
import com.app.pojos.User;

public interface IncomeService {
	
	List<Income>getAllIncome();
	
	Income addIncome(Income addIncome);
	
	String deleteIncome(Long id);
	
	Income updateIncome(Income updateIncome);
	
	List<Income> findIncomeByCategory(IncomeCategoryType getIncomeByCategory,User users);
	
	List<Income> findIncomeByAmount(double Amount,User users);
	
	List<Income> findIncomeByDate(LocalDate date,User users);
	
	List<Income> findIncomeByUser(User user);
	
	Double getTotalExpenseByUserId(Long userId);
	
	List<Income> getUserIncomeSortedByAmount(Long userId);
	
	List<Income> getUserIncomeSortedByDate(Long userId);
	
	

}

package com.app.service;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.pojos.Expense;
import com.app.pojos.ExpenseCategoryType;
import com.app.pojos.User;
//import com.app.pojos.Expense;
import com.app.repository.ExpenseRepo;

@Service
@Transactional
public class ExpenseServiceImpl implements ExpenseService {
	
	@Autowired
	private ExpenseRepo exprepo;

	@Override
	public List<Expense> getAllExpense() {
		return exprepo.findAll();
	}

	@Override
	public Expense addExpense(Expense addExpense) {
		return exprepo.save(addExpense);
	}

	@Override
	public String deleteExpense(Long id) {
		if(exprepo.existsById(id)){
			exprepo.deleteById(id);
			return "Expense Deleted Sucessfullyy...";
		}
		return "Deletion Failed";
	}

	@Override
	public Expense updateExpense(Expense updateExp) {
		if(exprepo.existsById(updateExp.getExpenseid() )) {
		return exprepo.save(updateExp);
	}
	return null;
	}

	@Override
	public List<Expense> getExpenseByDate(LocalDate date, User user) {
		// TODO Auto-generated method stub
		return exprepo.findByDateAndUser(date,user);
	}

	@Override
	public List<Expense> getExpenseByCategory(ExpenseCategoryType getcategory, User user) {
		// TODO Auto-generated method stub
		return exprepo.findByCategoryTypeAndUser(getcategory, user);
	}

	@Override
	public List<Expense> getExpenseByAmount(double amount, User user) {
		// TODO Auto-generated method stub
		return exprepo.findByAmountAndUser(amount,user);
	}

	@Override
	public List<Expense> getByUser(User user) {
		
		return exprepo.findByUser(user);
	}
	
	@Override
	public Double getTotalExpenseByUserId(Long userId) {
		// TODO Auto-generated method stub
		return exprepo.getTotalExpenseByUserId(userId);
	}
	
	@Override
	public List<Expense> getgetUserExpensesSortedByAmount(Long userId) {
		return exprepo.getUserExpensesSortedByAmount(userId);
	}
	
	@Override
	public List<Expense> getgetUserExpensesSortedByDate(Long userId) {
		return exprepo.getUserExpenseSortedByDate(userId);
	}

	@Override
	public List<Expense> getExpensesByUserAndDateRange(Long userId, LocalDate startDate, LocalDate endDate) {
		
		return exprepo.findExpensesByUserAndDateRange(userId, startDate, endDate);
	}
	
	

}

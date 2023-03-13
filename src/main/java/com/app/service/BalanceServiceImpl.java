package com.app.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.pojos.User;
import com.app.repository.ExpenseRepo;
import com.app.repository.IncomeRepo;

@Service
@Transactional
public class BalanceServiceImpl implements BalanceService {
	
	@Autowired
	private ExpenseRepo expenserepo;
	 
	@Autowired
	private IncomeRepo incomerepo;

	@Override
	public Double getBalance(Long id) {
		
		Double totalExpense = expenserepo.getTotalExpenseByUserId(id);
		Double totalIncome = incomerepo.getTotalExpenseByUserId(id);
		
		if (totalExpense == null) {
            totalExpense = 0.0;
        }

        if (totalIncome == null) {
            totalIncome = 0.0;
	}
    return totalIncome - totalExpense;
}
}

package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.pojos.Budget;
import com.app.repository.BudgetRepo;

@Service
@Transactional
public class BudgetServiceImpl implements BudgetService {
	
	@Autowired
	private BudgetRepo budgetrepo;

	@Override
	public List<Budget> getallBudget() {
		return budgetrepo.findAll();
	}

	@Override
	public Budget addBudget(Budget addBudget) {
		return budgetrepo.save(addBudget) ;
	}

	@Override
	public String deleteBudget(Long id) {
		if(budgetrepo.existsById(id)) {
			budgetrepo.deleteById(id);
			return "Budget Deleted Successfully....";
		}
		return "Deletion Failed Check Id";
		
		
	}

}

package com.app.service;

import java.util.List;

import com.app.pojos.Income;

public interface IncomeService {
	
	List<Income>getAllIncome();
	
	Income addIncome(Income addIncome);
	
	String deleteIncome(Long id);
	
	Income updateIncome(Income updateIncome);

}

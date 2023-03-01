package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.pojos.Income;
import com.app.repository.IncomeRepo;

@Service
@Transactional
public class IncomeSeviceImpl implements IncomeService {
	
	@Autowired
	private IncomeRepo incomeRepo; 

	@Override
	public List<Income> getAllIncome() {
		return incomeRepo.findAll() ;
	}

	@Override
	public Income addIncome(Income addIncome) {
		return incomeRepo.save(addIncome);
	}

	@Override
	public String deleteIncome(Long id) {
		if(incomeRepo.existsById(id)) {
			incomeRepo.deleteById(id);
			return "Income Deleted Sucessfullyy...";
		}
		return "Deletion Failed";
	}

	@Override
	public Income updateIncome(Income updateIncome) {
		if(incomeRepo.existsById(updateIncome.getId())) {
			return incomeRepo.save(updateIncome);
		}
		return null;
	}

}

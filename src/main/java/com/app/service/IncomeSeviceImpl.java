package com.app.service;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.pojos.Income;
import com.app.pojos.IncomeCategoryType;
import com.app.pojos.User;
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

	@Override
	public List<Income> findIncomeByCategory(IncomeCategoryType getIncomeByCategory, User users) {
		
		return incomeRepo.findByCategoryTypeAndUsers(getIncomeByCategory, users);
	}

	@Override
	public List<Income> findIncomeByAmount(double Amount, User users) {
	
		return incomeRepo.findByAmountAndUsers(Amount, users);
	}

	@Override
	public List<Income> findIncomeByDate(LocalDate date, User users) {
		return incomeRepo.findByDateAndUsers(date, users);
	}

	@Override
	public List<Income> findIncomeByUser(User user) {
		return incomeRepo.findByUsers(user);
	}
	
	@Override
	public Double getTotalExpenseByUserId(Long userId) {
		return incomeRepo.getTotalExpenseByUserId(userId);
	}

	@Override
	public List<Income> getUserIncomeSortedByAmount(Long userId) {
		return incomeRepo.getUserIncomeSortedByAmount(userId);
	}

	@Override
	public List<Income> getUserIncomeSortedByDate(Long userId) {
		return incomeRepo.getUserIncomeSortedByDate(userId);
	}


}

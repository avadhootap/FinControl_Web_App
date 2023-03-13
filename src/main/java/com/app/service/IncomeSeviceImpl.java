package com.app.service;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.UpdateIncomeDto;
import com.app.pojos.Income;
import com.app.pojos.IncomeCategoryType;
import com.app.pojos.User;
import com.app.repository.IncomeRepo;
import com.app.repository.UserRepo;

@Service
@Transactional
public class IncomeSeviceImpl implements IncomeService {
	
	@Autowired
	private IncomeRepo incomeRepo; 
	
	@Autowired
	private UserRepo userrepo;

	@Override
	public List<Income> getAllIncome() {
		return incomeRepo.findAll() ;
	}

	@Override
	public Income addIncome(Income addIncome)
	{ 
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
	public Double getTotalIncomeByUserId(Long id) {
		return incomeRepo.getTotalExpenseByUserId(id);
	}

	@Override
	public List<Income> getUserIncomeSortedByAmount(Long userId) {
		return incomeRepo.getUserIncomeSortedByAmount(userId);
	}

	@Override
	public List<Income> getUserIncomeSortedByDate(Long userId) {
		return incomeRepo.getUserIncomeSortedByDate(userId);
	}

	@Override
	public Income getIncomeById(Long id) {
		if(incomeRepo.existsById(id)) {
		return incomeRepo.findById(id).get();	
	}
		return null;
	}

	@Override
	public String updateIncomeData(Long id, UpdateIncomeDto updateIncomeData) {
		if(incomeRepo.existsById(id)) {
			Income updateIncome=getIncomeById(id);
			updateIncome.setAmount(updateIncomeData.getAmount());
			updateIncome.setDate(updateIncomeData.getDate());
			updateIncome.setDescription(updateIncomeData.getDescription());
			updateIncome.setCategoryType(updateIncomeData.getCategoryType());
			return "Updated SucessFully...";
		}
		return "Error Updating Check Id";
	}

	@Override
	public List<Income> getIncomeListById(Long id) {
		User user=userrepo.findById(id).get();
		return incomeRepo.findByUsers(user);
	}

	@Override
	public Income addIncomeByUserId(Long id, Income addincome) {
		User user=userrepo.findById(id).get();
		addincome.setUsers(user);
		return incomeRepo.save(addincome);
	}

}

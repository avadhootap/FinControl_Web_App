package com.app.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Income;
import com.app.pojos.IncomeCategoryType;
import com.app.pojos.User;

public interface IncomeRepo extends JpaRepository<Income, Long> {
	
	List<Income> findByCategoryTypeAndUsers (IncomeCategoryType categoryType,User users);
	
	List<Income> findByAmountAndUsers (double amount, User users);
	
	List<Income> findByDateAndUsers (LocalDate date, User users);
	
	List<Income> findByUsers(User user);
	

}

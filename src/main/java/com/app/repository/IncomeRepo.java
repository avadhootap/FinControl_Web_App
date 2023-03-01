package com.app.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.pojos.Income;
import com.app.pojos.IncomeCategoryType;
import com.app.pojos.User;

public interface IncomeRepo extends JpaRepository<Income, Long> {
	
	List<Income> findByCategoryTypeAndUsers (IncomeCategoryType categoryType,User users);
	
	List<Income> findByAmountAndUsers (double amount, User users);
	
	List<Income> findByDateAndUsers (LocalDate date, User users);
	
	List<Income> findByUsers(User user);
	
	@Query("SELECT SUM(i.amount) FROM Income i WHERE i.users.id = :userId")
    Double getTotalExpenseByUserId(@Param("userId") Long userId);
	
	@Query("SELECT i FROM Income i WHERE i.users.id = :userId ORDER BY i.amount ASC")
	List<Income> getUserIncomeSortedByAmount(@Param("userId") Long userId);
	
	@Query("SELECT i FROM Income i WHERE i.users.id = :userId ORDER BY i.date ASC")
	List<Income> getUserIncomeSortedByDate(@Param("userId") Long userId);
	

}

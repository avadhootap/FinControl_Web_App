package com.app.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.pojos.Expense;
import com.app.pojos.ExpenseCategoryType;
import com.app.pojos.User;


public interface ExpenseRepo extends JpaRepository<Expense, Long> {
	
	List<Expense> findByDateAndUser(LocalDate date,User user);

	List<Expense> findByCategoryTypeAndUser(ExpenseCategoryType categoryType, User user);
	
	List<Expense> findByAmountAndUser(double amount,User user);
	
	List<Expense> findByUser(User user);
	
	@Query("SELECT SUM(e.amount) FROM Expense e WHERE e.user.id = :userId")
    Double getTotalExpenseByUserId(@Param("userId") Long userId);
	
	@Query("SELECT e FROM Expense e WHERE e.user.id = :userId ORDER BY e.amount ASC")
	List<Expense> getUserExpensesSortedByAmount(@Param("userId") Long userId);
	
	@Query("SELECT e FROM Expense e WHERE e.user.id = :userId ORDER BY e.date ASC")
	List<Expense> getUserExpenseSortedByDate(@Param("userId") Long userId);
	
	  @Query("SELECT e FROM Expense e WHERE e.user.id = :userId AND e.date BETWEEN :startDate AND :endDate")
	    List<Expense> findExpensesByUserAndDateRange(@Param("userId") Long userId, @Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);
	
}

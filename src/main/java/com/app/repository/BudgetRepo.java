package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Budget;

public interface BudgetRepo extends JpaRepository<Budget, Long> {
	

}

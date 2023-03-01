package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Income;

public interface IncomeRepo extends JpaRepository<Income, Long> {
	
	

}

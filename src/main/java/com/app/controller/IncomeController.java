package com.app.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.app.pojos.Income;
import com.app.service.IncomeService;

@RestController
@RequestMapping("/income")
public class IncomeController {
	
	@Autowired
	private IncomeService incomeserv;
	
	@GetMapping
	public List<Income>getAllIncome(){
		return incomeserv.getAllIncome();
	}
	
	@PostMapping
	Income addIncome(@RequestBody Income addIncome) {
		return incomeserv.addIncome(addIncome);
	}
	
	@DeleteMapping("/{id}")
	String deleteIncome(@PathVariable Long id) {
		return incomeserv.deleteIncome(id);
	}
	
	@PutMapping
	Income updateIncome(@RequestBody Income updateIncome) {
		return incomeserv.updateIncome(updateIncome);
	}

}

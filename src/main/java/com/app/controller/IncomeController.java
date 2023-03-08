package com.app.controller;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.UpdateIncomeDto;
import com.app.pojos.Income;
import com.app.pojos.IncomeCategoryType;
import com.app.pojos.User;
import com.app.service.IncomeService;

@CrossOrigin(origins ="http://localhost:3000")
@RestController
@RequestMapping("/income")
public class IncomeController {
	
	@Autowired
	private IncomeService incomeserv;
	
	@GetMapping("/getincome")
	public List<Income>getAllIncome(){
		return incomeserv.getAllIncome();
	}
	
	@GetMapping("/getbycategory")
	public List<Income>getIncomeByCategory(IncomeCategoryType getincome,User users){
		return incomeserv.findIncomeByCategory(getincome, users);
	}
	
	@GetMapping("/getbyAmount")
	public List<Income>getIncomeByAmount(double Amount,User user){
		return incomeserv.findIncomeByAmount(Amount, user);
	}
	
	@PostMapping("/getbyDate")
	public List<Income>getIncomeByDate(@RequestBody LocalDate date,User user){
		return incomeserv.findIncomeByDate(date, user);
	}
	
	@GetMapping("/getbyUser")
	public List<Income>getIncomeByUser(User user){
		return incomeserv.findIncomeByUser(user);
	}
	
	@GetMapping("/getTotalIncome")
	Double getTotalExpenseByUserId(Long userId) {
		return incomeserv.getTotalExpenseByUserId(userId);
	}
	
	@GetMapping("/getIncomeSortedByAmount")
	List<Income> getUserExpensesSortedByAmount(Long userId){
		return incomeserv.getUserIncomeSortedByAmount(userId);
	}
	
	@GetMapping("/getIncomeSortedByDate")
	List<Income> getUserExpensesSortedByDate(Long userId){
		return incomeserv.getUserIncomeSortedByDate(userId);
	}
	
	@PostMapping("/addincome")
	Income addIncome(@RequestBody Income addIncome) {
		return incomeserv.addIncome(addIncome);
	}
	
	@DeleteMapping("/deleteincome/{id}")
	String deleteIncome(@PathVariable Long id) {
		return incomeserv.deleteIncome(id);
	}
	
	@PutMapping("/updateincome/{id}")
	Income updateIncome(@PathVariable Long id ,@RequestBody Income updateIncome) {
		return incomeserv.updateIncome(updateIncome);
	}
	
	@GetMapping("/getincomebyid/{id}")
	Income getIncomeByid(@PathVariable Long id) {
		return incomeserv.getIncomeById(id);
	}
	
	@PutMapping("/updateincomedata/{id}")
	String updateIncomedata(@PathVariable Long id, @RequestBody UpdateIncomeDto updateIncomdata) {
		return incomeserv.updateIncomeData(id, updateIncomdata);
	}

}

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

import com.app.dto.UpdateExpenseDto;
import com.app.pojos.Expense;
import com.app.pojos.ExpenseCategoryType;
import com.app.pojos.User;
//import com.app.pojos.Expense;
import com.app.service.ExpenseService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/Expense")
public class ExpenseController {
	
	@Autowired
	private ExpenseService expserv;
	
	
	@GetMapping("/expense")
	public List<Expense>getAllExpense(){
		return expserv.getAllExpense();
	}
	
	//GetExpenseByDate
	@PostMapping("/getExpByDate")
	List<Expense> getExpByDate(@RequestBody LocalDate date,User user) {
		return expserv.getExpenseByDate(date,user);
	}
	
	@GetMapping("/getExpByAmount")
	public List<Expense>getAllAmount(double amount,User user){
		return expserv.getExpenseByAmount(amount,user);
	}
	
	
	
	@PostMapping("/getExpByCategory")
	public List<Expense> getExpenseByCategory(@RequestBody ExpenseCategoryType getcategory, User user) {
		return expserv.getExpenseByCategory(getcategory, user);
	}
	
	@GetMapping("/getTotalExp/{id}")
	public Double getTotalExpenseByUserId(@PathVariable Long id) {
		return expserv.getTotalExpenseByUserId(id);
	}
	
	@GetMapping("/getExpSortedByAmount/{id}")
	List<Expense>getExpSortedByAmount(@PathVariable Long id){
		return expserv.getgetUserExpensesSortedByAmount(id);
	}
	
	@GetMapping("/getreport/{id}/{startDate}/{endDate}")
	public List<Expense> getExpensesByUserAndDateRange(@PathVariable Long id, @PathVariable String startDate, @PathVariable String endDate){
	    return expserv.getExpensesByUserAndDateRange(id, LocalDate.parse(startDate), LocalDate.parse(endDate));
	}
	
	@PostMapping("/addexpense")
	Expense addExpense(@RequestBody Expense addExpense) {
		return expserv.addExpense(addExpense);
	}
	
	@GetMapping("/getUserExp")
	public List<Expense>getAllUserExp(@PathVariable User user){
		return expserv.getByUser(user);
	}
	
	@GetMapping("/getExpSortedByDate/{id}")
	List<Expense> getUserSortedByAmount(@PathVariable Long id){
		return expserv.getgetUserExpensesSortedByDate(id);
	}
	
	@DeleteMapping("/deleteExpense/{id}")
	String deleteuser(@PathVariable Long id) {
		return expserv.deleteExpense(id);
		
	}
	
	@PutMapping("/updateexpense/{id}")
	Expense updateExpense(@PathVariable Long id, @RequestBody Expense updateexp) {
		return expserv.updateExpense(updateexp);
	}
	
	@GetMapping("/getExpenseByid/{id}")
	Expense getexpenseById(@PathVariable Long id) {
		return expserv.getExpenseById(id);
		
	}
	
	@PutMapping("/updateExpenseData/{id}")
	public String UpdateExpenseData(@PathVariable Long id,@RequestBody UpdateExpenseDto dto) {
		return expserv.UpdateExpenseData(id, dto);
	}
	@GetMapping("/getUserExpenseById/{id}")
	public List<Expense> getExpenseListByUserId(@PathVariable Long id){
		return expserv.getExpenseListByUserId(id);
		
	}
	
	@PostMapping("/addIncomeByUserId/{id}") 
	Expense addExpenseByUserId(@PathVariable Long id,@RequestBody Expense addExpense) {
		return expserv.addExpenseByUserId(id, addExpense);
	}
	
}

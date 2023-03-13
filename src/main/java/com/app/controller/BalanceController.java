package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.User;
import com.app.service.BalanceService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/Balance")
public class BalanceController {
	
	@Autowired
	private BalanceService balanceserv;
	
	@GetMapping("/getBalance/{id}")
	public Double getBalance(@PathVariable Long id) {
		return balanceserv.getBalance(id);
	}

}

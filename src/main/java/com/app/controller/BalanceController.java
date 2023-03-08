package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.User;
import com.app.service.BalanceService;

@RestController
@RequestMapping("/Balance")
public class BalanceController {
	
	@Autowired
	private BalanceService balanceserv;
	
	@GetMapping("/getBalance")
	public Double getBalance(User user) {
		return balanceserv.getBalance(user);
	}

}

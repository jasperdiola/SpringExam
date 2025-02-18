package com.javaCoding.javaCoding.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javaCoding.javaCoding.model.Account;
import com.javaCoding.javaCoding.service.AccountService;

@RestController
public class AccountController {
	
	@Autowired
	AccountService accountService;
	
	@GetMapping("/accounts/{accountNumber}")
	public Account getAccountByCustomerId(@PathVariable long accountNumber) {
		return accountService.getAccountByCustomerId(accountNumber);
	}
	
	@GetMapping("/accounts")
	public List<Account> getAccounts() {
		return accountService.getAccountsByCustomerId();
	}
	
	@PostMapping("/accounts/{customerNumber}")
	public Account addCustomerAccount(@PathVariable long customerNumber, @RequestBody Account account) {
		return accountService.addCustomerAccount(customerNumber, account);
	}
	
}

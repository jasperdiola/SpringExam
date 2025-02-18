package com.javaCoding.javaCoding.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaCoding.javaCoding.model.Account;
import com.javaCoding.javaCoding.model.Customer;
import com.javaCoding.javaCoding.repository.AccountRepo;
import com.javaCoding.javaCoding.repository.CustomerRepo;

@Service
public class AccountService {
	
	@Autowired
	CustomerRepo customerRepo;
	
	@Autowired
	AccountRepo accountRepo;
	
	public List<Account> getAccountsByCustomerId() {
		return accountRepo.findAll();
	}
	
	public Account getAccountByCustomerId(long accountNumber) {
		return accountRepo.findById(accountNumber).orElse(null);
	}
	
	public Account addCustomerAccount(long customerNumber, Account account) {
		Customer customer = customerRepo.findById(customerNumber).orElse(null);
		
		if (customer != null) {
			account.setCustomer(customer);
			return accountRepo.save(account);
		}
		
		return null;
		
	}
}

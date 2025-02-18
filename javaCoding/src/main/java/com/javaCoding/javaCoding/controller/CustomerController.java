package com.javaCoding.javaCoding.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javaCoding.javaCoding.model.Customer;
import com.javaCoding.javaCoding.model.TransactionResponse;
import com.javaCoding.javaCoding.service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@GetMapping("/customers")
	public List<Customer> getCustomerInfos() {
		return customerService.getCustomers();
	}
	
	@GetMapping("/customers/{customerId}")
	public Customer getCustomerInfos(@PathVariable int customerId) {
		return customerService.getCustomerById(customerId);
	}
	
	@PostMapping("/customers")
	public ResponseEntity<TransactionResponse> addCustomer(@RequestBody Customer customer) {
		TransactionResponse response = customerService.addCustomer(customer);
		return new ResponseEntity<TransactionResponse>(response, HttpStatus.CREATED);
	}
	
	@PutMapping("/customers")
	public Customer updateCustomerInfo(@RequestBody Customer customer) {
		return customerService.updateCustomerInfo(customer);
	}
	
	@DeleteMapping("/products/{customerId}")
	public void deleteCustomer(@PathVariable int customerId) {
		customerService.deleteCustomer(customerId);
	}
}

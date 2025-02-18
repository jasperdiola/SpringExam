package com.javaCoding.javaCoding.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaCoding.javaCoding.Exceptions.BadRequestException;
import com.javaCoding.javaCoding.model.Customer;
import com.javaCoding.javaCoding.model.TransactionResponse;
import com.javaCoding.javaCoding.repository.CustomerRepo;

@Service
public class CustomerService {
	
	@Autowired
	CustomerRepo customerRepo;
	
	/**
	 * To get list of all Customers
	 * @return list of Customers
	 */
	public List<Customer> getCustomers() {
		return customerRepo.findAll();
	}
	
	/**
	 * To get specific customer by id
	 * @param customerId
	 * @return Customer
	 */
	public Customer getCustomerById(long customerId) {
		return customerRepo.findById(customerId).orElse(null);
	}
	
	/**
	 * To add another customer
	 * @param customer
	 * @return Customer
	 */
	public TransactionResponse addCustomer(Customer customer) {
		if (Objects.isNull(customer.getCustomerName())) {
			throw new BadRequestException("Name is required.");
		}
		
		if (Objects.isNull(customer.getCustomerEmail())) {
			throw new BadRequestException("Email is required.");
		}
		
		Customer addedCustomer = customerRepo.save(customer);
		long customerNumber = addedCustomer.getCustomerNumber();
		return new TransactionResponse(customerNumber, 201, "Customer account created successfully");
	}
	
	/**
	 * To update specific customer by id
	 * @param customer
	 * @return Customer
	 */
	public Customer updateCustomerInfo(Customer customer) {
		return customerRepo.save(customer);
	}
	
	/**
	 * To delete specific customer by id
	 * @param customerId
	 */
	public void deleteCustomer(long customerId) {
		customerRepo.deleteById(customerId);
	}
}

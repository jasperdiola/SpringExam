package com.javaCoding.javaCoding.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaCoding.javaCoding.model.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Long> {

}

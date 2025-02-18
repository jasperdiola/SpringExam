package com.javaCoding.javaCoding.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaCoding.javaCoding.model.Account;

public interface AccountRepo extends JpaRepository<Account, Long> {
	
}

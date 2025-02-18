package com.javaCoding.javaCoding.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaCoding.javaCoding.model.Product;

public interface ProductRepo extends JpaRepository<Product, Integer> {

}
	
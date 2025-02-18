package com.javaCoding.javaCoding.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaCoding.javaCoding.model.Product;
import com.javaCoding.javaCoding.repository.ProductRepo;

@Service
public class ProductService {
	
	@Autowired
	ProductRepo productRepo;
	
	List<Product> products = new ArrayList<>(Arrays.asList(
			new Product(101, "Iphone", 50000),
			new Product(102, "Canon Camera", 70000),
			new Product(103, "Steel Series", 10000)
			));
	
	public List<Product> getProducts() {
		return productRepo.findAll();	}
	
	public Product getProductById(int prodId) {
		return productRepo.findById(prodId).orElse(new Product());
	}
	
	public Product addProduct(Product product) {
		return productRepo.save(product);
	}
	
	public Product updateProduct(Product prod) {
		return productRepo.save(prod);
				
	}
	
	public void deleteProduct(int id) {
		productRepo.deleteById(id);
	}

}

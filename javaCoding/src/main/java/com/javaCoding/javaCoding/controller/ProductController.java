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

import com.javaCoding.javaCoding.model.Product;
import com.javaCoding.javaCoding.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	ProductService productService;
	
	@GetMapping("/products")
	public List<Product> getProducts() {
		return productService.getProducts();
	}
	
	@GetMapping("/products/{prodId}")
	public Product getProducts(@PathVariable int prodId) {
		return productService.getProductById(prodId);
	}
	
	@PostMapping("/products")
	public Product addProduct(@RequestBody Product product) {
		return productService.addProduct(product);
	}
	
	@PutMapping("/products")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
		return new ResponseEntity<Product>(productService.updateProduct(product), HttpStatus.ALREADY_REPORTED);
	}
	
	@DeleteMapping("/products/{id}")
	public void deleteProduct(@PathVariable int id) {
		productService.deleteProduct(id);
	}
	
}

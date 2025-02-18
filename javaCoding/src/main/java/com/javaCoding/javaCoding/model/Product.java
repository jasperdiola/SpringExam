package com.javaCoding.javaCoding.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {
	@Id
	private int prodId;
	@Column(name="PROD_NAME")
	private String prodName;
	@Column(name="PRICE")
	private int price;
}

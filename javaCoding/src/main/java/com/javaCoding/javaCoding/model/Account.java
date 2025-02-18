package com.javaCoding.javaCoding.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "account")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long accountNumber;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private AccountType accountType;
	
	@Column(nullable = false)
	private double availableBalance;
	
	@ManyToOne
	@JoinColumn(name = "customer_number", nullable = false)
	@JsonBackReference
	private Customer customer;
	
	public enum AccountType {
		SAVINGS, CHECKING;
	}
}

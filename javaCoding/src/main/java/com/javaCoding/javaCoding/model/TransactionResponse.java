package com.javaCoding.javaCoding.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionResponse {
	private long customerNumber;
    private int transactionStatusCode;
    private String transactionStatusDescription;
}

package com.javaCoding.javaCoding.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.javaCoding.javaCoding.model.TransactionResponse;

public class GlobalExceptionHandler {
	
	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<TransactionResponse> handleBadRequestException(BadRequestException ex) {
        TransactionResponse response = new TransactionResponse(
                0,  // No customerNumber because it's a failure
                400,
                ex.getMessage()
        );
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}

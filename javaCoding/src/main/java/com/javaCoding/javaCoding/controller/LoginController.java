package com.javaCoding.javaCoding.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
	
	@RequestMapping("/")
	public String greet() {
		return "Hello World!";
	}

}

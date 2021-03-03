package com.example.demo3.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestApiController {
	
	@GetMapping("/test")
	public String hello() {
		
		return "hello world";
	}
}

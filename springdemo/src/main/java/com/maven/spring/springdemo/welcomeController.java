package com.maven.spring.springdemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class welcomeController {
	
	/*
	 * @GetMapping("/Welcome") public String Welcome() {
	 * 
	 * return "Welcome to SPring Rest webservice"; }
	 * 
	 * 
	 * @GetMapping("/Hello") public String Hello() {
	 * 
	 * return "THIS IS HELLO METHOD";
	 * 
	 * }
	 */
	
	@GetMapping("/User")
	public String user() {
		
		return "THIS IS USER PAGE";
		
	}

	@GetMapping("/Admin")
	public String admin() {
		
		return "THIS IS ADMIN PAGE";
		
	}

	
	
	
	

}

package com.springsecurity.jdbc.jdbcauthentication;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class demoSpringAuthJdbc {
	
	
	@GetMapping("/User")
	public String user() {
		
		return "THIS IS USER PAGE";
		
	}

	@GetMapping("/Admin")
	public String admin() {
		
		return "THIS IS ADMIN PAGE";
		
	}


}

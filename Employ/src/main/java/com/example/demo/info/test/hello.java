package com.example.demo.info.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class hello {
	@GetMapping("/hi")
	public String display() {
		return "welcome";
	}

}
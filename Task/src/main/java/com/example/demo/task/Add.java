package com.example.demo.task;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Add {
	@GetMapping("/hii")
	public String display() {
		return "welcome";
	}

}

package com.example.demo.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Addition {
	@Autowired
	Demoservice ds;
	@GetMapping("/add/{num1}/{num2}")
	public String Addition1(@PathVariable("num1") int num1,@PathVariable("num2") int num2) {
		int total=ds.Add(num1, num2);
		return  "the sum is :"+total;
	}
	@GetMapping("/sub/{num1}/{num2}")
	public String Subtraction(@PathVariable("num1") int num1,@PathVariable("num2") int num2) {
		int total=ds.Sub(num1, num2);
		return  "the sum is :"+total;
	}
	@GetMapping("/mul/{num1}/{num2}")
	public String Multiplication(@PathVariable("num1") int num1,@PathVariable("num2") int num2) {
		int total=ds.Mul(num1, num2);
		return  "the sum is :"+total;
	}
	@GetMapping("/div/{num1}/{num2}")
	public String Division(@PathVariable("num1") int num1,@PathVariable("num2") int num2) {
		try {
			int total=ds.Div(num1, num2);
			return  "the sum is : "+total;
		}
		catch(ArithmeticException e) {
			return "Denominator must greater than 0";
		}
			
	}
	

}

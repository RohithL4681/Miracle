package com.example.demo.task;

import org.springframework.stereotype.Service;

@Service
public class Demoservice {
	public int Add(int num1,int num2) {
		return num1+num2;
	}
	public int Sub(int num1,int num2) {
		return num1-num2;
	}
	public int Mul(int num1,int num2) {
		return num1*num2;
	}
	public int Div(int num1,int num2) {
		
		return num1/num2;
	}


}

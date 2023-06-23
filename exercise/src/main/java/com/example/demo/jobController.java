package com.example.demo;



import java.util.List;

import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;


@RestController

public class jobController {

	@Autowired

	jobService s;

	@GetMapping("/Join")

	public List<Map<String,Object>> TablesJoining(Join j) {

		return s.TablesJoining(j);

	}


}



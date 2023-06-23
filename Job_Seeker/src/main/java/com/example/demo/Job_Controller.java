package com.example.demo;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

@RestController
public class  Job_Controller {
	@Autowired
	Job_Service jobservice;
	@PostMapping("/emp-insert1")
	public Map insertJobData(@RequestBody Job e) {
		return jobservice.insertJobData(e);
	}
	
	
	}


	



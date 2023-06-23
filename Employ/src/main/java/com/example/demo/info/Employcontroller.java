package com.example.demo.info;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Employcontroller {
	@Autowired
	Empservice es;
	@PostMapping("insert")
	public String insert(@RequestBody Employ e) {
	int i=es.insert(e);
	if (i>0) {
		return "data insertion is done";
	}
	else {
		return "data not inserted";
	}
	}
	@Autowired
	Employfired ef;
	@PostMapping("delete")
	public String delete(@RequestBody Employ e) {
	int i=ef.delete(e);
	if (i>0) {
		return "data deleted";
	}
	else {
		return "data not deleted";
	}
	}
	@Autowired
	Empupdate eu;
	@PostMapping("update")
	public String updatee(@RequestBody Employ e) {
	int i=eu.updatee(e);
	if (i>0) {
		return "data deleted";
	}
	else {
		return "data not deleted";
	}
	}
	@Autowired
	Empdetails ed;
	@GetMapping("/fetch")
	public List fetchList() {
    return ed.fetchList(null);
	
	}
	
}


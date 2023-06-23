package com.example.demo.info;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class Empservice {
	@Autowired
	JdbcTemplate js;
	
	public int insert(Employ e) {
		int id=e.getId();
		String name=e.getName();
		int age=e.getAge();
		String deg=e.getDeg();
		String email=e.getEmail();
		String sql="insert into info values(?,?,?,?,?)";
		int i=js.update(sql,id,name,age,deg,email);
		return i;
	}
}

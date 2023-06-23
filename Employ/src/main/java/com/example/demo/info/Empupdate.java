package com.example.demo.info;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class Empupdate {
	@Autowired
	JdbcTemplate js;
	
	public int updatee(Employ e) {
		int id=e.getId();
		String name=e.getName();
		int age=e.getAge();
		String deg=e.getDeg();
		String email=e.getEmail();
		String sql="UPDATE info SET name = ?, age = ?, deg = ?, email = ? WHERE id = ?";
		int i=js.update(sql,name,age,deg,email,id);
		return i;
	}
}
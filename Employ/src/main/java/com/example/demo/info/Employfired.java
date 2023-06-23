package com.example.demo.info;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
@Service
public class Employfired {
	@Autowired
	JdbcTemplate js;
	
	public int delete(Employ e) {
		int id=e.getId();
		String sql="delete from info where id=?";
		int i=js.update(sql,id);
		return i;
	}

	

	

}
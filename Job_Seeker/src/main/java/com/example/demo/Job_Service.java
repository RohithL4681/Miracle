package com.example.demo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;

@Service
public class Job_Service {
	

	@Autowired
	NamedParameterJdbcTemplate namedtemplate;
	public Map insertJobData(Job job) {
		HashMap<String, String> hm = new HashMap<>();
		int User_id = job.getUser_id();
	String UserName = job.getUserName();
	String Password = job.getPassword();
	String Email = job.getEmail();
	String Role = job.getRole();
		
		String sql = "insert into User(UserName,Password,Email,Role) values(:UserName,:Password,:Email,:Role)";
		SqlParameterSource ps = new MapSqlParameterSource().addValue("UserName", UserName).addValue("Password", Password)
				.addValue("Email", Email)
				.addValue("Role", Role);
				
		int i = namedtemplate.update(sql, ps);
		if (i > 0) {
			hm.put("success", "values inserted");
		} else {
			hm.put("failure", "values not inserted");
		}
		return hm;
	}
	

}

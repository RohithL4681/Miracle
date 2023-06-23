package com.example.demo;




import java.util.List;

import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.stereotype.Service;


@Service

public class jobService {

	@Autowired

	JdbcTemplate js;

	public List<Map<String,Object>> TablesJoining(Join j) {

		String sql="Select U.User_id,U.UserName,P.fullname,P.id From User U Join Profile P ON U.User_id=P.id";

		return js.queryForList(sql);

	}


}
package com.example.demo.page;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
	private final JdbcTemplate jdbcTemplate;

	public StudentService(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@SuppressWarnings("deprecation")
	public List<Student> getEntities(int pageNumber, int pageSize) {
		int offset = pageNumber * pageSize;
		String sql = "SELECT * FROM student LIMIT ? OFFSET ?";

		return jdbcTemplate.query(sql, new Object[] { pageSize, offset }, (rs, rowNum) -> {
			final Student entity = new Student();
			entity.setId(rs.getLong("id"));
			entity.setName(rs.getString("name"));
// Set other fields as needed
			return entity;
		});
	}

	

	
	

	

}
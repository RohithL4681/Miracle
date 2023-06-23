package com.example.demo.Files;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class FileService {
	@Autowired
	JdbcTemplate jt;
	public String uploadFile(String filename, byte[] filedata) {
		String sql="insert into files(filename,filedata) values(?,?)";
		jt.update(sql,filename,filedata);
		return filename;
		
	}
}

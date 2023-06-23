package com.example.demo.table;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class User_service {
@Autowired
User_repo ur;
	public User insertData(User u) {
		
		return ur.save(u);
	}
	public List<User> readData() {
		System.out.println(ur.findAll());
        return ur.findAll();
    }
//	 public void delete(long userId) {
//	        ur.deleteById(userId);
//	    }
//	public User getAllUsers(long userId) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	
	}



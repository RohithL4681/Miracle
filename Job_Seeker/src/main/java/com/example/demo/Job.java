package com.example.demo;

public class Job {
	private int user_id;
	private String userName;
	private String password;
	private String email;
	private String role;

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public Job(int user_id, String userName, String password, String email, String role) {
		super();
		this.user_id = user_id;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.role = role;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
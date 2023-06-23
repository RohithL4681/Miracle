package com.example.demo.table;

import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Table(name="reserve")
@Entity
public class User {
@Id

//@GeneratedValue(strategy = GenerationType.AUTO)
private String fname;
private String lname;
private Long phoneno;
private String email;
private String password;
public String getFname() {
	return fname;
}
public void setFname(String fname) {
	this.fname = fname;
}
public String getLname() {
	return lname;
}
public void setLname(String lname) {
	this.lname = lname;
}
public Long getPhoneno() {
	return phoneno;
}
public void setPhoneno(Long phoneno) {
	this.phoneno = phoneno;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}










}

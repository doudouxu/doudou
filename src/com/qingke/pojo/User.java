package com.qingke.pojo;

import java.util.Date;

public class User {
   private Integer id;
   private String username;
   private String password;
   private String email;
   private Date updatetime;
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
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
public Date getUpdatetime() {
	return updatetime;
}
public void setUpdatetime(Date updatetime) {
	this.updatetime = updatetime;
}
}

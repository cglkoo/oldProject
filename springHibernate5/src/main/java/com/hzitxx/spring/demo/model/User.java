package com.hzitxx.spring.demo.model;

import com.hzitxx.spring.demo.annotation.LoginCheck;

@LoginCheck(name="123", value="565")
public class User {
	
	private int userId;
	private String userName;
	private String password;

	public User() {
		super();
	}

	public User(int userId, String userName, String password) {
		this.userId = userId;
		this.userName = userName;
		this.password = password;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getUserId() {
		return userId;
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + "]";
	}
	
	

}

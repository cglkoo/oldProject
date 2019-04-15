package com.java.impl;

import com.java.entity.User;
import com.java.service.UserService;

public class UserServiceImpl implements UserService {
	
	private User user;
	

	@Override
	public void doAdd(String param1, String param2, String param3) {
		System.out.println("======执行添加动作用户动作，用户为："+user.toString());

	}

	@Override
	public void doUpdate() {
		System.out.println("======执行修改用户动作=======");
	}

	@Override
	public void doDelete() {
		System.out.println("======执行删除用户动作=======");

	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	@Override
	public String toString() {
		return "UserServiceImpl [user=" + user + "]";
	}
	
	

}

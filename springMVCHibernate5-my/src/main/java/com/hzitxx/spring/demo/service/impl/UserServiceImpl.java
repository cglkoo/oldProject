package com.hzitxx.spring.demo.service.impl;

import com.entity.TBlUser;
import com.hzitxx.spring.demo.service.UserService;

public class UserServiceImpl implements UserService {

	private TBlUser user;
	
	public TBlUser getUser() {
		return user;
	}

	public void setUser(TBlUser user) {
		this.user = user;
	}

	@Override
	public void doAdd(String param1, String param2, String param3) {
		System.out.println("==== 执行新增动作 ，用户名是:" + user.getUserName());
		
	}

	@Override
	public void doUpdate() {
		System.out.println("==== 执行修改动作 ====");
	}

	@Override
	public void doDelete() {
		System.out.println("==== 执行删除动作 ====");
		int i = 1/0;
		System.out.println(i);
	}

}

package com.hzitxx.spring.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hzitxx.spring.demo.dao.IUserHobbyDao;
import com.hzitxx.spring.demo.model.UserHobby;
import com.hzitxx.spring.demo.service.IUserHobbyService;
@Service("iUserHobbyService")
public class UserHobbyServiceImpl implements IUserHobbyService {
	@Autowired
	private IUserHobbyDao iUserHobbyDao;
	
	@Override
	public int addUserHobby(UserHobby userHobby) {
		return this.iUserHobbyDao.addUserHobby(userHobby);
	}

	@Override
	public int delUserHobby(UserHobby userHobby) {
		return this.iUserHobbyDao.delUserHobby(userHobby);
	}

}

package com.mybatis.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mybatis.dao.IUserHobbyDao;
import com.mybatis.entity.UserHobby;
import com.mybatis.service.IUserHobbyService;
@Service("IUserHobbyService")
public class UserHobbyServiceImpl implements IUserHobbyService {

	@Autowired
	private IUserHobbyDao userHobbyDao;

	@Override
	public int addUserHobby(UserHobby uh) {
		
		return userHobbyDao.addUserHobby(uh);
	}

	@Override
	public List<UserHobby> getHobbyListByUId(int getuId) {
		
		return userHobbyDao.getHobbyListByUId(getuId);
	}

	@Override
	public int delUserHobby(UserHobby uh) {
		return userHobbyDao.delUserHobby(uh);
	}
}

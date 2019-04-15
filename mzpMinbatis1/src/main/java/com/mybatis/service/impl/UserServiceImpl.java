package com.mybatis.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mybatis.dao.IUserDao;
import com.mybatis.entity.User;
import com.mybatis.service.IUserService;
@Service("IUserService")
public class UserServiceImpl implements IUserService {
	
	@Autowired
	private IUserDao userDao;
	@Override
	public int addUser(User user) {
		return userDao.addUser(user);
	}

	@Override
	public int delUser(int id) {
		return userDao.delUser(id);
	}

	@Override
	public int updateUser(User user) {
		return userDao.updateUser(user);
	}

	@Override
	public List<User> getUserList(User user) {
		return userDao.getUserList(user);
	}

	@Override
	public long getUserLines(String keyword) {
		return userDao.getUserLines(keyword);
	}

	@Override
	public User getUserById(int id) {
		return userDao.getUserById(id);
	}

}

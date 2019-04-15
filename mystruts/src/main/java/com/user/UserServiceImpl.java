package com.user.action;

import java.util.List;

import com.java.dao.Dao;


public class UserServiceImpl implements IUserService {

	@Override
	public int addOrUpdateOrDelete(String sql, Object... args) {
		return Dao.addOrUpdateorDelete(sql, args);
	}

	@Override
	public List<TBlUser> getUsersByProperty(String sql, Object... args) {
		return Dao.getObjectsForList(TBlUser.class, sql, args);
	}

	@Override
	public Object getObjectByProperty(String sql, Object... args) {
		return Dao.getObjectByProperty(sql, args);
	}

}

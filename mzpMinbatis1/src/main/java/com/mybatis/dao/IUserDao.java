package com.mybatis.dao;

import java.util.List;

import com.mybatis.entity.User;

public interface IUserDao {
	public int addUser(User user);
	public int delUser(int id);
	public int updateUser(User user);
	public List<User> getUserList(User user);
	public long getUserLines(String keyword);
	public User getUserById(int id);
}

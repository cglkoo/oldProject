package com.mybatis.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mybatis.dao.IUserDao;
import com.mybatis.entity.BaseDaoSqlSession;
import com.mybatis.entity.User;

@Repository("IUserDao")
public class UserDaoImpl extends BaseDaoSqlSession implements IUserDao {

	@Override
	public int addUser(User user) {
		return this.getSession().insert("com.UserMapper.addUser",user);
	}
	@Override
	public int delUser(int id) {
		return this.getSession().delete("com.UserMapper.delUser", id);
	}
	@Override
	public int updateUser(User user) {
		return this.getSession().update("com.UserMapper.updateUser", user);
	}
	@Override
	public List<User> getUserList(User user) {
		return this.getSession().selectList("com.UserMapper.getAllUser",user);
	}
	@Override
	public long getUserLines(String keyword) {
		return this.getSession().selectOne("com.UserMapper.getCount",keyword);

	}
	@Override
	public User getUserById(int id) {
		return this.getSession().selectOne("com.UserMapper.getUserById",id);
	}
	
	

}

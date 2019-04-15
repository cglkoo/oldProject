package com.java.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.TBlUserDao;
import com.java.entity.Page;
import com.java.entity.TBlUser;
import com.java.service.TBlUserService;


@Service("tblUserService")
public class TBlUserServiceImpl implements TBlUserService{
	@Autowired
	private TBlUserDao tblUserDao;
	
	@Override
	public int addUser(TBlUser user) {
		int result=tblUserDao.addUser(user);
		return result;
	}
	@Override
	public int updateUser(TBlUser user) {
		int result=tblUserDao.updateUser(user);
		return result;
	}

	@Override
	public int deleteUser(int id) {
		int result=tblUserDao.deleteUser(id);
		return result;
	}
	@Override
	public List<TBlUser> getList() {
		return tblUserDao.getList();
	}
	@Override
	public List<Map<String, Object>> getUserLists() {
		List<Map<String,Object>> userList=tblUserDao.getUserLists();
		return userList;
	}
	@Override
	public List<Map<String, Object>> getUserList(String keyowrd,Page page) {
		List<Map<String,Object>> userList=tblUserDao.getUserList(keyowrd,page);
		return userList;
	}
	@Override
	public long getUserLines(String keyword) {
		long count=tblUserDao.getUserLines(keyword);
		return count;
	}
	@Override
	public long getUserbyCheckName(String keyword) {
		long count=tblUserDao.getUserbyCheckName(keyword);
		return count;
	}
	
	

	
	
}

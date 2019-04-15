package com.hzitxx.spring.demo.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.TBlUser;
import com.hzitxx.spring.demo.dao.TBlUserDao;
import com.hzitxx.spring.demo.model.Page;
import com.hzitxx.spring.demo.service.TBlUserService;

@Service("tblUserService")
public class TBlUserServiceImpl implements TBlUserService {

	@Autowired
	private TBlUserDao tblUserDao;
	
	@Override
	public int addUser(TBlUser user) {
		int result = tblUserDao.addUser(user);
		return result;
	}

	@Override
	public List<Map<String,Object>> getUserList() {
		return tblUserDao.getUserList();
	}
	
	@Override
	public List<Map<String,Object>> getUserList(String userName,Page page){
		return tblUserDao.getUserList(userName,page);
	}

	@Override
	public Long getUserLines(String userName){
		return tblUserDao.getUserLines(userName);
	}

	@Override
	public int deleteUserById(int uId) {
		return tblUserDao.deleteUserById(uId);
	}

	@Override
	public Map<String,Object> getUser(int uId) {
		return this.tblUserDao.getUser(uId);
	}

	@Override
	public int updateUser(TBlUser user) {
		return this.tblUserDao.updateUser(user);
	}

	@Override
	public TBlUser getUserByLogin(TBlUser user) {
		return this.tblUserDao.getUserByLogin(user);
	}
}

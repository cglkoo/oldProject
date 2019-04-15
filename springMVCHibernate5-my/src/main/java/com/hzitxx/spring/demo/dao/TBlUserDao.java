package com.hzitxx.spring.demo.dao;

import java.util.List;
import java.util.Map;

import com.entity.TBlUser;
import com.hzitxx.spring.demo.model.Page;

public interface TBlUserDao {
	
	public TBlUser getUserByLogin(TBlUser user);
	
	public int addUser(TBlUser user);
	
	public int deleteUserById(int uId);
	
	public List<Map<String,Object>> getUserList();
	
	public List<Map<String,Object>> getUserList(String userName,Page page);
	
	public Long getUserLines(String userName);
	
	public Map<String,Object> getUser(int uId);
	
	public int updateUser(TBlUser user);
}

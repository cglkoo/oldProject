package com.java.service;

import java.util.List;
import java.util.Map;

import com.java.entity.Page;
import com.java.entity.TBlUser;

public interface TBlUserService {
	public int addUser(TBlUser uesr);
	public int updateUser(TBlUser user);
	public int deleteUser(int id);
	public List<TBlUser> getList();
	public List<Map<String,Object>> getUserList(String keyword,Page page);
	public List<Map<String,Object>> getUserLists(); //查询所有，不带条件
	public long getUserLines(String keyword); //关键字查询所有记录数
	public long getUserbyCheckName(String keyword);
	
	
}

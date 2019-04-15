package com.java.dao;

import java.util.List;
import java.util.Map;

import com.java.entity.Page;
import com.java.entity.TBlUser;

public interface TBlUserDao {
	
	public int deleteUser(int id);   //根据ID删除用户
	public List<TBlUser> getList();   //查询所有用户
	public int addUser(TBlUser user);  //添加用户
	public int updateUser(TBlUser user);  //用户修改
	public List<Map<String,Object>> getUserList(String keyword,Page page); //关键字查询所有用户
	public List<Map<String,Object>> getUserLists();   //查询所有用户
	public long getUserLines(String keyword);         //根据关键字查询相应记录数
	public long getUserbyCheckName(String keyword);
	
	
}

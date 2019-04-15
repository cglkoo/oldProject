package com.hzitxx.spring.demo.dao;

import java.util.List;

import com.entity.Hobby;
import com.hzitxx.spring.demo.model.Role;

public interface HobbyDao {
	
	public int addHobby(Hobby hobby);
	
	public List<Hobby> getList();
	public List<Hobby> getRoleListByUId(int uid);

	public int deleteHobbyById(int hid);
}

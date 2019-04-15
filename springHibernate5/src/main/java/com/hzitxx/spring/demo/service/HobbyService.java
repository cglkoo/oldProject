package com.hzitxx.spring.demo.service;

import java.util.List;

import com.entity.Hobby;
import com.hzitxx.spring.demo.model.Role;

public interface HobbyService {
	
	public int addHobby(Hobby hobby);
	public int deleteHobbyById(int hid);
	public List<Hobby> getList();
	public List<Hobby> getRoleListByUId(int uid);
}

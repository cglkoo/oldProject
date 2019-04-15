package com.hzitxx.spring.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Hobby;
import com.hzitxx.spring.demo.dao.HobbyDao;
import com.hzitxx.spring.demo.model.Role;
import com.hzitxx.spring.demo.service.HobbyService;

@Service("hobbyService")
public class HobbyServiceImpl implements HobbyService {

	@Autowired
	private HobbyDao hobbyDao;
	
	@Override
	public int addHobby(Hobby hobby) {
		int result = hobbyDao.addHobby(hobby);
		return result;
	}

	@Override
	public List<Hobby> getList() {
		return hobbyDao.getList();
	}

	@Override
	public List<Hobby> getRoleListByUId(int uid) {
		return hobbyDao.getRoleListByUId(uid);
	}

	@Override
	public int deleteHobbyById(int hid) {
		return this.hobbyDao.deleteHobbyById(hid);
	}

}

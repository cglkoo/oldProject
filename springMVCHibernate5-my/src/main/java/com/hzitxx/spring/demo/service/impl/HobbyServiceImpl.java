package com.hzitxx.spring.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Hobby;
import com.hzitxx.spring.demo.dao.HobbyDao;
import com.hzitxx.spring.demo.model.Page;
import com.hzitxx.spring.demo.service.HobbyService;

@Service("hobbyService")
public class HobbyServiceImpl implements HobbyService {

	@Autowired
	private HobbyDao hobbyDao;
	
	@Override
	public int addHobby(Hobby hobby) {
		return hobbyDao.addHobby(hobby);
	}

	@Override
	public Long getHobbyLines(String keyword) {
		return hobbyDao.getHobbyLines(keyword);
	}

	@Override
	public List<Hobby> getHobbyList(String keyword, Page page,String orderBy) {
		return hobbyDao.getHobbyList(keyword, page,orderBy);
	}

	@Override
	public Hobby getHobbybyCheckName(String hobbyName) {
		return hobbyDao.getHobbybyCheckName(hobbyName);
	}

	@Override
	public List<Hobby> getHobbyListByUId(int uId) {
		return hobbyDao.getHobbyListByUId(uId);
	}

	@Override
	public int deleteHobbyById(int hid) {
		return hobbyDao.deleteHobbyById(hid);
	}

	@Override
	public int updateHobby(Hobby hobby) {
		return hobbyDao.updateHobby(hobby);
	}

	@Override
	public List<Hobby> getHobbyList() {
		return hobbyDao.getHobbyList();
	}

	@Override
	public Hobby getHobbybyId(int id) {
		return hobbyDao.getHobbybyId(id);
	}

}

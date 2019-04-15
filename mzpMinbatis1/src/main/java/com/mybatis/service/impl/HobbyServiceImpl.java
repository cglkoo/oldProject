package com.mybatis.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mybatis.dao.IHobbyDao;
import com.mybatis.entity.Hobby;
import com.mybatis.service.IHobbyService;
@Service("IHobbyService")
public class HobbyServiceImpl implements IHobbyService {
	
	@Autowired
	private IHobbyDao hobbyDao;
	@Override
	public int addHobby(Hobby hobby) {
		return hobbyDao.addHobby(hobby);
	}

	@Override
	public int delHobby(int id) {
		return hobbyDao.delHobby(id);
	}

	@Override
	public int updateHobby(Hobby hobby) {
		return hobbyDao.updateHobby(hobby);
	}

	@Override
	public List<Hobby> getHobbyList(Hobby hobby) {
		return hobbyDao.getHobbyList(hobby);
	}

	@Override
	public long getHobbyLines(String keyword) {
		return hobbyDao.getHobbyLines(keyword);
	}

	@Override
	public Hobby getHobbyById(int id) {
		return hobbyDao.getHobbyById(id);
	}

	@Override
	public List<Hobby> getHobbys() {
		return hobbyDao.getHobbys();
	}

}

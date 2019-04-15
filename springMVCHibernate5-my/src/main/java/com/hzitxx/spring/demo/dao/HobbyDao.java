package com.hzitxx.spring.demo.dao;

import java.util.List;

import com.entity.Hobby;
import com.hzitxx.spring.demo.model.Page;

public interface HobbyDao {
	
	public int addHobby(Hobby hobby);
	public int deleteHobbyById(int id);
	public int updateHobby(Hobby hobby);
	public Long getHobbyLines(String keyword);
	public List<Hobby> getHobbyList(String keyword, Page page,String orderBy);
	public Hobby getHobbybyCheckName(String hobbyName);
	public List<Hobby> getHobbyList();
	public List<Hobby> getHobbyListByUId(int id);
	public Hobby getHobbybyId(int id);
	
}

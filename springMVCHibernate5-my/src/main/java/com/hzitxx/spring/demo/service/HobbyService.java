package com.hzitxx.spring.demo.service;

import java.util.List;

import com.entity.Hobby;
import com.hzitxx.spring.demo.model.Page;

public interface HobbyService {
	
	public int addHobby(Hobby hobby);
	public int deleteHobbyById(int id);
	public int updateHobby(Hobby hobby);
	public Long getHobbyLines(String keyword);
	public List<Hobby> getHobbyList(String keyword, Page page,String orderBy);
	public Hobby getHobbybyCheckName(String hobbyName);
	public Hobby getHobbybyId(int id);
	public List<Hobby> getHobbyListByUId(int id);
	public List<Hobby> getHobbyList();
	
}

package com.mybatis.service;

import java.util.List;

import com.mybatis.entity.Hobby;
import com.mybatis.entity.Role;

public interface IHobbyService {
	public int addHobby(Hobby hobby);
	public int delHobby(int id);
	public int updateHobby(Hobby hobby);
	public List<Hobby> getHobbyList(Hobby hobby);
	public long getHobbyLines(String keyword);
	public Hobby getHobbyById(int id);
	public List<Hobby> getHobbys();
}

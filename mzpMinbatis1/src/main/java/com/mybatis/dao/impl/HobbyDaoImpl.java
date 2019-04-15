package com.mybatis.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mybatis.dao.IHobbyDao;
import com.mybatis.entity.BaseDaoSqlSession;
import com.mybatis.entity.Hobby;

@Repository("IHobbyDao")
public class HobbyDaoImpl extends BaseDaoSqlSession implements IHobbyDao {

	@Override
	public int addHobby(Hobby hobby) {
		return this.getSession().insert("com.HobbyMapper.addHobby",hobby);
	}
	@Override
	public int delHobby(int id) {
		return this.getSession().delete("com.HobbyMapper.delHobby", id);
	}
	@Override
	public int updateHobby(Hobby hobby) {
		return this.getSession().update("com.HobbyMapper.updateHobby", hobby);
	}
	@Override
	public List<Hobby> getHobbyList(Hobby hobby) {
		return this.getSession().selectList("com.HobbyMapper.getAllHobby",hobby);
	}
	@Override
	public long getHobbyLines(String keyword) {
		return this.getSession().selectOne("com.HobbyMapper.getCount",keyword);

	}
	@Override
	public Hobby getHobbyById(int id) {
		return this.getSession().selectOne("com.HobbyMapper.getHobbyById",id);
	}
	@Override
	public List<Hobby> getHobbys() {
		return this.getSession().selectList("com.HobbyMapper.getAllHobby2");
	}
	
	
	

}

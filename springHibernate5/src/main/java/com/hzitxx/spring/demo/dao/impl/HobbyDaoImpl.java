package com.hzitxx.spring.demo.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.entity.Hobby;
import com.hzitxx.spring.demo.dao.HobbyDao;

@Repository("hobbyDao")
public class HobbyDaoImpl extends BaseDaoHibernate5Impl<Hobby, Integer> implements HobbyDao {
 
	@Override
	public int addHobby(Hobby hobby) {
		this.save(hobby);              //享受到了Hibernate5代码的简洁的好处。
		return 1;
	}
	

	@Override
	public List<Hobby> getList() {
		return this.getAllList();
	}


	@Override
	public List<Hobby> getRoleListByUId(int uid) {
		return null;
	}


	@Override
	public int deleteHobbyById(int hid) {
		this.delete(hid);
		return 1;
	}


}

package com.hzitxx.spring.demo.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.entity.Hobby;
import com.hzitxx.spring.demo.dao.HobbyDao;
import com.hzitxx.spring.demo.model.Page;

@Repository("hobbyDao")
public class HobbyDaoImpl extends BaseDaoHibernate5Impl<Hobby, Integer> implements HobbyDao {
 
	@Override
	public int addHobby(Hobby hobby) {
		this.save(hobby);              //享受到了Hibernate5代码的简洁的好处。
		return 1;
	}
	@Override
	public int deleteHobbyById(int hid) {
		this.delete(hid);
		return 1;
	}
	@Override
	public Long getHobbyLines(String keyword) {
		return this.getCount("hName", keyword);
	}
	@Override
	public List<Hobby> getHobbyList(String keyword, Page page,String orderBy ) {
		return this.getList("hName", keyword, page,orderBy);
	}

	@Override
	public Hobby getHobbybyCheckName(String hobbyName) {
		return this.getUniqueObjectByProperty("hName", hobbyName);
	}
	@Override
	public List<Hobby> getHobbyList() {
		return this.getAllList();
	}
	@Override
	public List<Hobby> getHobbyListByUId(int id) {
		return this.getAllList("hId", id);
	}
	@Override
	public Hobby getHobbybyId(int id) {
		return this.getUniqueObjectByProperty("hId", id);
	}
	@Override
	public int updateHobby(Hobby hobby) {
		this.saveOrUpdate(hobby);
		return 1;
	}
	
	


}

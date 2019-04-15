package com.hzitxx.spring.demo.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.entity.TBlUser;
import com.hzitxx.spring.demo.dao.TBlUserDao2;
import com.hzitxx.spring.demo.model.Page;

@Repository("tblUserDao2")
public class TBlUserDaoImpl2 extends BaseDaoHibernate5Impl<TBlUser,Integer> implements TBlUserDao2 {

	@Override
	public int addTBlUser(TBlUser user) {
		this.save(user);
		return 1;
	}

	@Override
	public int deleteTBlUser(int id) {
		this.delete(id);
		return 1;
	}

	@Override
	public Long getTBlUserLines(String keyword) {
		return this.getCount("userName", keyword);
	}

	@Override
	public List<TBlUser> getTBlUserList(String keyword, Page page, String orderBy) {
		return this.getList("userName", keyword, page, orderBy);
	}

	@Override
	public TBlUser getTBlUserbyCheckName(String userName) {
		return this.getUniqueObjectByProperty("userName", userName);
	}

	@Override
	public TBlUser getTBlUserbyId(int id) {
		return this.getUniqueObjectByProperty("uId", id);
	}

	@Override
	public int updateTBlUser(TBlUser user) {
		this.saveOrUpdate(user);
		return 1;
	}
 
	


}

package com.hzitxx.spring.demo.dao.impl;

import org.springframework.stereotype.Repository;

import com.hzitxx.spring.demo.dao.IUserHobbyDao;
import com.hzitxx.spring.demo.model.UserHobby;
@Repository("iUserHobbyDao")
public class UserHobbyDaoImpl extends  BaseDaoHibernate5Impl<UserHobby,Integer> implements IUserHobbyDao {
 
	
	@Override
	public int addUserHobby(UserHobby userHobby) {
		this.saveOrUpdate(userHobby);
		return 1;
	}

	@Override
	public int delUserHobby(UserHobby userHobby) {
		this.delete(userHobby);
		return 1;
	}

}

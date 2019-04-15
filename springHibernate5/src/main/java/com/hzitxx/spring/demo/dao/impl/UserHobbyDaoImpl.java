package com.hzitxx.spring.demo.dao.impl;

import org.springframework.stereotype.Repository;

import com.hzitxx.spring.demo.dao.IUserHobbyDao;
import com.hzitxx.spring.demo.model.UserHobby;
@Repository("iUserHobbyDao")
public class UserHobbyDaoImpl extends BaseDaoSpringJdbcTemplate implements IUserHobbyDao {
 
	
	@Override
	public int addUserHobby(UserHobby userHobby) {
		return this.jdbcTemplate.update("insert into user_hobby (uId,hId) values (?,?)", userHobby.getuId(),userHobby.gethId());
	}

	@Override
	public int delUserHobby(UserHobby userHobby) {
		return this.jdbcTemplate.update("delete from user_hobby where uId=?", userHobby.getuId());
	}

}

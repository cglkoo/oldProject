package com.mybatis.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mybatis.dao.IUserHobbyDao;
import com.mybatis.entity.BaseDaoSqlSession;
import com.mybatis.entity.UserHobby;
@Repository("IUserHobbyDao")
public class UserHobbyDaoImpl extends BaseDaoSqlSession implements IUserHobbyDao {

	@Override
	public int addUserHobby(UserHobby uh) {
		
		return this.getSession().insert("com.UserHobbyMapper.addUserHobby",uh);
	}

	@Override
	public List<UserHobby> getHobbyListByUId(int getuId) {
		return this.getSession().selectList("com.UserHobbyMapper.getUserHobbyListByUId", getuId);
	}

	@Override
	public int delUserHobby(UserHobby uh) {
		return this.getSession().delete("com.UserHobbyMapper.delUserHobby",uh);
	}

}

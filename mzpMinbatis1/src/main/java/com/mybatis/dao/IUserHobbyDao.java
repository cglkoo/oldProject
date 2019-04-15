package com.mybatis.dao;

import java.util.List;

import com.mybatis.entity.UserHobby;

public interface IUserHobbyDao {
	public int addUserHobby(UserHobby uh);

	public List<UserHobby> getHobbyListByUId(int getuId);

	public int delUserHobby(UserHobby uh);

}

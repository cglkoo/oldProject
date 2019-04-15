package com.mybatis.dao;

import java.util.List;

import com.mybatis.entity.UserRole;

public interface IUserRoleDao {
	public int addUserRole(UserRole ur);

	public List<UserRole> getRoleListByUId(int getuId);

	public int delUserRole(UserRole ur);

}

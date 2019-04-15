package com.mybatis.service;

import java.util.List;

import com.mybatis.entity.UserRole;

public interface IUserRoleService {

	public int addUserRole(UserRole ur);

	public List<UserRole> getRoleListByUId(int getuId);

	public int delUserRole(UserRole ur);

}

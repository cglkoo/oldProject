package com.mybatis.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mybatis.dao.IUserRoleDao;
import com.mybatis.entity.UserRole;
import com.mybatis.service.IUserRoleService;
@Service("IUserRoleService")
public class UserRoleServiceImpl implements IUserRoleService {
	@Autowired
	private IUserRoleDao userRoleDao;

	@Override
	public int addUserRole(UserRole ur) {
		return userRoleDao.addUserRole(ur);
	}

	@Override
	public List<UserRole> getRoleListByUId(int getuId) {
		
		return userRoleDao.getRoleListByUId(getuId);
	}

	@Override
	public int delUserRole(UserRole ur) {
		return userRoleDao.delUserRole(ur);

	}
}

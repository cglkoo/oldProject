package com.hzitxx.spring.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hzitxx.spring.demo.dao.IUserRoleDao;
import com.hzitxx.spring.demo.model.UserRole;
import com.hzitxx.spring.demo.service.IUserRoleService;
@Service("iUserRoleService")
public class UserRoleServiceImpl implements IUserRoleService {
	@Autowired
	private IUserRoleDao iUserRoleDao;
	
	@Override
	public int addUserRole(UserRole userRole) {
		return this.iUserRoleDao.addUserRole(userRole);
	}

	@Override
	public int delUserRole(UserRole userRole) {
		return this.iUserRoleDao.delUserRole(userRole);
	}

}

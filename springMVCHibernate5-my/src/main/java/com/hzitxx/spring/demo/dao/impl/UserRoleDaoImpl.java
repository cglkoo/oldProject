package com.hzitxx.spring.demo.dao.impl;

import org.springframework.stereotype.Repository;

import com.hzitxx.spring.demo.dao.IUserRoleDao;
import com.hzitxx.spring.demo.model.UserRole;
@Repository("iUserRoleDao")
public class UserRoleDaoImpl extends BaseDaoHibernate5Impl<UserRole,Integer> implements IUserRoleDao {
 
	
	@Override
	public int addUserRole(UserRole userRole) {
		this.saveOrUpdate(userRole);
		return 1;
	}

	@Override
	public int delUserRole(UserRole userRole) {
		this.delete(userRole);
		return  1;
	}

}

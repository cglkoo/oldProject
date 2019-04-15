package com.hzitxx.spring.demo.dao.impl;

import org.springframework.stereotype.Repository;

import com.hzitxx.spring.demo.dao.IUserRoleDao;
import com.hzitxx.spring.demo.model.UserRole;
@Repository("iUserRoleDao")
public class UserRoleDaoImpl extends BaseDaoSpringJdbcTemplate implements IUserRoleDao {
 
	
	@Override
	public int addUserRole(UserRole userRole) {
		return this.jdbcTemplate.update("insert into user_role (uId,rId) values (?,?)", userRole.getuId(),userRole.getrId());
	}

	@Override
	public int delUserRole(UserRole userRole) {
		return this.jdbcTemplate.update("delete from user_role where uId=?", userRole.getuId());
	}

}

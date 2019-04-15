package com.mybatis.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mybatis.dao.IUserRoleDao;
import com.mybatis.entity.BaseDaoSqlSession;
import com.mybatis.entity.UserRole;
@Repository("IUserRoleDao")
public class UserRoleDaoImpl extends BaseDaoSqlSession implements IUserRoleDao {

	@Override
	public int addUserRole(UserRole ur) {
		return this.getSession().insert("com.UserRoleMapper.addUserRole",ur);
	}

	@Override
	public List<UserRole> getRoleListByUId(int getuId) {
		return this.getSession().selectList("com.UserRoleMapper.getUserRoleListByUId", getuId);
	}

	@Override
	public int delUserRole(UserRole ur) {
		return this.getSession().delete("com.UserRoleMapper.delUserRole",ur);
	}

}

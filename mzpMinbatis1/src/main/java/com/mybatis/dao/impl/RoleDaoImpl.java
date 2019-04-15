package com.mybatis.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mybatis.dao.IRoleDao;
import com.mybatis.entity.BaseDaoSqlSession;
import com.mybatis.entity.Role;

@Repository("IRoleDao")
public class RoleDaoImpl extends BaseDaoSqlSession implements IRoleDao {

	@Override
	public int addRole(Role role) {
		return this.getSession().insert("com.RoleMapper.addRole",role);
	}
	@Override
	public int delRole(int id) {
		return this.getSession().delete("com.RoleMapper.delRole", id);
	}
	@Override
	public int updateRole(Role role) {
		return this.getSession().update("com.RoleMapper.updateRole", role);
	}
	@Override
	public List<Role> getRoleList(Role role) {
		return this.getSession().selectList("com.RoleMapper.getAllRole",role);
	}
	@Override
	public long getRoleLines(String keyword) {
		return this.getSession().selectOne("com.RoleMapper.getCount",keyword);

	}
	@Override
	public Role getRoleById(int id) {
		return this.getSession().selectOne("com.RoleMapper.getRoleById",id);
	}
	@Override
	public List<Role> getRoles() {
		return this.getSession().selectList("com.RoleMapper.getAllRole2");
	}
	
	

}

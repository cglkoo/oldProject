package com.mybatis.dao;

import java.util.List;

import com.mybatis.entity.Role;

public interface IRoleDao {
	public int addRole(Role Role);
	public int delRole(int id);
	public int updateRole(Role Role);
	public List<Role> getRoleList(Role Role);
	public long getRoleLines(String keyword);
	public Role getRoleById(int id);
	public List<Role> getRoles();
}

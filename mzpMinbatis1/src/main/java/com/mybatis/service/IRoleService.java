package com.mybatis.service;

import java.util.List;

import com.mybatis.entity.Role;

public interface IRoleService {
	public int addRole(Role role);
	public int delRole(int id);
	public int updateRole(Role role);
	public List<Role> getRoleList(Role role);
	public long getRoleLines(String keyword);
	public Role getRoleById(int id);
	public List<Role> getRoles();
}

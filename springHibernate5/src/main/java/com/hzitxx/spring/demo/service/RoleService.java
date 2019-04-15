package com.hzitxx.spring.demo.service;

import java.util.List;



import com.entity.Role;

public interface RoleService {
	
	public int addRole(Role role);
	public int deleteRole(int rid);
 
	public int deleteRoleByRName(String rName);
	
	public List<Role> getList();
	public List<Role> getRoleListByUId(int uid);
}

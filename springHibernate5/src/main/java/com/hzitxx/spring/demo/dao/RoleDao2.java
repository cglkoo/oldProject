package com.hzitxx.spring.demo.dao;

import java.util.List;



import com.entity.Role;

 

public interface RoleDao2 {
	
	public int addRole(Role role);
	
	public List<Role> getList();

	public int deleteRole(int rid);
 
	public int deleteRoleByRName(String rName);
	
	public List<Role> getRoleListByUId(int uid);
}

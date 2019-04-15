package com.hzitxx.spring.demo.dao;

import java.util.List;

import com.entity.Role;
import com.entity.Role;
import com.hzitxx.spring.demo.model.Page;

public interface RoleDao2 {
	
	public int addRole(Role role);
	public int deleteRole(int rid);
	public Long getRoleLines(String keyword);
	public List<Role> getRoleList(String keyword,Page page,String orderBy);
	public Role getRolebyCheckName(String roleName);
	public Role getRolebyId(int rid);
	public int updateRole(Role role);
	public List<Role> getRoleList();
	public List<Role> getRoleListByUId(int id);
}

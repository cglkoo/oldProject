package com.hzitxx.spring.demo.service;

import java.util.List;

import com.entity.Role;
import com.hzitxx.spring.demo.model.Page;

public interface RoleService {
	
	public int addRole(Role role);
	public int deleteRole(int rid);
	public int updateRole(Role role);
	public Long getRoleLines(String keyword);
	public List<Role> getRoleList(String keyword,Page page,String orderBy);
	public Role getRolebyCheckName(String roleName);
	public Role getRolebyId(int rId);
	public List<Role> getRoleListByUId(int id);
	public List<Role> getRoleList();
}

package com.java.service;

import java.util.List;
import java.util.Map;

import com.java.entity.Page;
import com.java.entity.Role;

public interface RoleService {
	public int addRole(Role role);
	public int updateRole(Role user);
	public int deleteRole(int id);
	public List<Role> getList();
	public List<Map<String,Object>> getRoleList(String keyword,Page page);
	public List<Map<String,Object>> getRoleLists();  //查询所有，不带条件
	public long getRoleLines(String keyword);    //关键字查询所有记录数
	public long getRolebyCheckName(String keyword);
	
	
}

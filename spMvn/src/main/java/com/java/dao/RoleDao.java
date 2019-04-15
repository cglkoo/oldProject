package com.java.dao;

import java.util.List;
import java.util.Map;

import com.java.entity.Page;
import com.java.entity.Role;


public interface RoleDao {
	
	public int deleteRole(int id);  //根据ID删除角色
	public List<Role> getList();    //查询所有角色
	public int addRole(Role role);  //添加角色
	public int updateRole(Role role);  //角色修改
	public List<Map<String,Object>> getRoleList(String keyword,Page page); //关键字查询所有角色
	public List<Map<String,Object>> getRoleLists();   //查询所有角色
	public long getRoleLines(String keyword);  //根据关键字查询相应记录数
	public long getRolebyCheckName(String keyword);
}

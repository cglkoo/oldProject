package com.java.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.RoleDao;
import com.java.entity.Page;
import com.java.entity.Role;
import com.java.service.RoleService;

@Service("roleService")
public class RoleServiceImpl implements RoleService{
	@Autowired
	private RoleDao roleDao;
	
	@Override
	public int addRole(Role role) {
		int result=roleDao.addRole(role);
		return result;
	}
	@Override
	public int updateRole(Role role) {
		int result=roleDao.updateRole(role);
		return result;
	}

	@Override
	public int deleteRole(int id) {
		int result=roleDao.deleteRole(id);
		return result;
	}
	@Override
	public List<Role> getList() {
		return roleDao.getList();
	}
	@Override
	public List<Map<String, Object>> getRoleLists() {
		List<Map<String,Object>> roleList=roleDao.getRoleLists();
		return roleList;
	}
	@Override
	public List<Map<String, Object>> getRoleList(String keyowrd,Page page) {
		List<Map<String,Object>> roleList=roleDao.getRoleList(keyowrd,page);
		return roleList;
	}
	@Override
	public long getRoleLines(String keyword) {
		long count=roleDao.getRoleLines(keyword);
		return count;
	}
	@Override
	public long getRolebyCheckName(String keyword) {
		long count=roleDao.getRolebyCheckName(keyword);
		return count;
	}
	
	

	
	
}

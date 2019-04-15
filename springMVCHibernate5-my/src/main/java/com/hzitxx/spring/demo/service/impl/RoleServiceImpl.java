package com.hzitxx.spring.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Role;
import com.hzitxx.spring.demo.dao.RoleDao2;
import com.hzitxx.spring.demo.model.Page;
import com.hzitxx.spring.demo.service.RoleService;

@Service("roleService")
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleDao2 roleDao2;
	
	@Override
	public int addRole(Role role) {
		int result = roleDao2.addRole(role);
		return result;
	}
	
	@Override
	public int deleteRole(int rid) {
		return roleDao2.deleteRole(rid);
	}

	@Override
	public Long getRoleLines(String keyword) {
		return roleDao2.getRoleLines(keyword);
	}

	@Override
	public List<Role> getRoleList(String keyword, Page page,String orderBy) {
		return roleDao2.getRoleList(keyword, page,orderBy);
	}
	@Override
	public Role getRolebyCheckName(String roleName) {
		return roleDao2.getRolebyCheckName(roleName);
	}

	@Override
	public Role getRolebyId(int rId) {
		
		return roleDao2.getRolebyId(rId);
	}

	@Override
	public int updateRole(Role role) {
		return roleDao2.updateRole(role);
	}

	@Override
	public List<Role> getRoleListByUId(int id) {
		
		return roleDao2.getRoleListByUId(id);
	}

	@Override
	public List<Role> getRoleList() {
		
		return roleDao2.getRoleList();
	}

	
}

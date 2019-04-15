package com.mybatis.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mybatis.dao.IRoleDao;
import com.mybatis.entity.Role;
import com.mybatis.service.IRoleService;
@Service("IRoleService")
public class RoleServiceImpl implements IRoleService {
	
	@Autowired
	private IRoleDao roleDao;
	@Override
	public int addRole(Role role) {
		return roleDao.addRole(role);
	}

	@Override
	public int delRole(int id) {
		return roleDao.delRole(id);
	}

	@Override
	public int updateRole(Role role) {
		return roleDao.updateRole(role);
	}

	@Override
	public List<Role> getRoleList(Role role) {
		return roleDao.getRoleList(role);
	}

	@Override
	public long getRoleLines(String keyword) {
		return roleDao.getRoleLines(keyword);
	}

	@Override
	public Role getRoleById(int id) {
		return roleDao.getRoleById(id);
	}

	@Override
	public List<Role> getRoles() {
		return roleDao.getRoles();
	}

}

package com.hzitxx.spring.demo.service.impl;

import java.util.List;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Role;
import com.hzitxx.spring.demo.dao.RoleDao;
 
import com.hzitxx.spring.demo.dao.RoleDao2;
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
	public List<Role> getList() {
		return roleDao2.getList();
	}

	@Override
	public int deleteRoleByRName(String rName) {
		return roleDao2.deleteRoleByRName(rName);
	}
	
	@Override
	public int deleteRole(int rid) {
		return roleDao2.deleteRole(rid);
	}

	@Override
	public List<Role> getRoleListByUId(int uid) {
		return roleDao2.getRoleListByUId(uid);
	}

}

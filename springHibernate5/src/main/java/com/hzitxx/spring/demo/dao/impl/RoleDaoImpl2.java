package com.hzitxx.spring.demo.dao.impl;

import java.util.List;



import org.springframework.stereotype.Repository;

import com.entity.Role;
import com.hzitxx.spring.demo.dao.RoleDao;
import com.hzitxx.spring.demo.dao.RoleDao2;

@Repository("roleDao2")
public class RoleDaoImpl2 extends BaseDaoHibernate5Impl<Role,Integer> implements RoleDao2 {
	
	@Override
	public int addRole(Role role) {
		this.save(role);
		return 1;
	}
	

	@Override
	public List<Role> getList() {
		 
		return this.getAllList();
	}


	@Override
	public int deleteRole(int rid) {
		this.delete(rid);
		return 1;
	}


	@Override
	public List<Role> getRoleListByUId(int uid) {
		return null;
	}


	@Override
	public int deleteRoleByRName(String rName) {
		Role role = this.getUniqueObjectByProperty("rName",rName);
		this.delete(role.getId());
		return 1;
	}


}
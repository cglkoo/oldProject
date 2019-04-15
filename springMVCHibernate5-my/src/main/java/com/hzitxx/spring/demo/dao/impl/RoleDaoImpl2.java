package com.hzitxx.spring.demo.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.entity.Role;
import com.hzitxx.spring.demo.dao.RoleDao2;
import com.hzitxx.spring.demo.model.Page;

@Repository("roleDao2")
public class RoleDaoImpl2 extends BaseDaoHibernate5Impl<Role,Integer> implements RoleDao2 {
	
	@Override
	public int addRole(Role role) {
		this.save(role);
		return 1;
	}
	@Override
	public int deleteRole(int rid) {
		this.delete(rid);
		return 1;
	}
	@Override
	public Long getRoleLines(String keyword) {
		return this.getCount("rName", keyword);
	}
	@Override
	public List<Role> getRoleList(String keyword,Page page,String orderBy) {
		return this.getList("rName", keyword, page,orderBy);
	}
	@Override
	public Role getRolebyCheckName(String roleName) {
		return this.getUniqueObjectByProperty("rName", roleName);
	}
	@Override
	public Role getRolebyId(int rId) {
		return this.getUniqueObjectByProperty("rId", rId);
	}
	@Override
	public int updateRole(Role role) {
		this.saveOrUpdate(role);
		return 1;
	}
	@Override
	public List<Role> getRoleList() {
		
		return this.getAllList();
	}
	@Override
	public List<Role> getRoleListByUId(int id) {
		return this.getAllList("rId", id);
	}


	


}
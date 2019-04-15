package com.hzitxx.spring.demo.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.entity.Role;
import com.hzitxx.spring.demo.dao.RoleDao;
 

@Repository("roleDao")
public class RoleDaoImpl extends BaseDaoSpringJdbcTemplate implements RoleDao {
	
	@Override
	public int addRole(Role role) {
		String sql = "insert into t_roles (rName) values (?)";
		int result = jdbcTemplate.update(sql, role.getrName() );
		return result;
	}
	

	@Override
	public List<Role> getList() {
		 
		return null;
	}


	@Override
	public int deleteRole(int rid) {
		return jdbcTemplate.update("delete from t_roles where rId=?",rid);
	}


	@Override
	public List<Role> getRoleListByUId(int uid) {
		 
		return null;
	}


}
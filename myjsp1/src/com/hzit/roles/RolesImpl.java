package com.hzit.roles;

import java.util.List;

import com.java.dao.Dao;
/**
 * 
 * @author 应传富
 *日期:2017年5月4日
 *功能:Role接口的实现类
 */
public class RolesImpl  implements IRoles{

	@Override
	public int addOrUpdateOrDelete(String sql, Object... args) {
		
		return Dao.addOrUpdateorDelete(sql, args);
	}

	@Override
	public List<Roles> getRolesByProperty(String sql, Object... args) {
		
		return Dao.getObjectsForList(Roles.class, sql, args);
	}

	@Override
	public Object getObjectByProperty(String sql, Object... args) {
		
		return Dao.getObjectByProperty(sql, args);
	}

}

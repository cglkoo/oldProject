/**
 * 
 */
package com.kaokaoba.role;

import java.util.List;

import com.java.dao.Dao;

/**
 * @author 闵老师
 * 日期：2017年4月28日 : 上午10:16:08
 * 功能：
 */
public class RoleServiceImpl implements IRoleService {

	@Override
	public int addOrUpdateOrDelete(String sql, Object... args) {
		return Dao.addOrUpdateorDelete(sql, args);
	}

	@Override
	public List<Role> getRoleByProperty(String sql, Object... args) {
		return Dao.getObjectsForList(Role.class, sql, args);
	}

	@Override
	public Object getObjectByProperty(String sql, Object... args) {
		return Dao.getObjectByProperty(sql, args);
	}

}

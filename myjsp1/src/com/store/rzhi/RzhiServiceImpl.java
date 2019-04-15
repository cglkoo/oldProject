package com.store.rzhi;

import java.util.List;

import com.java.dao.Dao;



public class RzhiServiceImpl  implements IRzhiService{

	@Override
	public int addOrUpdateOrDelete(String sql, Object... args) {
		return Dao.addOrUpdateorDelete(sql, args);
	}

	@Override
	public Object getObjectByProperty(String sql, Object... args) {
		return Dao.getObjectByProperty(sql, args);
	}

	@Override
	public List<Rzhi> getRzhisByProperty(String sql, Object... args) {
		
		return Dao.getObjectsForList(Rzhi.class, sql, args);
	}

}

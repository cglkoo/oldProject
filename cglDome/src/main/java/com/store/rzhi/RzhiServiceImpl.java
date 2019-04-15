package com.store.rzhi;

import java.util.List;

import com.java.dao.Dao;

public class RzhiServiceImpl  implements IRzhiService{

	public int addOrUpdateOrDelete(String sql, Object... args) {
		// TODO Auto-generated method stub
		return Dao.addOrUpdateorDelete(sql, args);
	}

	public List<Rzhi> getRzhisByProperty(String sql, Object... args) {
		// TODO Auto-generated method stub
		return Dao.getObjectsForList(Rzhi.class, sql, args);
	}

	public Object getObjectByProperty(String sql, Object... args) {
		// TODO Auto-generated method stub
		return Dao.getObjectByProperty(sql, args);
	}

	
}

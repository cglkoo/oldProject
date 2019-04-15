package com.kaokaoba.paper;

import java.util.List;

import com.java.dao.Dao;

public class PaperServiceImpl implements IPaperService {

	@Override
	public int addOrUpdateOrDelete(String sql, Object... args) {
		return Dao.addOrUpdateorDelete(sql, args);
	}

	@Override
	public List<Paper> getPapersByProperty(String sql, Object... args) {
		return Dao.getObjectsForList(Paper.class, sql, args);
	}

	@Override
	public Object getObjectByProperty(String sql, Object... args) {
		return Dao.getObjectByProperty(sql, args);
	}

}

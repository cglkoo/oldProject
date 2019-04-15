package com.store.sell;

import java.util.List;

import com.java.dao.Dao;

public class SellServiceImpl implements ISellService {

	@Override
	public int addOrUpdateOrDelete(String sql, Object... args) {
		return Dao.addOrUpdateorDelete(sql, args);
	}

	@Override
	public List<Sell> getSellsByProperty(String sql, Object... args) {
		return Dao.getObjectsForList(Sell.class, sql, args);
	}

	@Override
	public Object getObjectByProperty(String sql, Object... args) {
		return Dao.getObjectByProperty(sql, args);
	}

}

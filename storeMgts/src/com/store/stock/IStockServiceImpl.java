package com.store.stock;

import java.util.List;

import com.java.dao.Dao;

public class IStockServiceImpl implements IStockService{

	public IStockServiceImpl() {
		
	}
	@Override
	public int addOrUpdateOrDelete(String sql, Object... args) {
		// TODO Auto-generated method stub
		return Dao.addOrUpdateorDelete(sql, args);
	}

	@Override
	public List<Stock> getStocksByProperty(String sql, Object... args) {
		// TODO Auto-generated method stub
		return Dao.getObjectsForList(Stock.class, sql, args);
	}

	@Override
	public Object getObjectByProperty(String sql, Object... args) {
		// TODO Auto-generated method stub
		return Dao.getObjectByProperty(sql, args);
	}

}

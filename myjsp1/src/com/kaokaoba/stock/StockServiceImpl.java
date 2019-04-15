package com.kaokaoba.stock;

import java.util.List;

import com.java.dao.Dao;

public class StockServiceImpl implements IStockService {

	@Override
	public int addOrUpdateOrDelete(String sql, Object... args) {
		return Dao.addOrUpdateorDelete(sql, args);
	}

	@Override
	public List<Stock> getStocksByProperty(String sql, Object... args) {
		return Dao.getObjectsForList(Stock.class, sql, args);
	}

	@Override
	public Object getObjectByProperty(String sql, Object... args) {
		return Dao.getObjectByProperty(sql, args);
	}

}

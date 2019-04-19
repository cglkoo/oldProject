package com.kaokaoba.sell;

import java.util.List;

import com.java.dao.Dao;

public class SellServiceImpl implements ISellService {

	public int addOrUpdateOrDelete(String sql, Object... args) {
		// TODO Auto-generated method stub
		return Dao.addOrUpdateorDelete(sql, args);
	}

	public List<Sell> getSellsByProperty(String sql, Object... args) {
		// TODO Auto-generated method stub
		return Dao.getObjectsForList(Sell.class, sql, args);
	}

	public Object getObjectByProperty(String sql, Object... args) {
		// TODO Auto-generated method stub
		return Dao.getObjectByProperty(sql, args);
	}

	

}

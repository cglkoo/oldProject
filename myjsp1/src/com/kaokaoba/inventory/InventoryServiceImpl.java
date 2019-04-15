package com.kaokaoba.inventory;

import java.util.List;

import com.java.dao.Dao;

public class InventoryServiceImpl implements IInventoryService {

	@Override
	public int addOrUpdateOrDelete(String sql, Object... args) {
		return Dao.addOrUpdateorDelete(sql, args);
	}

	@Override
	public List<Inventory> getInventorysByProperty(String sql, Object... args) {
		return Dao.getObjectsForList(Inventory.class, sql, args);
	}

	@Override
	public Object getObjectByProperty(String sql, Object... args) {
		return Dao.getObjectByProperty(sql, args);
	}

}

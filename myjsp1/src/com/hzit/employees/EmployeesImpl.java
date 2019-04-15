package com.hzit.employees;

import java.util.List;

import com.java.dao.Dao;


public class EmployeesImpl implements IEmployees {

	@Override
	public int addOrUpdateOrDelete(String sql, Object... args) {
		
		return Dao.addOrUpdateorDelete(sql, args);
	}

	@Override
	public List<Employees> getUserByProperty(String sql, Object... args) {
		
		return Dao.getObjectsForList(Employees.class, sql, args);
	}

	@Override
	public Object getObjectByProperty(String sql, Object... args) {
		
		return Dao.getObjectByProperty(sql, args);
	}

}

package com.hzit.employees;

import java.util.List;

import com.java.dao.Dao;


public class EmployeesImpl implements IEmployees {

	public int addOrUpdateOrDelete(String sql, Object... args) {
		// TODO Auto-generated method stub
		return Dao.addOrUpdateorDelete(sql, args);
	}

	public List<Employees> getUserByProperty(String sql, Object... args) {
		// TODO Auto-generated method stub
		return Dao.getObjectsForList(Employees.class, sql, args);
	}

	public Object getObjectByProperty(String sql, Object... args) {
		// TODO Auto-generated method stub
		return Dao.getObjectByProperty(sql, args);
	}


	
}

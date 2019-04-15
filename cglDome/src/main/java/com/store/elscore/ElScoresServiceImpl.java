package com.store.elscore;

import java.util.List;

import com.java.dao.Dao;

public class ElScoresServiceImpl implements IElScoresService{

	public List<ElScores> getElScoresByProperty(String sql, Object... args) {
		// TODO Auto-generated method stub
		return Dao.getObjectsForList(ElScores.class, sql, args);
	}

	public Object getObjectByProperty(String sql, Object... args) {
		// TODO Auto-generated method stub
		return Dao.getObjectByProperty(sql, args);
	}

	public int addOrUpdateOrDelete(String sql, Object... args) {
		// TODO Auto-generated method stub
		return Dao.addOrUpdateorDelete(sql, args);
	}

	

	
	
	

}

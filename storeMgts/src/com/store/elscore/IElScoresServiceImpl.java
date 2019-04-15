package com.store.elscore;

import java.util.List;

import com.java.dao.Dao;

public class IElScoresServiceImpl implements IElScoresService{

	@Override
	public List<ElScores> getElScoresByProperty(String sql, Object... args) {
		
		return Dao.getObjectsForList(ElScores.class, sql, args);
	}

	@Override
	public Object getObjectByProperty(String sql, Object... args) {
		
		return Dao.getObjectByProperty(sql, args);
	}


}

package com.store.score;

import java.util.List;

import com.java.dao.Dao;

public class IScoresServiceImpl implements IScoresService{

	@Override
	public List<Scores> getScoresByProperty(String sql, Object... args) {
		
		return Dao.getObjectsForList(Scores.class, sql, args);
	}

	@Override
	public Object getObjectByProperty(String sql, Object... args) {
		
		return Dao.getObjectByProperty(sql, args);
	}


}

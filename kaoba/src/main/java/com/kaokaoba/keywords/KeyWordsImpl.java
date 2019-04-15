package com.kaokaoba.keywords;

import java.util.List;

import com.java.dao.Dao;

public class KeyWordsImpl implements IKeywordsService {

	@Override
	public int addOrUpdateOrDelete(String sql, Object... args) {
		return Dao.addOrUpdateorDelete(sql, args);
	}

	@Override
	public List<KeyWords> getKeyWordsByProperty(String sql, Object... args) {
		return Dao.getObjectsForList(KeyWords.class, sql, args);
	}

	@Override
	public Object getObjectByProperty(String sql, Object... args) {
		return Dao.getObjectByProperty(sql, args);
	}

}

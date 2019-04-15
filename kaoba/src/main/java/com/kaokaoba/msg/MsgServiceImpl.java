package com.kaokaoba.msg;

import java.util.List;

import com.java.dao.Dao;

public class MsgServiceImpl implements IMsgService {

	@Override
	public int addOrUpdateOrDelete(String sql, Object... args) {
		return Dao.addOrUpdateorDelete(sql, args);
	}

	@Override
	public List<Msg> getMsgsByProperty(String sql, Object... args) {
		return Dao.getObjectsForList(Msg.class, sql, args);
	}

	@Override
	public Object getObjectByProperty(String sql, Object... args) {
		return Dao.getObjectByProperty(sql, args);
	}

}

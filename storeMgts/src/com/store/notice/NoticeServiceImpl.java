package com.store.notice;

import java.util.List;

import com.java.dao.Dao;

public class NoticeServiceImpl implements INoticeService {

	@Override
	public int addOrUpdateOrDelete(String sql, Object... args) {
		return Dao.addOrUpdateorDelete(sql, args);
	}

	@Override
	public List<Notice> getNoticesByProperty(String sql, Object... args) {
		return Dao.getObjectsForList(Notice.class, sql, args);
	}

	@Override
	public Object getObjectByProperty(String sql, Object... args) {
		return Dao.getObjectByProperty(sql, args);
	}

}

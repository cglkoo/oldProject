package com.store.notice;

import java.util.List;

import com.java.dao.Dao;

public class NoticeServiceImpl implements INoticeService {

	public int addOrUpdateOrDelete(String sql, Object... args) {
		// TODO Auto-generated method stub
		return Dao.addOrUpdateorDelete(sql, args);
	}

	public List<Notice> getNoticesByProperty(String sql, Object... args) {
		// TODO Auto-generated method stub
		return Dao.getObjectsForList(Notice.class, sql, args);
	}

	public Object getObjectByProperty(String sql, Object... args) {
		// TODO Auto-generated method stub
		return Dao.getObjectByProperty(sql, args);
	}



}

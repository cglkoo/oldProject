/**
 * 
 */
package com.kaokaoba.log;

import java.util.List;

import com.java.dao.Dao;

/**
 * @author 闵老师
 * 日期：2017年4月28日 : 上午10:16:08
 * 功能：
 */
public class LogServiceImpl implements ILogService {

	@Override
	public int addOrUpdateOrDelete(String sql, Object... args) {
		return Dao.addOrUpdateorDelete(sql, args);
	}

	@Override
	public List<Log> getLogByProperty(String sql, Object... args) {
		return Dao.getObjectsForList(Log.class, sql, args);
	}

	@Override
	public Object getObjectByProperty(String sql, Object... args) {
		return Dao.getObjectByProperty(sql, args);
	}

}

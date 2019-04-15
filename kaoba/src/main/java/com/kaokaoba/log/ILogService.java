/**
 * 
 */
package com.kaokaoba.log;

import java.util.List;

/**
 * @author 闵老师
 * 日期：2017年4月28日 : 上午10:13:46
 * 功能：Role角色管理的接口
 */
public interface ILogService {
	//增加，删除，修改；
	public int addOrUpdateOrDelete(String sql, Object...args);
	//根据属性查询；
	public List<Log> getLogByProperty(String sql, Object...args);
	//返回一个字段的通用方法；
	public Object getObjectByProperty(String sql,Object ... args);
}

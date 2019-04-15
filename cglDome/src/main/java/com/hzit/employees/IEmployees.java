package com.hzit.employees;

import java.util.List;
/**
 * 
 * @author 应传富
 *日期:2017年5月5日
 *功能:用户接口
 */

public interface IEmployees {
	//增加 删除 修改
	public int addOrUpdateOrDelete(String sql,Object...args);
	//根据属性查询
	public List<Employees>getUserByProperty(String sql,Object...args);
	//返回一个字段的通用方法
	public Object getObjectByProperty(String sql,Object...args);
}

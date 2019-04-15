package com.store.rzhi;

import java.util.List;

/**
 * 
 * @author 应传富
 *日期:2017年5月4日
 *功能:Role角色管理的接口
 */
public interface IRzhiService {
	//增加 删除 修改
	public int addOrUpdateOrDelete(String sql,Object...args);
	//根据属性查询
	public List<Rzhi> getRzhisByProperty(String sql,Object...args);
	//返回一个字段的通用方法
	public Object getObjectByProperty(String sql,Object...args);
}

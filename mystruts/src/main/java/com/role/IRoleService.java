
package com.role.action;

import java.util.List;

public interface IRoleService {
	//增加，删除，修改；
	public int addOrUpdateOrDelete(String sql, Object...args);
	//根据属性查询；
	public List<Role> getRoleByProperty(String sql, Object...args);
	//返回一个字段的通用方法；
	public Object getObjectByProperty(String sql,Object ... args);
}

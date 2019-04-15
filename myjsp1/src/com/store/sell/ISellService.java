package com.store.sell;

import java.util.List;

public interface ISellService {
	
	//增加，删除，修改；
	public int addOrUpdateOrDelete(String sql, Object...args);
	//根据属性查询；
	public List<Sell> getSellsByProperty(String sql, Object...args);
	//返回一个字段的通用方法；
	public Object getObjectByProperty(String sql,Object ... args);

}

package com.store.elscore;

import java.util.List;


public interface IElScoresService {
		//根据属性查询；
		public List<ElScores> getElScoresByProperty(String sql, Object...args);
		//返回一个字段的通用方法；
		public Object getObjectByProperty(String sql,Object ... args);
}

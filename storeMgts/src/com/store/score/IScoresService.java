package com.store.score;

import java.util.List;


public interface IScoresService {
		//根据属性查询；
		public List<Scores> getScoresByProperty(String sql, Object...args);
		//返回一个字段的通用方法；
		public Object getObjectByProperty(String sql,Object ... args);
}

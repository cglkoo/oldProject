package com.hzitxx.spring.demo.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class BaseDaoSpringJdbcTemplate {
	
	@Autowired
	protected JdbcTemplate jdbcTemplate;

}

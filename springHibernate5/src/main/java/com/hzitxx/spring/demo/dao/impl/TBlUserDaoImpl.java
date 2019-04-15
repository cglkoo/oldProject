package com.hzitxx.spring.demo.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hzitxx.spring.demo.dao.TBlUserDao;
import com.hzitxx.spring.demo.model.Page;
import com.hzitxx.spring.demo.model.TBlUser;

@Repository("tblUserDao")
public class TBlUserDaoImpl extends BaseDaoSpringJdbcTemplate implements TBlUserDao {
 
	@Override
	public int addUser(TBlUser user) {
		String sql = "insert into tbl_user(userName, userPwd, userIcon) values (?,?,?)";
		int result = jdbcTemplate.update(sql, user.getUserName(), user.getUserPwd(), user.getUserIcon());
		return result;
	}
	@Override
	public List<Map<String,Object>> getUserList() {
		String sql = "select * from tbl_user";
		List<Map<String,Object>>  userList = this.jdbcTemplate.queryForList(sql);		
		return userList;
	}
	@Override
	public List<Map<String,Object>> getUserList(String userName,Page page) {
		String sql = "select * from tbl_user where userName like ? order by uId desc limit ?,?";
		List<Map<String,Object>>  userList = this.jdbcTemplate.queryForList(sql, "%"+userName+"%",page.getPosition(),page.getPageSize());	
		return userList;
	}
	@Override
	public Long getUserLines(String userName) {
		String sql = "select count(1) c from tbl_user  where userName like ? ";
		Map<String,Object> map = this.jdbcTemplate.queryForMap(sql, "%"+userName+"%");
		Long count =(Long) map.get("c");
		return count;
	}
	@Override
	public int deleteUserById(int uId) {
		return this.jdbcTemplate.update("delete from tbl_user where  uId=?",uId);
	}
	@Override
	public Map<String, Object> getUser(int uId) {
		return this.jdbcTemplate.queryForMap("select uId,userName,userPwd,userIcon from tbl_user where uId=?",uId);
	}
	@Override
	public int updateUser(TBlUser user) {
		return this.jdbcTemplate.update("update tbl_user set userName=?, userPwd=? where uId=?",user.getUserName(),user.getUserPwd(),user.getuId());
	}
	@Override
	public TBlUser getUserByLogin(TBlUser user) {
		Map<String,Object> map = this.jdbcTemplate.queryForMap("select uId,userName,userPwd,userIcon from tbl_user where userName=? and userPwd=?", user.getUserName(),user.getUserPwd());
		user.setuId((Integer)map.get("uId"));
		user.setUserIcon((String)map.get("uIcon"));
		return user;
	}


}

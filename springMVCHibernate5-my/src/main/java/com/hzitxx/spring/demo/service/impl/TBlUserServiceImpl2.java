package com.hzitxx.spring.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.TBlUser;
import com.hzitxx.spring.demo.dao.TBlUserDao2;
import com.hzitxx.spring.demo.model.Page;
import com.hzitxx.spring.demo.service.TBlUserService2;

@Service("tblUserService2")
public class TBlUserServiceImpl2 implements TBlUserService2 {

	@Autowired
	private TBlUserDao2 tblUserDao2;

	@Override
	public int addTBlUser(TBlUser user) {
		return tblUserDao2.addTBlUser(user);
	}

	@Override
	public int deleteTBlUser(int id) {
		return tblUserDao2.deleteTBlUser(id);
	}

	@Override
	public Long getTBlUserLines(String keyword) {
		
		return tblUserDao2.getTBlUserLines(keyword);
	}

	@Override
	public List<TBlUser> getTBlUserList(String keyword, Page page, String orderBy) {
		
		return tblUserDao2.getTBlUserList(keyword, page, orderBy);
	}

	@Override
	public TBlUser getTBlUserbyCheckName(String userName) {
		
		return tblUserDao2.getTBlUserbyCheckName(userName);
	}

	@Override
	public TBlUser getTBlUserbyId(int id) {
		
		return tblUserDao2.getTBlUserbyId(id);
	}

	@Override
	public int updateTBlUser(TBlUser user) {
		
		return tblUserDao2.updateTBlUser(user);
	}
	
	
}

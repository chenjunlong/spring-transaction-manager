package com.junlong.demo.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DemoDao {

	@Resource(name = "jdbcTemplate")
	private JdbcTemplate jdbcTemplate;

	public void insert(String mobile, String name) {
		jdbcTemplate.update("INSERT INTO USER (MOBILE,NAME) VALUES(?,?)", mobile, name);
	}

	public List<Map<String, Object>> getUserByName(String name) {
		//String sql = "SELECT * FROM `USER` WHERE NAME = ?";
		String sql = "SELECT * FROM `USER` WHERE NAME = ? FOR UPDATE";
		return jdbcTemplate.queryForList(sql,name);
	}

	public void updateMobileByName(String mobile, String name) {
		jdbcTemplate.update("UPDATE USER SET MOBILE = ? WHERE NAME = ?", mobile, name);
	}
}

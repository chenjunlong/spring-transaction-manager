package com.junlong.demo.service;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public interface DemoServices {

	void createUser(String mobile, String name);
	
	//@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = RuntimeException.class)
	void getUserByName(String name);

	void updateMobileByName(String mobile, String name);
}

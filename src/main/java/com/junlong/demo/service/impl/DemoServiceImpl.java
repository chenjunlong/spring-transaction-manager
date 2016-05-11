package com.junlong.demo.service.impl;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.junlong.demo.dao.DemoDao;
import com.junlong.demo.service.DemoServices;

@Service("demoService")
public class DemoServiceImpl implements DemoServices {

	@Resource(name = "demoDao")
	private DemoDao demoDao;

	//@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = RuntimeException.class)
	@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = RuntimeException.class)
	@Override
	public void createUser(String mobile, String name) {
		System.out.println("insert start...");
		demoDao.insert(mobile, name);
		System.out.println("insert end...");
		throw new RuntimeException("demo error");
	}

	//@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = RuntimeException.class)
	@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = RuntimeException.class)
	@Override
	public void getUserByName(String name) {
		List<Map<String,Object>> users = demoDao.getUserByName(name);
		for (Map<String, Object> user : users) {
			System.out.println(user.get("MOBILE") + "," + user.get("NAME"));
		}
		try {
			TimeUnit.SECONDS.sleep(30);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("getUserByName ok...");
	}

	//@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = RuntimeException.class)
	@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = RuntimeException.class)
	@Override
	public void updateMobileByName(String mobile, String name) {
		demoDao.updateMobileByName(mobile,name);
		System.out.println("update start...");
		try {
			TimeUnit.SECONDS.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("updateMobileByName ok...");
	}
}

package com.junlong.demo.test;

import javax.annotation.Resource;

import com.junlong.demo.service.impl.DemoServiceTwoImpl;

public class TestInit {
	
//	@Resource(name = "demoService")
//	private DemoServices demoService;
//	
//	public void init(){
//		System.out.println("init" + Thread.currentThread().getId());
//		demoService.getUserByName("test1001");
//	}
	
	@Resource(name = "demoServiceTwo")
	private DemoServiceTwoImpl demoServiceTwoImpl;
	
	public void init(){
		System.out.println("init" + Thread.currentThread().getId());
		demoServiceTwoImpl.getUserByNameWithNoSupportTransactional("test1001");
	}
}

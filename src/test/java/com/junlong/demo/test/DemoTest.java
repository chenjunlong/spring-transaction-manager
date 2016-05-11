package com.junlong.demo.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.junlong.demo.service.DemoServices;
import com.junlong.demo.service.impl.DemoServiceTwoImpl;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class DemoTest {

	@Resource(name = "demoService")
	private DemoServices demoService;

	@Test
	public void createTest() {
		demoService.createUser("13111111111","demo001");
	}
	
	@Test
	public void getTest() {
		demoService.getUserByName("test1001");
	}
	
	@Test
	public void updateTest() {
		demoService.updateMobileByName("13122222222","test1001");
	}
	
	/**
	 * *************************************************************************
	 */
	
	@Resource(name = "demoServiceTwo")
	private DemoServiceTwoImpl demoServiceTwo;
	
	@Test
	public void createTestTwo() {
		demoServiceTwo.createUser("13111111111","demo001");
	}
	
	@Test
	public void getTestTwo() {
		demoServiceTwo.getUserByName("test1001");
	}
	
	@Test
	public void updateTestTwo() {
		demoServiceTwo.updateMobileByName("13122222222","test1001");
	}
}

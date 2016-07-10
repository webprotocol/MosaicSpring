package com.hybrid;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.hybrid.mapper.DeptMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class MosaicSpringApplicationTests {

	@Autowired
	ApplicationContext ctx;
	
	@Autowired
	DeptMapper deptMapper;
	
	@Test
	public void contextLoads() {
		System.out.println(ctx);
	}
	
	@Test
	public void testDeptMapper() {
		System.out.println(deptMapper);
	}	
	
}

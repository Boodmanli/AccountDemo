package com.boodman.mvntest.test;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

/**
 * Unit test for simple App.
 */
@ContextConfiguration(locations={ "classpath*:account-email-test.xml" })

public abstract class AppTest extends AbstractTestNGSpringContextTests{
	public AppTest(){
		
		
	}
	
}
  


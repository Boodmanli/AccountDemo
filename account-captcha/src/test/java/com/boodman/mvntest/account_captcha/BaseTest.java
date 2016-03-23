package com.boodman.mvntest.account_captcha;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

@ContextConfiguration(locations={"classpath*:captcha-test.xml"})
public class BaseTest extends AbstractTestNGSpringContextTests{
	public BaseTest(){}
	
}

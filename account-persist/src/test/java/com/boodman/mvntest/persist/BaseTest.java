package com.boodman.mvntest.persist;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

@ContextConfiguration(locations={"classpath*:test.xml"})
public abstract class BaseTest extends AbstractTestNGSpringContextTests{
	

public BaseTest(){
	
}
}

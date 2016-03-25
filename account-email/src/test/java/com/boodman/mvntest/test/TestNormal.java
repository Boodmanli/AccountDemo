package com.boodman.mvntest.test;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

public class TestNormal {

	@Test
	public void testMap(){
		Map<String , String> map = new HashMap<String, String>();
		map.put("123", "aaa");
		map.put("11", "bbb");
		String test = map.get("123");

		System.out.println(test);
		System.out.println("****"+map.get("11"));
		
	}
}

package com.boodman.mvntest.acptcha.test;

import java.util.HashSet;
import java.util.Set;

import org.testng.annotations.Test;

import com.boodman.mvntest.account.util.CaptchaUtils;

public class RandomeGeneratorTest {

	@Test
	public void testGetRandomString(){
		Set<String> randoms = new HashSet<String>(100);
		for (int i = 0; i < 100; i++) {
			String random = CaptchaUtils.getRandomString();
			randoms.add(random);
		}
		System.out.println("this is ramdoms:");
		System.out.println(randoms);
	}
}

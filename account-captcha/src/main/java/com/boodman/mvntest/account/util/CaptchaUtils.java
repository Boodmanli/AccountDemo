package com.boodman.mvntest.account.util;

import java.util.Random;

public class CaptchaUtils {
	private static String range = "0123456789abcdefghjklmnopqrstuvwxyz";
	
	public static synchronized String getRandomString(){
		Random random = new Random();
		StringBuffer result = new StringBuffer();
		for (int i = 0; i < 8; i++) {
			//获取随机字符
			char chars = range.charAt(random.nextInt(range.length()));
			System.out.println(chars);
			//拼接字符
			result.append(chars);
		}
		System.out.println(result.toString());
		return result.toString();
	}

}

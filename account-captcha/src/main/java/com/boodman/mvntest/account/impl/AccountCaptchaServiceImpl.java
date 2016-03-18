package com.boodman.mvntest.account.impl;

import java.util.List;
import java.util.Properties;

import org.springframework.beans.factory.InitializingBean;

import com.boodman.mvntest.account.api.AccountCaptchaException;
import com.boodman.mvntest.account.api.AccountCaptchaService;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;

public class AccountCaptchaServiceImpl implements AccountCaptchaService,InitializingBean {

	public String generateCaptchaKey() throws AccountCaptchaException {
	
		return null;
	}

	public byte[] generateCaptchaImage(String captchaKey) throws AccountCaptchaException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean validateCaptcha(String captchaKey, String captchaValue) throws AccountCaptchaException {
		// TODO Auto-generated method stub
		return false;
	}

	public List<String> getPreDefinedTexts() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setPreDefinedTexts(List<String> preDefinedTexts) {
		// TODO Auto-generated method stub

	}

	private DefaultKaptcha producer;
	/**
	 * 初始化验证码生成器
	 */
	public void afterPropertiesSet() throws Exception {
		producer = new DefaultKaptcha();
		producer.setConfig(new Config(new Properties()));
	}

}

package com.boodman.mvntest.account.api;

import java.util.List;

public interface AccountCaptchaService {

	/**
	 * 用来生成验证码主键
	 * @return
	 * @throws AccountCaptchaException
	 */
	public String generateCaptchaKey() throws AccountCaptchaException;

	/**
	 * 用来生成验证码图片
	 * @param captchaKey
	 * @return
	 * @throws AccountCaptchaException
	 */
	public byte[] generateCaptchaImage(String captchaKey) throws AccountCaptchaException;
	
	
	/**
	 * 用来验证用户反馈的主键和值
	 * @param captchaKey
	 * @param captchaValue
	 * @return
	 * @throws AccountCaptchaException
	 */
	public boolean validateCaptcha(String captchaKey,String captchaValue) throws AccountCaptchaException;
	

	public List<String> getPreDefinedTexts();
	

	public void setPreDefinedTexts(List<String> preDefinedTexts);
}

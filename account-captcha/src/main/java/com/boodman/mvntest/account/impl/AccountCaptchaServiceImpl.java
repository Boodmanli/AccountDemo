package com.boodman.mvntest.account.impl;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.InitializingBean;

import com.boodman.mvntest.account.api.AccountCaptchaException;
import com.boodman.mvntest.account.api.AccountCaptchaService;
import com.boodman.mvntest.account.util.CaptchaUtils;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;

public class AccountCaptchaServiceImpl implements AccountCaptchaService,InitializingBean {

	private Map<String, String> captchaMap = new HashMap<String, String>();


	private List<String> perDefinedTexts;
	private int textCount=0;
	private DefaultKaptcha producer;
	
	/**
	 * 生成验证码key
	 */
	public String generateCaptchaKey() throws AccountCaptchaException {
	
		//获取随机key
		String key  = CaptchaUtils.getRandomString();
		
		String value = getCaptchaText();
		//写入key，value
		captchaMap.put(key, value);
		return key;
	}
	
	/**
	 * 生成验证码图片
	 */
	public byte[] generateCaptchaImage(String captchaKey) throws AccountCaptchaException {
		String text = captchaMap.get(captchaKey);
		//如果与key对应的value为空
		if (text==null) {
			throw new AccountCaptchaException("Captchakey", captchaKey);
		}
		//生成验证码图片
		BufferedImage image = producer.createImage(text);
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		
		try {
			//将图片输出到out.jpg中
			ImageIO.write(image, "jpg", out);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return out.toByteArray();
	}

	//验证验证码是否正确
	public boolean validateCaptcha(String captchaKey, String captchaValue) throws AccountCaptchaException {
		String text = captchaMap.get(captchaKey);
		if (text==null) {
			throw new AccountCaptchaException("", "");
		}
		if (text.equals(captchaValue)) {
			captchaMap.remove(captchaKey);
		}else {
			return false;
		}
		return false;
	}

	public List<String> getPreDefinedTexts() {
		return perDefinedTexts;
	}

	public void setPreDefinedTexts(List<String> preDefinedTexts) {
		this.perDefinedTexts = preDefinedTexts;

	}


	/**
	 * 初始化验证码生成器
	 */
	public void afterPropertiesSet() throws Exception {
		producer = new DefaultKaptcha();
		producer.setConfig(new Config(new Properties()));
	}

	/**
	 * 创建验证码内容
	 * @return
	 */
	public String getCaptchaText(){
		if (perDefinedTexts!=null&&getPreDefinedTexts().isEmpty()) {
			String text = getPreDefinedTexts().get(textCount);
			textCount = (textCount+1) % getPreDefinedTexts().size();
			return text;
		}else {
			return producer.createText();
		}
		
	}
}

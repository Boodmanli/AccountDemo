package com.boodman.mvntest.acptcha.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import com.boodman.mvntest.account.api.AccountCaptchaException;
import com.boodman.mvntest.account.api.AccountCaptchaService;
import com.boodman.mvntest.account_captcha.BaseTest;

public class AccountCaptchaServicetest extends BaseTest {
	@Autowired
	private AccountCaptchaService accountCaptchaService;
	
	@Test
	public void testGenerateCaptcha(){
		OutputStream output = null;
		try {
			//create key
			String captchaKey = accountCaptchaService.generateCaptchaKey();
			//create image and return
			byte[] captchaImage = accountCaptchaService.generateCaptchaImage(captchaKey);
			//
			File image = new File("target/"+captchaKey+".jpg");
			output = new FileOutputStream(image);
			output.write(captchaImage);
			
		} catch (AccountCaptchaException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if (output!=null) {
				try {
					output.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	@Test
	public void testValidateCaptchaCorrect(){
		List<String> pre = new ArrayList<String>();
		pre.add("123");
		pre.add("abc");
		accountCaptchaService.setPreDefinedTexts(pre);
		
		String captchaKey;
		try {
			captchaKey = accountCaptchaService.generateCaptchaKey();
			accountCaptchaService.generateCaptchaImage(captchaKey);
			boolean b = accountCaptchaService.validateCaptcha(captchaKey, "123");
			System.out.println(b);
		} catch (AccountCaptchaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

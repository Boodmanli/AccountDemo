package com.boodman.mvntest.test;

import org.springframework.beans.factory.annotation.Autowired;

import com.boodman.mvntest.api.AccountEmailService;
import com.boodman.mvntest.exception.AccountEmailException;

public class AccountEmailServiceTest extends AppTest {

	@Autowired
	private AccountEmailService accountEmailService;
	
	@org.junit.Test
	public void testSendEmail() throws InterruptedException{
		try {
			accountEmailService.sendMail("870624632@qq.com", "Test", "Test Second Success!");

		} catch (AccountEmailException e) {
			
			e.printStackTrace();
		}
	}

}

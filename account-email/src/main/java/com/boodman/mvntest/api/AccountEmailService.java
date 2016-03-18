package com.boodman.mvntest.api;

import com.boodman.mvntest.exception.AccountEmailException;

public interface AccountEmailService {
	
	public void sendMail(String to,String subject,String htmlText) throws AccountEmailException;
   
}


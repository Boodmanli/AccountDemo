package com.boodman.mvntest.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.boodman.mvntest.api.AccountEmailService;
import com.boodman.mvntest.exception.AccountEmailException;

@Service("accountEmailService")
public class AccountEmailServiceImpl implements AccountEmailService {

	@Autowired
	private JavaMailSender javaMailSender;
	
	@Value("${email.systemEmail}")
	private String systemEmail;
	
	public void sendMail(String to, String subject, String htmlText) throws AccountEmailException{
		
		
		MimeMessage mailMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mailMessage);
		try {
			System.out.println("setFrom:"+systemEmail);
			mimeMessageHelper.setFrom(systemEmail);
			System.out.println("setTo:"+to);
			mimeMessageHelper.setTo(to);
			mimeMessageHelper.setSubject(subject);
			mimeMessageHelper.setText(htmlText);
			javaMailSender.send(mailMessage);
		} catch (MailException e) {
			e.printStackTrace();
			System.out.println("异常1");
			throw new AccountEmailException("1", e.getMessage());
		} catch (MessagingException e) {
			e.printStackTrace();
			System.out.println("异常2");
			throw new AccountEmailException("2", e.getMessage());
		}
		

	}

	

}

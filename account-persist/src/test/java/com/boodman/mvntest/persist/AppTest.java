package com.boodman.mvntest.persist;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import com.boodman.mvntest.exception.AccountPersistException;
import com.boodman.mvntest.persist.api.AccountPersistService;
import com.boodman.mvntest.persist.api.AccountVO;

/**
 * Unit test for simple App.
 */
public class AppTest extends BaseTest{
	
	@Autowired
	private AccountPersistService accountpersistService;
	
	@Test
	public void testXML(){
		try {
			AccountVO acc = accountpersistService.findAccount("2");
			System.out.println(acc.getId());
			System.out.println(acc.getEmail());
			System.out.println(acc.getName());
			System.out.println(acc.getPassword());
		} catch (AccountPersistException e) {
			System.out.println("调用异常");
			e.printStackTrace();
		}
		
	}
}

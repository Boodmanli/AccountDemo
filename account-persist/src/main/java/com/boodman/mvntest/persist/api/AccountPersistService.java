package com.boodman.mvntest.persist.api;

import com.boodman.mvntest.exception.AccountPersistException;

public interface AccountPersistService {
	
	public AccountVO createAccount(AccountVO accountVO) throws AccountPersistException;
	
	public AccountVO findAccount(String id) throws AccountPersistException;
	

}

package com.boodman.mvntest.exception;

public class AccountPersistException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String code;
	private String msg;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public AccountPersistException(String code,String msg){
		this.code=code;
		this.msg=msg;
	}

}

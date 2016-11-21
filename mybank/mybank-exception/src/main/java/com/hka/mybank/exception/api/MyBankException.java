package com.hka.mybank.exception.api;

/**
 * Custom Exception, represents all functional exceptions that could MyBank app throw
 * 
 * @author MAHASSAN
 *
 */
public class MyBankException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public MyBankException(MyBankErrorInfo errorInfo){
		super(errorInfo.message());
	}

}

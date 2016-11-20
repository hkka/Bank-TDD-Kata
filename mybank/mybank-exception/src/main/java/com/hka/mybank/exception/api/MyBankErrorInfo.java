package com.hka.mybank.exception.api;

/**
 * Enum that represents exceptions messages that could throws MyBank application
 * 
 * @author MAHASSAN
 *
 */
public enum MyBankErrorInfo {
	/**
	 * WithDraw operation is impossible
	 */
	INSUFFUCIENT_FUNDS("Insufficient Funds");
	
	private String message;
	
	MyBankErrorInfo(String msg){
		this.message = msg;
	}
	
	public String message(){
		return message;
	}

}

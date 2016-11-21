package com.hka.mybank.model;

import java.util.stream.Stream;

/**
 * Class that represents Client actor
 * 
 * @author MAHASSAN
 *
 */
public class Client {
	
	// client's account ref
	private Account account;
	
	public Client(Account myAccount){
		this.setAccount(myAccount);
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Stream<Operation> listMyOperations() {		
		return this.account.getOperations();
	}
	
	public void deposit(Double depositAmount){
		this.account.deposit(depositAmount);
	}

}

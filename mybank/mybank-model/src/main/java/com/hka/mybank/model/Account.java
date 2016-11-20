package com.hka.mybank.model;

import java.util.ArrayList;
import java.util.stream.Stream;

import com.hka.mybank.model.utils.CurrentDateFactory;
import com.hka.mybank.model.utils.DateFactory;


public class Account {
	
	private Double balance;
	private Long number;
	
	/**
	 * Will be used to generate relevant time for account operations
	 */
	public static DateFactory df = new CurrentDateFactory();
	
	private ArrayList<Operation> operations;

	public Account(Long accountNumber, Double initialBalance) {
		this.balance = initialBalance;
		operations = new ArrayList<Operation>();
	}

	public void deposit(Double d) {
		this.balance = Double.sum(this.balance, d);
		Operation op = new Operation(OperationType.DEPOSIT, df.getTime(), d, this.balance);
		operations.add(op);
	}

	public Double getBalance() {		
		return balance;
	}

	public void withDraw(Double d) {
		this.balance = this.balance - d;
	}

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}

	public Stream<Operation> getOperations() {
		return operations.stream();
	}

	public void setOperations(ArrayList<Operation> operations) {
		this.operations = operations;
	}
}
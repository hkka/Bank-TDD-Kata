package com.hka.mybank.model.test;

import org.junit.Assert;
import org.junit.Test;

import com.hka.mybank.exception.api.MyBankException;
import com.hka.mybank.model.Account;
import com.hka.mybank.model.Client;
import com.hka.mybank.model.Operation;
import com.hka.mybank.model.OperationType;
import com.hka.mybank.model.test.utils.AccountTestingUtils;
import com.hka.mybank.model.test.utils.FixDateFactory;
import com.hka.mybank.model.utils.DateFactory;

public class ClientTest {
	
	@Test
	public void ShouldCreateAccount(){
		//GIVEN
		Long accountNumber = AccountTestingUtils.generateAnyLongGreaterThanZero();
		Double accountInitBalance = AccountTestingUtils.generateAnyDoubleGreaterThanZero();
		Account expectedAccount = new Account(accountNumber, accountInitBalance);
		
		//WHEN
		Client c = new Client(expectedAccount);
		
		// THEN
		Assert.assertTrue(expectedAccount.equals(c.getAccount()));
	}
	
	@Test
	public void ShouldListOperations() throws MyBankException{
		
		//GIVEN
		Long accountNumber = AccountTestingUtils.generateAnyLongGreaterThanZero();
		Double accountInitBalance = AccountTestingUtils.generateAnyDoubleGreaterThanZero();
		// create a dedicated datefactory for tests
		DateFactory testDateFactory = new FixDateFactory();
		Account.df = testDateFactory;	
		Account acc = new Account(accountNumber, accountInitBalance);
		
		Client c = new Client(acc);
		
		//WHEN
		Double amountToDeposit = AccountTestingUtils.generateAnyDoubleGreaterThanZero();
		c.getAccount().deposit(amountToDeposit);
		Double expectedBalanceAfterOp_1 = Double.sum(accountInitBalance, amountToDeposit);
		Operation expectedOperation_1 = new Operation(OperationType.DEPOSIT, testDateFactory.getTime(), amountToDeposit, expectedBalanceAfterOp_1);
		
		Double amountToWithDraw = AccountTestingUtils.generateAnyDoubleBelowGivenDouble(amountToDeposit);
		c.getAccount().withDraw(amountToWithDraw);
		Double expectedBalanceAfterOp_2 = c.getAccount().getBalance();
		Operation expectedOperation_2 = new Operation(OperationType.WITHDRAW, testDateFactory.getTime(), amountToWithDraw, expectedBalanceAfterOp_2);
		
		//THEN
		Long foundNumberOfOperations = c.listMyOperations().filter(o -> (o.equals(expectedOperation_1) || o.equals(expectedOperation_2))).count();
		Long expectedNumberOfOperations = 2l;
		
		Assert.assertEquals(expectedNumberOfOperations, foundNumberOfOperations);
	}

}
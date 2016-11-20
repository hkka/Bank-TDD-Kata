package com.hka.mybank.model.test;

import org.junit.Assert;
import org.junit.Test;

import com.hka.mybank.model.Account;
import com.hka.mybank.model.Operation;
import com.hka.mybank.model.OperationType;
import com.hka.mybank.model.test.utils.AccountTestingUtils;
import com.hka.mybank.model.test.utils.FixDateFactory;
import com.hka.mybank.model.utils.DateFactory;

public class AccountTest {
	
	/**
	 * Test method for Account deposit operation
	 */
	@Test
	public void ShouldAddMoneyToExistingBalance(){
		
		// GIVEN
		Double initBalanceValue = AccountTestingUtils.generateAnyDoubleGreaterThanZero();
		Long accountNumber = 1l;
		Account myAccount = new Account(accountNumber, initBalanceValue);
		
		// WHEN
		Double moneyToDeposit = AccountTestingUtils.generateAnyDoubleGreaterThanZero();
		myAccount.deposit(moneyToDeposit);
		
		// THEN
		Double expectedBalanceValueAfterDeposit = Double.sum(initBalanceValue, moneyToDeposit);		
		Assert.assertEquals(expectedBalanceValueAfterDeposit, myAccount.getBalance());
	}
	
	/**
	 * Test method for Account withdraw
	 * 
	 */
	@Test
	public void ShouldSubstractMoneyFromExistingBalance(){
		
		// GIVEN
		Double initBalanceValue = AccountTestingUtils.generateAnyDoubleGreaterThanZero();
		Long accountNumber = 1l;
		Account account = new Account(accountNumber, initBalanceValue);
		
		// WHEN
		Double moneyToWithdraw = AccountTestingUtils.generateAnyDoubleGreaterThanZero();
		account.withDraw(moneyToWithdraw);
		
		// THEN
		Double expectedBalanceValueAfterWithdraw = Double.sum(initBalanceValue, - moneyToWithdraw);		
		Assert.assertEquals(expectedBalanceValueAfterWithdraw, account.getBalance());
	}
	
	/**
	 *	After a deposit operation, a relevant operation must be added to account operations list 
	 */
	@Test
	public void ShouldRegisterDateAndAmountAndCurrentBalanceAfterDepositOperation(){
		
		// GIVEN
		OperationType operationType = OperationType.DEPOSIT;		
		Double operationAmount = AccountTestingUtils.generateAnyDoubleGreaterThanZero();
		Double initBalanceValue = AccountTestingUtils.generateAnyDoubleGreaterThanZero();
		Double accountBalanceAfterOperation = Double.sum(initBalanceValue, operationAmount);
		Long accountNumber = AccountTestingUtils.generateAnyLongGreaterThanZero();
		Account myAccount = new Account(accountNumber, initBalanceValue);			
		// create a dedicated datefactory for tests
		DateFactory testDateFactory = new FixDateFactory();
		Account.df = testDateFactory;		
		Operation expectedOperationAfterDeposit = new Operation(operationType, testDateFactory.getTime(), operationAmount, accountBalanceAfterOperation);		
		
		//WHEN
		Double depositAmount = AccountTestingUtils.generateAnyDoubleGreaterThanZero();
		myAccount.deposit(depositAmount);
		
		// THEN
		int nbOfMatchingOperationFound = (int) myAccount.getOperations().filter(o -> o.equals(expectedOperationAfterDeposit)).count();		

		Assert.assertEquals(1, nbOfMatchingOperationFound);
	}
}
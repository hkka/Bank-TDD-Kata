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
	 * Test method for Account withdraw.
	 * 
	 */
	@Test
	public void ShouldSubstractMoneyFromExistingBalanceWhenWithdrawAmountIsGreaterThanCurrentBalance(){
		
		// GIVEN
		Double initBalanceValue = AccountTestingUtils.generateAnyDoubleGreaterThanZero();
		Long accountNumber = 1l;
		Account account = new Account(accountNumber, initBalanceValue);
		
		// WHEN
		Double moneyToWithdraw = AccountTestingUtils.generateAnyDoubleBelowGivenDouble(initBalanceValue);
		try {
			account.withDraw(moneyToWithdraw);
		} catch (Exception e) {
			Assert.fail("Exception occured during withdraw operation : " + e.getMessage());
		}
		
		// THEN
		Double expectedBalanceValueAfterWithdraw = Double.sum(initBalanceValue, - moneyToWithdraw);		
		Assert.assertEquals(expectedBalanceValueAfterWithdraw, account.getBalance());
	}
	
	@Test
	public void ShouldThrowExceptionWhenWithDrawAmountIsGreaterThanCurrentBalance(){
		
		// GIVEN
		Double initBalanceValue = AccountTestingUtils.generateAnyDoubleGreaterThanZero();
		Long accountNumber = 1l;
		Account account = new Account(accountNumber, initBalanceValue);
		
		Exception expectedException = null;
				
		// WHEN
		Double moneyToWithdraw = AccountTestingUtils.generateAnyDoubleGreaterThanGivenDouble(initBalanceValue);
		try {
			account.withDraw(moneyToWithdraw);
		} catch (Exception e) {
			expectedException = e;			
		}
				
		// THEN	
		Assert.assertEquals(expectedException.getMessage(), "Insufficient Funds");
	}
	
	/**
	 *	After a deposit operation, a relevant operation must be added to account operations list 
	 */
	@Test
	public void ShouldRegisterDateAndAmountAndCurrentBalanceAfterDepositOperation(){
		
		// GIVEN
		OperationType operationType = OperationType.DEPOSIT;	
		Double initBalanceValue = AccountTestingUtils.generateAnyDoubleGreaterThanZero();		
		Long accountNumber = AccountTestingUtils.generateAnyLongGreaterThanZero();
		Account myAccount = new Account(accountNumber, initBalanceValue);			
		// create a dedicated datefactory for tests
		DateFactory testDateFactory = new FixDateFactory();
		Account.df = testDateFactory;			
		
		//WHEN		
		Double operationAmount = AccountTestingUtils.generateAnyDoubleGreaterThanZero();
		myAccount.deposit(operationAmount);
		
		Double accountBalanceAfterOperation = Double.sum(initBalanceValue, operationAmount);
		Operation expectedOperationAfterDeposit = new Operation(operationType, testDateFactory.getTime(), operationAmount, accountBalanceAfterOperation);
		
		// THEN
		int nbOfMatchingOperationFound = (int) myAccount.getOperations().filter(o -> o.equals(expectedOperationAfterDeposit)).count();		

		Assert.assertEquals(1, nbOfMatchingOperationFound);
	}
	
	/**
	 *	After a withdraw operation, a relevant operation must be added to account operations list.
	 *
	 *  We suppose that the related withdraw operation is valid ( amount to withdraw < balance amount).
	 */
	@Test
	public void ShouldRegisterDateAndAmountAndCurrentBalanceAfterWithDrawOperation(){
		
		// GIVEN
		OperationType operationType = OperationType.WITHDRAW;		
		Double initBalanceValue = AccountTestingUtils.generateAnyDoubleGreaterThanZero();
			
		
		Long accountNumber = AccountTestingUtils.generateAnyLongGreaterThanZero();
		Account myAccount = new Account(accountNumber, initBalanceValue);			
		// create a dedicated datefactory for tests
		DateFactory testDateFactory = new FixDateFactory();
		Account.df = testDateFactory;						
		
		//WHEN		
		Double operationAmount = AccountTestingUtils.generateAnyDoubleBelowGivenDouble(initBalanceValue);	
		try {
			myAccount.withDraw(operationAmount);
		} catch (Exception e) {
			Assert.fail("Exception occured during withdraw operation : " + e.getMessage());
		}
		
		Double accountBalanceAfterOperation = Double.sum(initBalanceValue, operationAmount);
		Operation expectedOperationAfterDeposit = new Operation(operationType, testDateFactory.getTime(), operationAmount, accountBalanceAfterOperation);
		
		// THEN
		int nbOfMatchingOperationFound = (int) myAccount.getOperations().filter(o -> o.equals(expectedOperationAfterDeposit)).count();		

		Assert.assertEquals(1, nbOfMatchingOperationFound);
	}
}